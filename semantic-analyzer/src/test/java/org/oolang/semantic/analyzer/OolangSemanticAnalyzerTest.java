/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.semantic.analyzer;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.oolang.KlassesCacheInterceptor;
import org.oolang.ast.AstFile;
import org.oolang.ast.AstFileWriter;
import org.oolang.ast.Import;
import org.oolang.ast.element.ClassBody;
import org.oolang.ast.element.RealElement;
import org.oolang.ast.expression.ConstantExpression;
import org.oolang.ast.expression.LoadExpression;
import org.oolang.ast.expression.RealExpression;
import org.oolang.ast.statement.CodeBlock;
import org.oolang.ast.statement.ConstructorCodeBlock;
import org.oolang.ast.statement.RealStatement;
import org.oolang.parser.OolangAstVisitor;
import org.oolang.parser.generated.OolangLexer;
import org.oolang.parser.generated.OolangParser;

import java.lang.constant.ConstantDescs;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.oolang.JvmInvocationUtils.*;
import static org.oolang.ast.element.RealElement.ElementType.FUN;
import static org.oolang.ast.element.RealElement.ElementType.PROPERTY_INITIALIZER;
import static org.oolang.ast.expression.RealExpression.ExpressionType.*;
import static org.oolang.ast.statement.RealStatement.StatementType.RETURN;

@ExtendWith(KlassesCacheInterceptor.class)
public class OolangSemanticAnalyzerTest {

    @Test
    public void symbolTableOfClassWithProperty() {
        var astFile = astForCode("""
                package com.example
                class Example {
                val foo: String
                }""");
        var root = astFile.rootElements.getFirst();
        var classBody = (ClassBody) root.children.getFirst();
        var property = classBody.children.getFirst();
        assertThat(property.type).isNotNull();
        assertThat(property.type.descriptorString).isEqualTo("Ljava/lang/String;");
        assertThat(property.children).isEmpty();
    }

    @Test
    public void parseClassWithSimpleFunction() {
        var astFile = astForCode("""
                package com.example
                import java.math.BigInteger
                class Example {
                fun foo(): BigInteger {}
                }""");
        var root = astFile.rootElements.getFirst();
        var classBody = (ClassBody) root.children.getFirst();
        var funDeclaration = classBody.children.getFirst();
        assertThat(funDeclaration.type).isNotNull();
        assertThat(funDeclaration.type.descriptorString).isEqualTo("Ljava/math/BigInteger;");
    }

    @Test
    public void parseClassWithFunctionWithParameters() {
        var astFile = astForCode("""
                package com.example
                class Example {
                fun foo(bar: Int, baz: Long) {}
                }""");
        var root = astFile.rootElements.getFirst();
        var classBody = (ClassBody) root.children.getFirst();
        var funDeclaration = classBody.children.getFirst();
        assertThat(funDeclaration.type).isNull();
        var funParam1 = (RealElement) funDeclaration.children.getFirst();
        assertThat(funParam1.type).isNotNull();
        assertThat(funParam1.type.descriptorString).isEqualTo("I");
        var funParam2 = (RealElement) funDeclaration.children.get(1);
        assertThat(funParam2.type).isNotNull();
        assertThat(funParam2.type.descriptorString).isEqualTo("J");
    }

