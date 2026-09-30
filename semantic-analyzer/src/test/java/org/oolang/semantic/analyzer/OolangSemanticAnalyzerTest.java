/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
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
import org.oolang.ast.statement.RealStatement;
import org.oolang.parser.OolangAstVisitor;
import org.oolang.parser.generated.OolangLexer;
import org.oolang.parser.generated.OolangParser;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.oolang.ast.element.RealElement.ElementType.PROPERTY_INITIALIZER;
import static org.oolang.ast.expression.JvmInvocationUtils.GET_STATIC;
import static org.oolang.ast.expression.JvmInvocationUtils.INVOKE_VIRTUAL;
import static org.oolang.ast.expression.RealExpression.ExpressionType.*;

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
        var funCall = verifyMainUntilStatement(astFile);
        assertThat(funCall.type).isEqualTo(FUN_CALL);
        assertThat(funCall.children).hasSize(2);
        var propAccess = (RealExpression) funCall.children.getFirst();
        assertThat(propAccess.type).isEqualTo(PROP_ACCESS);
        assertThat(propAccess.invocation).isEqualTo(GET_STATIC);
        assertThat(propAccess.ownerDescriptorString).isEqualTo("Ljava/lang/System;");
        assertThat(propAccess.identifiers).hasSize(1);
        assertThat(propAccess.identifiers.getFirst().identifier).isEqualTo("out");
        assertThat(propAccess.descriptorString()).isEqualTo("Ljava/io/PrintStream;");
        assertThat(propAccess.children).isEmpty();
        var funCallParam = (RealExpression) funCall.children.getLast();
        assertThat(funCallParam.type).isEqualTo(FUN_CALL_PARAMETER);
        assertThat(funCallParam.ownerDescriptorString).isNull();
        assertThat(funCallParam.identifiers).isEmpty();
        assertThat(funCallParam.typeDescriptorString).isNull();
        assertThat(funCallParam.children).hasSize(1);
        var funCallParamString = (ConstantExpression) funCallParam.children.getFirst();
        assertThat(funCallParamString.value).isEqualTo("Hello, World!");
        assertThat(funCall.invocation).isEqualTo(INVOKE_VIRTUAL);
        assertThat(funCall.ownerDescriptorString).isEqualTo("Ljava/io/PrintStream;");
        assertThat(funCall.identifiers).hasSize(1);
        assertThat(funCall.identifiers.getFirst().identifier).isEqualTo("println");
        assertThat(funCall.descriptorString()).isEqualTo("V");
        assertThat(funCall.typeDescriptorString).isEqualTo("(Ljava/lang/String;)V");
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
        var funCall = verifyMainUntilStatement(astFile);
        assertThat(funCall.children).hasSize(2);
        var funCallParam = (RealExpression) funCall.children.getLast();
        assertThat(funCallParam.children).hasSize(1);
        var funCallParamAdd = (RealExpression) funCallParam.content().getFirst();
        assertThat(funCallParamAdd.description()).isEqualTo("Expression(add)");
        assertThat(funCallParamAdd.type).isEqualTo(ADD);
        assertThat(funCallParamAdd.ownerDescriptorString).isNull();
        assertThat(funCallParamAdd.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(funCallParamAdd.content()).hasSize(4);

        var funCallParamConstant1 = (ConstantExpression) funCallParamAdd.content().get(0);
        assertThat(funCallParamConstant1.description()).isEqualTo("ConstantExpression(\"Hello, \")");
        assertThat(funCallParamConstant1.descriptorString()).isEqualTo("Ljava/lang/String;");

        var funCallParamArray1 = (RealExpression) funCallParamAdd.content().get(1);
        assertThat(funCallParamArray1.description()).isEqualTo("Expression(indexing)");
        assertThat(funCallParamArray1.type).isEqualTo(INDEXING);
        assertThat(funCallParamArray1.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(funCallParamArray1.content()).hasSize(2);
        var funCallParamArrayLoad1 = (LoadExpression) funCallParamArray1.content().getFirst();
        assertThat(funCallParamArrayLoad1.description()).isEqualTo("LoadExpression(args, 0)");
        assertThat(funCallParamArrayLoad1.descriptorString()).isEqualTo("[Ljava/lang/String;");
        var funCallParamArrayIndex1 = (ConstantExpression) funCallParamArray1.content().getLast();
        assertThat(funCallParamArrayIndex1.description()).isEqualTo("ConstantExpression(0)");

        var funCallParamConstant2 = (ConstantExpression) funCallParamAdd.content().get(2);
        assertThat(funCallParamConstant2.description()).isEqualTo("ConstantExpression(\" and \")");
        assertThat(funCallParamConstant2.descriptorString()).isEqualTo("Ljava/lang/String;");

        var funCallParamArray2 = (RealExpression) funCallParamAdd.content().get(3);
        assertThat(funCallParamArray2.description()).isEqualTo("Expression(indexing)");
        assertThat(funCallParamArray2.type).isEqualTo(INDEXING);
        assertThat(funCallParamArray2.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(funCallParamArray2.content()).hasSize(2);
        var funCallParamArrayLoad2 = (LoadExpression) funCallParamArray2.content().getFirst();
        assertThat(funCallParamArrayLoad2.description()).isEqualTo("LoadExpression(args, 0)");
        assertThat(funCallParamArrayLoad2.descriptorString()).isEqualTo("[Ljava/lang/String;");
        var funCallParamArrayIndex2 = (ConstantExpression) funCallParamArray2.content().getLast();
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
    public void parseClassWithMainFunctionAndPropertyUsage() {
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
        var property = classBody.children.getFirst();
        assertThat(property.type).isNull();
        assertThat(property.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(property.children).hasSize(1);
        var propertyInit = (RealElement) property.children.getFirst();
        assertThat(propertyInit.elementType).isEqualTo(PROPERTY_INITIALIZER);
        var propertyExpression = (ConstantExpression) propertyInit.children.getFirst();
        assertThat(propertyExpression.descriptorString()).isEqualTo("Ljava/lang/String;");

        // we do not check everything this time, full verification is done in previous tests
        var funDeclaration = classBody.children.getLast();
        var codeBlock = (CodeBlock) funDeclaration.children.getLast();
        var statement = (RealStatement) codeBlock.statements.getFirst();
        var funCall = (RealExpression) statement.children.getFirst();
        var funCallParam = (RealExpression) funCall.children.getLast();
        assertThat(funCallParam.type).isEqualTo(FUN_CALL_PARAMETER);
        assertThat(funCallParam.ownerDescriptorString).isNull();
        assertThat(funCallParam.identifiers).isEmpty();
        assertThat(funCallParam.typeDescriptorString).isNull();
        assertThat(funCallParam.children).hasSize(1);
        var funCallParamVarOrPropAccess = (RealExpression) funCallParam.children.getFirst();
        assertThat(funCallParamVarOrPropAccess.type).isEqualTo(VARIABLE_OR_PROP_ACCESS);
        assertThat(funCallParamVarOrPropAccess.ownerDescriptorString).isNull();
        assertThat(funCallParamVarOrPropAccess.identifiers).isEmpty();
        assertThat(funCallParamVarOrPropAccess.typeDescriptorString).isNull();
        assertThat(funCallParamVarOrPropAccess.children).hasSize(1);
        var funCallParamPropAccess = (RealExpression) funCallParamVarOrPropAccess.children.getFirst();
        assertThat(funCallParamPropAccess.type).isEqualTo(PROP_ACCESS);
        assertThat(funCallParamPropAccess.description()).isEqualTo("Expression(propAccess PROP)");
        assertThat(funCallParamPropAccess.ownerDescriptorString).isEqualTo("Lcom/example/Example;");
        assertThat(funCallParamPropAccess.invocation).isEqualTo("getStatic");
        assertThat(funCallParamPropAccess.identifiers).hasSize(1);
        assertThat(funCallParamPropAccess.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(funCallParamPropAccess.children).isEmpty();
    }

    private static AstFile astForCode(String code) {
        var parser = new OolangParser(new CommonTokenStream(new OolangLexer(CharStreams.fromString(code))));
        var oolangFile = parser.oolangFile();
        var visitor = new OolangAstVisitor();
        var astFile = visitor.visitOolangFile(oolangFile);
        OolangSemanticAnalyzer.semanticAnalysis(astFile);
        return astFile;
    }

    /**
     * Expose this package-protected function to other tests
     */
    public static Map<String, String> buildImports(final List<Import> astImports) {
        return OolangSemanticAnalyzer.buildImports(astImports);
    }

    private static void print(AstFile astFile) {
        System.out.println("AstFile:");
        new AstFileWriter(astFile).write(System.out, true);
        System.out.println();
    }
}