    @Test
    public void parseClassWithMainFunction() {
        var astFile = astForCode("""
                package com.example
                class Example {
                static fun main(args: Array<String>) {
                System.out.println("Hello, World!")
                }
                }""");
        var chainable = verifyMainUntilStatement(astFile);
        assertThat(chainable.expressionType).isEqualTo(CHAINABLE);
        assertThat(chainable.children).hasSize(2);
        var propAccess = (RealExpression) chainable.children.getFirst();
        assertThat(propAccess.expressionType).isEqualTo(PROP_ACCESS);
        assertThat(propAccess.invocation).isEqualTo(GET_STATIC);
        assertThat(propAccess.ownerDescriptorString).isEqualTo("Ljava/lang/System;");
        assertThat(propAccess.identifiers).hasSize(1);
        assertThat(propAccess.identifiers.getFirst().identifier).isEqualTo("out");
        assertThat(propAccess.descriptorString()).isEqualTo("Ljava/io/PrintStream;");
        assertThat(propAccess.children).isEmpty();

        var funCall = (RealExpression) chainable.children.getLast();
        assertThat(funCall.expressionType).isEqualTo(FUN_CALL);
        assertThat(funCall.invocation).isEqualTo(INVOKE_VIRTUAL);
        assertThat(funCall.ownerDescriptorString).isEqualTo("Ljava/io/PrintStream;");
        assertThat(funCall.identifiers).hasSize(1);
        assertThat(funCall.identifiers.getFirst().identifier).isEqualTo("println");
        assertThat(funCall.descriptorString()).isEqualTo("V");
        assertThat(funCall.typeDescriptorString).isEqualTo("(Ljava/lang/String;)V");
        assertThat(funCall.children).hasSize(1);

        var funCallParam = (RealExpression) funCall.children.getFirst();
        assertThat(funCallParam.expressionType).isEqualTo(FUN_CALL_PARAMETER);
        assertThat(funCallParam.ownerDescriptorString).isNull();
        assertThat(funCallParam.identifiers).isEmpty();
        assertThat(funCallParam.typeDescriptorString).isNull();
        assertThat(funCallParam.children).hasSize(1);
        var funCallParamString = (ConstantExpression) funCallParam.children.getFirst();
        assertThat(funCallParamString.value).isEqualTo("Hello, World!");
        print(astFile);
    }

    @Test
    public void parseClassWithMainFunctionAndParameterUsage() {
        var astFile = astForCode("""
                package com.example
                class Example {
                static fun main(args: Array<String>) {
                System.out.println("Hello, " + args[0] + " and " + args[1])
                }
                }""");
        var chainable = verifyMainUntilStatement(astFile);
        assertThat(chainable.children).hasSize(2);
        var funCall = (RealExpression) chainable.children.getLast();
        assertThat(funCall.children).hasSize(1);
        var funCallParam = (RealExpression) funCall.children.getFirst();
        assertThat(funCallParam.children).hasSize(1);
        var funCallParamAdd = (RealExpression) funCallParam.content().getFirst();
        assertThat(funCallParamAdd.description()).isEqualTo("Expression(add)");
        assertThat(funCallParamAdd.expressionType).isEqualTo(ADD);
        assertThat(funCallParamAdd.ownerDescriptorString).isNull();
        assertThat(funCallParamAdd.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(funCallParamAdd.content()).hasSize(4);

        var funCallParamConstant1 = (ConstantExpression) funCallParamAdd.content().get(0);
        assertThat(funCallParamConstant1.description()).isEqualTo("ConstantExpression(\"Hello, \")");
        assertThat(funCallParamConstant1.descriptorString()).isEqualTo("Ljava/lang/String;");

        var funCallParamChainable1 = (RealExpression) funCallParamAdd.content().get(1);
        assertThat(funCallParamChainable1.description()).isEqualTo("Expression(chainable)");
        assertThat(funCallParamChainable1.expressionType).isEqualTo(CHAINABLE);
        assertThat(funCallParamChainable1.content()).hasSize(2);
        var funCallParamArrayLoad1 = (LoadExpression) funCallParamChainable1.content().getFirst();
        assertThat(funCallParamArrayLoad1.description()).isEqualTo("LoadExpression(args, 0)");
        assertThat(funCallParamArrayLoad1.descriptorString()).isEqualTo("[Ljava/lang/String;");
        var funCallParamArray1 = (RealExpression) funCallParamChainable1.content().getLast();
        assertThat(funCallParamArray1.description()).isEqualTo("Expression(indexing)");
        assertThat(funCallParamArray1.expressionType).isEqualTo(INDEXING);
        assertThat(funCallParamArray1.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(funCallParamArray1.parent).isEqualTo(funCallParamChainable1);
        assertThat(funCallParamArray1.content()).hasSize(1);
        var funCallParamArrayIndex1 = (ConstantExpression) funCallParamArray1.content().getFirst();
        assertThat(funCallParamArrayIndex1.description()).isEqualTo("ConstantExpression(0)");

        var funCallParamConstant2 = (ConstantExpression) funCallParamAdd.content().get(2);
        assertThat(funCallParamConstant2.description()).isEqualTo("ConstantExpression(\" and \")");
        assertThat(funCallParamConstant2.descriptorString()).isEqualTo("Ljava/lang/String;");

        var funCallParamChainable2 = (RealExpression) funCallParamAdd.content().get(3);
        assertThat(funCallParamChainable2.description()).isEqualTo("Expression(chainable)");
        assertThat(funCallParamChainable2.expressionType).isEqualTo(CHAINABLE);
        assertThat(funCallParamChainable2.content()).hasSize(2);
        var funCallParamArrayLoad2 = (LoadExpression) funCallParamChainable2.content().getFirst();
        assertThat(funCallParamArrayLoad2.description()).isEqualTo("LoadExpression(args, 0)");
        assertThat(funCallParamArrayLoad2.descriptorString()).isEqualTo("[Ljava/lang/String;");
        var funCallParamArray2 = (RealExpression) funCallParamChainable2.content().getLast();
        assertThat(funCallParamArray2.description()).isEqualTo("Expression(indexing)");
        assertThat(funCallParamArray2.expressionType).isEqualTo(INDEXING);
        assertThat(funCallParamArray2.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(funCallParamArray2.parent).isEqualTo(funCallParamChainable2);
        assertThat(funCallParamArray2.content()).hasSize(1);
        var funCallParamArrayIndex2 = (ConstantExpression) funCallParamArray2.content().getFirst();
        assertThat(funCallParamArrayIndex2.description()).isEqualTo("ConstantExpression(1)");

        print(astFile);
    }

    private @NonNull RealExpression verifyMainUntilStatement(AstFile astFile) {
        var root = astFile.rootElements.getFirst();
        var classBody = (ClassBody) root.children.getFirst();
        var funDeclaration = classBody.children.getFirst();
        assertThat(funDeclaration.type).isNull();
        assertThat(funDeclaration.children).hasSize(2);
        var funParam = (RealElement) funDeclaration.children.getFirst();
        assertThat(funParam.type).isNotNull();
        assertThat(funParam.type.descriptorString).isEqualTo("[Ljava/lang/String;");
        assertThat(funDeclaration.children.getLast()).isInstanceOf(CodeBlock.class);
        var codeBlock = (CodeBlock) funDeclaration.children.getLast();
        var statement = (RealStatement) codeBlock.statements.getFirst();
        return (RealExpression) statement.children.getFirst();
    }

    @Test
    public void parseClassWithMainFunctionAndStaticPropertyUsage() {
        var astFile = astForCode("""
                package com.example
                class Example {
                static val PROP = "Hello, World!"
                static fun main(args: Array<String>) {
                System.out.println(PROP)
                }
                }""");
        var root = astFile.rootElements.getFirst();
        var classBody = (ClassBody) root.children.getFirst();
        assertThat(classBody.children).hasSize(2);
        var property = classBody.children.get(0);
        assertThat(property.type).isNull();
        assertThat(property.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(property.children).hasSize(1);
        var propertyInit = (RealElement) property.children.getFirst();
        assertThat(propertyInit.elementType).isEqualTo(PROPERTY_INITIALIZER);
        var propertyExpression = (ConstantExpression) propertyInit.children.getFirst();
        assertThat(propertyExpression.descriptorString()).isEqualTo("Ljava/lang/String;");

        // we do not check everything this time, full verification is done in previous tests
        var funDeclaration = classBody.children.get(1);
        var codeBlock = (CodeBlock) funDeclaration.children.getLast();
        var statement = (RealStatement) codeBlock.statements.getFirst();
        var chainable = (RealExpression) statement.children.getFirst();
        var funCall = (RealExpression) chainable.children.getLast();
        var funCallParam = (RealExpression) funCall.children.getLast();
        assertThat(funCallParam.expressionType).isEqualTo(FUN_CALL_PARAMETER);
        assertThat(funCallParam.ownerDescriptorString).isNull();
        assertThat(funCallParam.identifiers).isEmpty();
        assertThat(funCallParam.typeDescriptorString).isNull();
        assertThat(funCallParam.children).hasSize(1);

        var funCallParamPropAccess = (RealExpression) funCallParam.children.getFirst();
        assertThat(funCallParamPropAccess.expressionType).isEqualTo(PROP_ACCESS);
        assertThat(funCallParamPropAccess.description()).isEqualTo("Expression(prop_access PROP)");
        assertThat(funCallParamPropAccess.ownerDescriptorString).isEqualTo("Lcom/example/Example;");
        assertThat(funCallParamPropAccess.invocation).isEqualTo("getStatic");
        assertThat(funCallParamPropAccess.identifiers).hasSize(1);
        assertThat(funCallParamPropAccess.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(funCallParamPropAccess.children).isEmpty();

        print(astFile);
    }

    @Test
    public void parseClassWithMainFunctionAndInstancePropertyUsage() {
        var astFile = astForCode("""
                package com.example
                class Example {
                val prop = "Hello, World!"
                static fun main(args: Array<String>) {
                System.out.println(new Example().prop)
                }
                }""");

        var root = astFile.rootElements.getFirst();
        var classBody = (ClassBody) root.children.getFirst();
        assertThat(classBody.children).hasSize(4);
        var property = classBody.children.getFirst();
        assertThat(property.type).isNull();
        assertThat(property.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(property.children).hasSize(1);
        var propertyInit = (RealElement) property.children.getFirst();
        assertThat(propertyInit.elementType).isEqualTo(PROPERTY_INITIALIZER);
        var propertyExpression = (ConstantExpression) propertyInit.children.getFirst();
        assertThat(propertyExpression.descriptorString()).isEqualTo("Ljava/lang/String;");

        verifyMainWithPropUsageAndPropGetter(classBody);

        var defaultConstructor = classBody.children.getLast();
        assertThat(defaultConstructor.type).isNull();
        assertThat(defaultConstructor.description()).isEqualTo("Element(constructor <init>)");
        assertThat(defaultConstructor.modifiers).hasSize(1);
        assertThat(defaultConstructor.modifiers.getFirst().modifier).isEqualTo("open");
        assertThat(defaultConstructor.children).hasSize(1);
        var constructorCodeBlock = (ConstructorCodeBlock) defaultConstructor.children.getFirst();
        assertThat(constructorCodeBlock.earlyLarvalStatements).hasSize(1);
        var assignmentStatement = (RealStatement) constructorCodeBlock.earlyLarvalStatements.getFirst();
        assertThat(assignmentStatement.children).hasSize(1);

        var assignmentChainable = (RealExpression) assignmentStatement.children.getFirst();
        assertThat(assignmentChainable.expressionType).isEqualTo(CHAINABLE);
        assertThat(assignmentChainable.content()).hasSize(3);

        var assignmentLoad = (LoadExpression) assignmentChainable.content().get(0);
        assertThat(assignmentLoad.description()).isEqualTo("LoadExpression(this, 0)");
        assertThat(assignmentLoad.descriptorString()).isEqualTo("Lcom/example/Example;");

        var constant = (ConstantExpression) assignmentChainable.content().get(1);
        assertThat(constant.value).isEqualTo("Hello, World!");

        var propAssignment = (RealExpression) assignmentChainable.content().get(2);
        assertThat(propAssignment.expressionType).isEqualTo(PROP_ASSIGNMENT);
        assertThat(propAssignment.description()).isEqualTo("Expression(prop_assignment prop)");
        assertThat(propAssignment.ownerDescriptorString).isEqualTo("Lcom/example/Example;");
        assertThat(propAssignment.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(propAssignment.invocation).isEqualTo(PUT_FIELD);
        assertThat(propAssignment.content()).isEmpty();

        assertThat(constructorCodeBlock.initCall).isNotNull();
        var superCall = constructorCodeBlock.initCall;
        assertThat(superCall.expressionType).isEqualTo(CHAINABLE);
        assertThat(superCall.content()).hasSize(2);

        var superCallLoad = (LoadExpression) superCall.content().getFirst();
        assertThat(superCallLoad.description()).isEqualTo("LoadExpression(this, 0)");
        assertThat(superCallLoad.descriptorString()).isEqualTo("Lcom/example/Example;");

        var superFunCall = (RealExpression) superCall.content().getLast();
        assertThat(superFunCall.expressionType).isEqualTo(FUN_CALL);
        assertThat(superFunCall.type).isNull();
        assertThat(superFunCall.invocation).isEqualTo(INVOKE_SPECIAL);
        assertThat(superFunCall.ownerDescriptorString).isEqualTo("Ljava/lang/Object;");
        assertThat(superFunCall.identifiers).hasSize(1);
        assertThat(superFunCall.identifiers.getFirst().identifier).isEqualTo(ConstantDescs.INIT_NAME);
        assertThat(superFunCall.descriptorString()).isNull();
        assertThat(superFunCall.typeDescriptorString).isEqualTo("()V");
        assertThat(superFunCall.content()).isEmpty();

        print(astFile);
    }

    @Test
    public void parseClassWithMainFunctionAndStaticAndInstancePropertiesUsage() {
        var astFile = astForCode("""
                package com.example
                class Example {
                private static val HELLO = "Hello, "
                val prop = HELLO + "World!"
                static fun main(args: Array<String>) {
                System.out.println(new Example().prop)
                }
                }""");

        var root = astFile.rootElements.getFirst();
        var classBody = (ClassBody) root.children.getFirst();
        assertThat(classBody.children).hasSize(5);
        var property = classBody.children.getFirst();
        assertThat(property.type).isNull();
        assertThat(property.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(property.children).hasSize(1);
        var propertyInit = (RealElement) property.children.getFirst();
        assertThat(propertyInit.elementType).isEqualTo(PROPERTY_INITIALIZER);
        var propertyExpression = (ConstantExpression) propertyInit.children.getFirst();
        assertThat(propertyExpression.descriptorString()).isEqualTo("Ljava/lang/String;");

        verifyMainWithPropUsageAndPropGetter(classBody);

        var defaultConstructor = classBody.children.getLast();
        assertThat(defaultConstructor.type).isNull();
        assertThat(defaultConstructor.description()).isEqualTo("Element(constructor <init>)");
        assertThat(defaultConstructor.modifiers).hasSize(1);
        assertThat(defaultConstructor.modifiers.getFirst().modifier).isEqualTo("open");
        assertThat(defaultConstructor.children).hasSize(1);
        var constructorCodeBlock = (ConstructorCodeBlock) defaultConstructor.children.getFirst();
        assertThat(constructorCodeBlock.earlyLarvalStatements).hasSize(1);
        var assignmentStatement = (RealStatement) constructorCodeBlock.earlyLarvalStatements.getFirst();
        assertThat(assignmentStatement.children).hasSize(1);

        var assignmentChainable = (RealExpression) assignmentStatement.children.getFirst();
        assertThat(assignmentChainable.expressionType).isEqualTo(CHAINABLE);
        assertThat(assignmentChainable.content()).hasSize(3);

        var assignmentLoad = (LoadExpression) assignmentChainable.content().get(0);
        assertThat(assignmentLoad.description()).isEqualTo("LoadExpression(this, 0)");
        assertThat(assignmentLoad.descriptorString()).isEqualTo("Lcom/example/Example;");

        var assignmentConcat = (RealExpression) assignmentChainable.content().get(1);
        assertThat(assignmentConcat.expressionType).isEqualTo(ADD);
        assertThat(assignmentConcat.children).hasSize(2);

        var assignmentPropAccess = (RealExpression) assignmentConcat.children.getFirst();
        assertThat(assignmentPropAccess.expressionType).isEqualTo(PROP_ACCESS);
        assertThat(assignmentPropAccess.description()).isEqualTo("Expression(prop_access HELLO)");
        assertThat(assignmentPropAccess.ownerDescriptorString).isEqualTo("Lcom/example/Example;");
        assertThat(assignmentPropAccess.invocation).isEqualTo("getStatic");
        assertThat(assignmentPropAccess.identifiers).hasSize(1);
        assertThat(assignmentPropAccess.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(assignmentPropAccess.children).isEmpty();

        var constant = (ConstantExpression) assignmentConcat.children.getLast();
        assertThat(constant.value).isEqualTo("World!");

        var propAssignment = (RealExpression) assignmentChainable.content().get(2);
        assertThat(propAssignment.expressionType).isEqualTo(PROP_ASSIGNMENT);
        assertThat(propAssignment.description()).isEqualTo("Expression(prop_assignment prop)");
        assertThat(propAssignment.ownerDescriptorString).isEqualTo("Lcom/example/Example;");
        assertThat(propAssignment.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(propAssignment.invocation).isEqualTo(PUT_FIELD);
        assertThat(propAssignment.content()).isEmpty();

        assertThat(constructorCodeBlock.initCall).isNotNull();
        var superCall = constructorCodeBlock.initCall;
        assertThat(superCall.expressionType).isEqualTo(CHAINABLE);
        assertThat(superCall.content()).hasSize(2);

        var superCallLoad = (LoadExpression) superCall.content().getFirst();
        assertThat(superCallLoad.description()).isEqualTo("LoadExpression(this, 0)");
        assertThat(superCallLoad.descriptorString()).isEqualTo("Lcom/example/Example;");

        var superFunCall = (RealExpression) superCall.content().getLast();
        assertThat(superFunCall.expressionType).isEqualTo(FUN_CALL);
        assertThat(superFunCall.type).isNull();
        assertThat(superFunCall.invocation).isEqualTo(INVOKE_SPECIAL);
        assertThat(superFunCall.ownerDescriptorString).isEqualTo("Ljava/lang/Object;");
        assertThat(superFunCall.identifiers).hasSize(1);
        assertThat(superFunCall.identifiers.getFirst().identifier).isEqualTo(ConstantDescs.INIT_NAME);
        assertThat(superFunCall.descriptorString()).isNull();
        assertThat(superFunCall.typeDescriptorString).isEqualTo("()V");
        assertThat(superFunCall.content()).isEmpty();

        print(astFile);
    }

    private void verifyMainWithPropUsageAndPropGetter(ClassBody classBody) {
        // we do not check everything this time, full verification is done in previous tests
        var funDeclaration = classBody.children.get(classBody.children.size() - 3);
        var codeBlock = (CodeBlock) funDeclaration.children.getLast();
        var statement = (RealStatement) codeBlock.statements.getFirst();
        var chainable = (RealExpression) statement.children.getFirst();
        var funCall = (RealExpression) chainable.children.getLast();

        var funCallParam = (RealExpression) funCall.children.getLast();
        assertThat(funCallParam.expressionType).isEqualTo(FUN_CALL_PARAMETER);
        assertThat(funCallParam.ownerDescriptorString).isNull();
        assertThat(funCallParam.identifiers).isEmpty();
        assertThat(funCallParam.typeDescriptorString).isNull();
        assertThat(funCallParam.children).hasSize(1);

        var funCallParamChainable = (RealExpression) funCallParam.content().getFirst();
        assertThat(funCallParamChainable.expressionType).isEqualTo(CHAINABLE);
        assertThat(funCallParamChainable.content()).hasSize(3);

        var funCallParamNew = (RealExpression) funCallParamChainable.content().get(0);
        assertThat(funCallParamNew.expressionType).isEqualTo(NEW);
        assertThat(funCallParamNew.parent).isEqualTo(funCallParamChainable);
        assertThat(funCallParamNew.descriptorString()).isEqualTo("Lcom/example/Example;");

        var funCallParamClassInstantiation = (RealExpression) funCallParamChainable.content().get(1);
        assertThat(funCallParamClassInstantiation.expressionType).isEqualTo(FUN_CALL);
        assertThat(funCallParamClassInstantiation.parent).isEqualTo(funCallParamChainable);
        assertThat(funCallParamClassInstantiation.type).isNotNull();
        assertThat(funCallParamClassInstantiation.type.description()).isEqualTo("Type(Example)");
        assertThat(funCallParamClassInstantiation.invocation).isEqualTo(INVOKE_SPECIAL);
        assertThat(funCallParamClassInstantiation.ownerDescriptorString).isEqualTo("Lcom/example/Example;");
        assertThat(funCallParamClassInstantiation.identifiers).hasSize(1);
        assertThat(funCallParamClassInstantiation.identifiers.getFirst().identifier).isEqualTo(ConstantDescs.INIT_NAME);
        assertThat(funCallParamClassInstantiation.descriptorString()).isEqualTo("Lcom/example/Example;");
        assertThat(funCallParamClassInstantiation.typeDescriptorString).isEqualTo("()V");
        assertThat(funCallParamClassInstantiation.content()).isEmpty();

        var funCallParamPropAccess = (RealExpression) funCallParamChainable.content().get(2);
        assertThat(funCallParamPropAccess.expressionType).isEqualTo(PROP_ACCESS);
        assertThat(funCallParamClassInstantiation.parent).isEqualTo(funCallParamChainable);
        assertThat(funCallParamPropAccess.description()).isEqualTo("Expression(prop_access prop)");
        assertThat(funCallParamPropAccess.ownerDescriptorString).isEqualTo("Lcom/example/Example;");
        assertThat(funCallParamPropAccess.invocation).isEqualTo("getField");
        assertThat(funCallParamPropAccess.identifiers).hasSize(1);
        assertThat(funCallParamPropAccess.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(funCallParamPropAccess.children).isEmpty();

        var propertyGetter = classBody.children.get(classBody.children.size() - 2);
        assertThat(propertyGetter.elementType).isEqualTo(FUN);
        assertThat(propertyGetter.type).isNull();
        assertThat(propertyGetter.description()).isEqualTo("Element(fun prop)");
        assertThat(propertyGetter.modifiers).isEmpty();
        assertThat(propertyGetter.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(propertyGetter.hasCustomAttribute).isTrue();
        assertThat(propertyGetter.children).hasSize(1);
        var propertyGetterCodeBlock = (CodeBlock) propertyGetter.children.getFirst();
        assertThat(propertyGetterCodeBlock.statements).hasSize(1);
        var propertyGetterReturn = (RealStatement) propertyGetterCodeBlock.statements.getFirst();
        assertThat(propertyGetterReturn.statementType).isEqualTo(RETURN);
        assertThat(propertyGetterReturn.children).hasSize(1);
        var chainablePropertyAccess = (RealExpression) propertyGetterReturn.children.getFirst();
        assertThat(chainablePropertyAccess.expressionType).isEqualTo(CHAINABLE);
        assertThat(chainablePropertyAccess.children).hasSize(2);
        var propertyAccessLoad = (LoadExpression) chainablePropertyAccess.children.getFirst();
        assertThat(propertyAccessLoad.description()).isEqualTo("LoadExpression(this, 0)");
        assertThat(propertyAccessLoad.descriptorString()).isEqualTo("Lcom/example/Example;");
        var propertyAccess = (RealExpression) chainablePropertyAccess.children.getLast();
        assertThat(propertyAccess.expressionType).isEqualTo(PROP_ACCESS);
        assertThat(propertyAccess.description()).isEqualTo("Expression(prop_access prop)");
        assertThat(propertyAccess.ownerDescriptorString).isEqualTo("Lcom/example/Example;");
        assertThat(propertyAccess.invocation).isEqualTo("getField");
        assertThat(propertyAccess.identifiers).hasSize(1);
        assertThat(propertyAccess.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(propertyAccess.children).isEmpty();
    }

    private static AstFile astForCode(String code) {
        var parser = new OolangParser(new CommonTokenStream(new OolangLexer(CharStreams.fromString(code))));
        var oolangFile = parser.oolangFile();
        var visitor = new OolangAstVisitor();
        var astFile = visitor.visitOolangFile(oolangFile);
        OolangSemanticAnalyzer.semanticAnalysis(astFile);
        return astFile;
    }

    /// Expose this package-protected function to other tests
    public static Map<String, String> buildImports(final List<Import> astImports) {
        return OolangSemanticAnalyzer.buildImports(astImports);
    }

    private static void print(AstFile astFile) {
        System.out.println("AstFile:");
        new AstFileWriter(astFile).write(System.out, true);
        System.out.println();
    }
}
