/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package oo.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.Test;
import org.oolang.ast.AstFile;
import org.oolang.ast.AstFileWriter;
import org.oolang.ast.element.ClassBody;
import org.oolang.ast.element.RealElement;
import org.oolang.ast.expression.ConstantExpression;
import org.oolang.ast.expression.RealExpression;
import org.oolang.ast.statement.CodeBlock;
import org.oolang.ast.statement.RealStatement;
import org.oolang.parser.OolangAstVisitor;
import org.oolang.parser.generated.OolangLexer;
import org.oolang.parser.generated.OolangParser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.oolang.ast.element.RealElement.ElementType.*;
import static org.oolang.ast.expression.RealExpression.ExpressionType.*;

public class OolangAstVisitorTest {
    @Test
    public void parseSimplestClass() {
        var astFile = astForCode("""
                package com.example
                class Example""");
        verifyPackage(astFile);
        var imports = astFile.imports;
        assertThat(imports).isEmpty();
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.modifiers).isEmpty();
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        print(astFile);
    }

    @Test
    public void parseFinalClass() {
        var astFile = astForCode("""
                package com.example
                final class Example""");
        verifyPackage(astFile);
        var imports = astFile.imports;
        assertThat(imports).isEmpty();
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.modifiers).extracting("modifier")
                .containsExactly("final");
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        print(astFile);
    }

    @Test
    public void parseAbstractClass() {
        var astFile = astForCode("""
                package com.example
                abstract class Example""");
        verifyPackage(astFile);
        var imports = astFile.imports;
        assertThat(imports).isEmpty();
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.modifiers).extracting("modifier")
                .containsExactly("abstract");
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        print(astFile);
    }

    @Test
    public void parseOpenClass() {
        var astFile = astForCode("""
                package com.example
                open class Example""");
        verifyPackage(astFile);
        var imports = astFile.imports;
        assertThat(imports).isEmpty();
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.modifiers).extracting("modifier")
                .containsExactly("open");
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        print(astFile);
    }

    @Test
    public void parseClassWithEmptyBody() {
        var astFile = astForCode("""
                package com.example
                class Example {}""");
        verifyPackage(astFile);
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        assertThat(root.children).hasSize(1);
        assertThat(root.children.getFirst()).isInstanceOf(ClassBody.class);
        print(astFile);
    }

    @Test
    public void parseAnnotatedClassWithImport() {
        var astFile = astForCode("""
                package com.example
                import jakarta.enterprise.inject.Default
                @Default
                class Example""");
        verifyPackage(astFile);
        var imports = astFile.imports;
        assertThat(imports).hasSize(1);
        assertThat(imports.getFirst().description()).isEqualTo("Import(jakarta.enterprise.inject.Default)");
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.annotations).hasSize(1);
        var annotation = root.annotations.getFirst();
        assertThat(annotation.description()).isEqualTo("Annotation(Default)");
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        print(astFile);
    }

    @Test
    public void parseEnumClass() {
        var astFile = astForCode("""
                package com.example
                enum class Example""");
        verifyPackage(astFile);
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.modifiers).extracting("modifier")
                .containsExactly("enum");
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        print(astFile);
    }

    @Test
    public void parsePublicEnumClass() {
        var astFile = astForCode("""
                package com.example
                public enum class Example""");
        verifyPackage(astFile);
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.modifiers).extracting("modifier")
                .containsExactly("public", "enum");
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        print(astFile);
    }

    @Test
    public void parseClassWithPrimaryConstructor() {
        var astFile = astForCode("""
                package com.example
                class Example(val foo: String)""");
        verifyPackage(astFile);
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        assertThat(root.children).hasSize(1);
        var constructor = (RealElement) root.children.getFirst();
        assertThat(constructor.elementType).isEqualTo(CONSTRUCTOR);
        assertThat(constructor.identifier).isNull();
        assertThat(constructor.children).hasSize(1);
        var constructorParam = (RealElement) constructor.children.getFirst();
        assertThat(constructorParam.elementType).isEqualTo(VAL);
        assertThat(constructorParam.description()).isEqualTo("Element(val foo:String)");
        print(astFile);
    }

    @Test
    public void parseClassWithUseSiteAnnotatedConstructor() {
        var astFile = astForCode("""
                package com.example
                class Example(@get:JsonIgnore val foo: String)""");
        verifyPackage(astFile);
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        assertThat(root.children).hasSize(1);
        var constructor = (RealElement) root.children.getFirst();
        assertThat(constructor.children).hasSize(1);
        var constructorParam = (RealElement) constructor.children.getFirst();
        assertThat(constructorParam.annotations).hasSize(1);
        var annotation = constructorParam.annotations.getFirst();
        assertThat(annotation.description()).isEqualTo("Annotation(get:JsonIgnore)");
        print(astFile);
    }

    @Test
    public void parseUseSiteMultipleAnnotatedClass() {
        var astFile = astForCode("""
                package com.example
                class Example(@set:[Inject VisibleForTesting] var foo: String)""");
        verifyPackage(astFile);
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        assertThat(root.children).hasSize(1);
        var constructor = (RealElement) root.children.getFirst();
        assertThat(constructor.children).hasSize(1);
        var constructorParam = (RealElement) constructor.children.getFirst();
        assertThat(constructorParam.annotations).hasSize(2);
        // Inject
        var annotation = constructorParam.annotations.getFirst();
        assertThat(annotation.description()).isEqualTo("Annotation(set:Inject)");
        // VisibleForTesting
        annotation = constructorParam.annotations.getLast();
        assertThat(annotation.description()).isEqualTo("Annotation(set:VisibleForTesting)");
        print(astFile);
    }

    @Test
    public void symbolTableOfInnerClassWithEmptyBody() {
        var astFile = astForCode("""
                package com.example
                class Example {
                class Inner
                }""");
        verifyPackage(astFile);
        var imports = astFile.imports;
        assertThat(imports).isEmpty();
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.modifiers).isEmpty();
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        assertThat(root.children).hasSize(1);
        assertThat(root.children.getFirst()).isInstanceOf(ClassBody.class);
        var classBody = (ClassBody) root.children.getFirst();
        assertThat(classBody.content()).hasSize(1);
        var innerClass = (RealElement) classBody.content().getFirst();
        assertThat(innerClass.elementType).isEqualTo(CLASS);
        assertThat(innerClass.modifiers).isEmpty();
        assertThat(innerClass.identifier).isNotNull();
        assertThat(innerClass.identifier.identifier).isEqualTo("Inner");
        assertThat(innerClass.type).isNull();
        assertThat(innerClass.children).isEmpty();
        print(astFile);
    }

    @Test
    public void symbolTableOfClassWithProperty() {
        var astFile = astForCode("""
                package com.example
                class Example {
                val foo: String
                }""");
        verifyPackage(astFile);
        var imports = astFile.imports;
        assertThat(imports).isEmpty();
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.modifiers).isEmpty();
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        assertThat(root.children).hasSize(1);
        assertThat(root.children.getFirst()).isInstanceOf(ClassBody.class);
        var classBody = (ClassBody) root.children.getFirst();
        assertThat(classBody.content()).hasSize(1);
        var property = (RealElement) classBody.content().getFirst();
        assertThat(property.elementType).isEqualTo(VAL);
        assertThat(property.modifiers).isEmpty();
        assertThat(property.identifier).isNotNull();
        assertThat(property.identifier.identifier).isEqualTo("foo");
        assertThat(property.type).isNotNull();
        assertThat(property.type.description()).isEqualTo("Type(String)");
        assertThat(property.children).isEmpty();
        print(astFile);
    }

    @Test
    public void parseClassWithSimplestFunction() {
        var astFile = astForCode("""
                package com.example
                class Example {
                fun foo() {}
                }""");
        verifyPackage(astFile);
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        assertThat(root.children).hasSize(1);
        assertThat(root.children.getFirst()).isInstanceOf(ClassBody.class);
        var classBody = (ClassBody) root.children.getFirst();
        assertThat(classBody.content()).hasSize(1);
        var funDeclaration = (RealElement) classBody.content().getFirst();
        assertThat(funDeclaration.elementType).isEqualTo(FUN);
        assertThat(funDeclaration.identifier).isNotNull();
        assertThat(funDeclaration.identifier.identifier).isEqualTo("foo");
        assertThat(funDeclaration.type).isNull();
        assertThat(funDeclaration.children).hasSize(1);
        assertThat(funDeclaration.children.getFirst()).isInstanceOf(CodeBlock.class);
        print(astFile);
    }

    @Test
    public void parseClassWithAnnotatedFunction() {
        var astFile = astForCode("""
                package com.example
                class Example {
                @Test
                fun foo() {}
                }""");
        verifyPackage(astFile);
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        assertThat(root.children).hasSize(1);
        assertThat(root.children.getFirst()).isInstanceOf(ClassBody.class);
        var classBody = (ClassBody) root.children.getFirst();
        assertThat(classBody.content()).hasSize(1);
        var funDeclaration = (RealElement) classBody.content().getFirst();
        assertThat(funDeclaration.elementType).isEqualTo(FUN);
        assertThat(funDeclaration.identifier).isNotNull();
        assertThat(funDeclaration.identifier.identifier).isEqualTo("foo");
        assertThat(funDeclaration.type).isNull();
        assertThat(funDeclaration.annotations).hasSize(1);
        var annotation = funDeclaration.annotations.getFirst();
        assertThat(annotation.description()).isEqualTo("Annotation(Test)");
        assertThat(funDeclaration.children.getFirst()).isInstanceOf(CodeBlock.class);
        print(astFile);
    }

    @Test
    public void parseClassWithFunctionWithParameter() {
        var astFile = astForCode("""
                package com.example
                class Example {
                fun foo(bar: String) {}
                }""");
        verifyPackage(astFile);
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        assertThat(root.children).hasSize(1);
        var classBody = (ClassBody) root.children.getFirst();
        assertThat(classBody.content()).hasSize(1);
        var funDeclaration = (RealElement) classBody.content().getFirst();
        assertThat(funDeclaration.description()).isEqualTo("Element(fun foo)");
        assertThat(funDeclaration.elementType).isEqualTo(FUN);
        assertThat(funDeclaration.identifier).isNotNull();
        assertThat(funDeclaration.identifier.identifier).isEqualTo("foo");
        assertThat(funDeclaration.type).isNull();
        assertThat(funDeclaration.children).hasSize(2);
        var funParam = (RealElement) funDeclaration.children.getFirst();
        assertThat(funParam.elementType).isEqualTo(PARAMETER);
        assertThat(funParam.description()).isEqualTo("Element(parameter bar:String)");
        assertThat(funDeclaration.children.getLast()).isInstanceOf(CodeBlock.class);
        print(astFile);
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
        assertThat(funCall.description()).isEqualTo("Expression(funCall System.out.println)");
        assertThat(funCall.type).isEqualTo(FUN_CALL);
        assertThat(funCall.content()).hasSize(1);
        var funCallParam = (RealExpression) funCall.content().getFirst();
        assertThat(funCallParam.description()).isEqualTo("Expression(funCallParameter)");
        assertThat(funCallParam.content()).hasSize(1);
        var funCallParamString = (ConstantExpression) funCallParam.content().getFirst();
        assertThat(funCallParamString.description()).isEqualTo("ConstantExpression(\"Hello, World!\")");
        print(astFile);
    }

    private @NonNull RealExpression verifyMainUntilStatement(AstFile astFile) {
        verifyPackage(astFile);
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        assertThat(root.children).hasSize(1);
        var classBody = (ClassBody) root.children.getFirst();
        assertThat(classBody.content()).hasSize(1);
        var funDeclaration = (RealElement) classBody.content().getFirst();
        assertThat(funDeclaration.description()).isEqualTo("Element(fun main)");
        assertThat(funDeclaration.elementType).isEqualTo(FUN);
        assertThat(funDeclaration.identifier).isNotNull();
        assertThat(funDeclaration.identifier.identifier).isEqualTo("main");
        assertThat(funDeclaration.type).isNull();
        assertThat(funDeclaration.modifiers).extracting("modifier")
                .containsExactly("static");
        assertThat(funDeclaration.children).hasSize(2);
        var funParam = (RealElement) funDeclaration.children.getFirst();
        assertThat(funParam.elementType).isEqualTo(PARAMETER);
        assertThat(funParam.description()).isEqualTo("Element(parameter args:Array<String>)");
        assertThat(funDeclaration.children.getLast()).isInstanceOf(CodeBlock.class);
        var codeBlock = (CodeBlock) funDeclaration.children.getLast();
        assertThat(codeBlock.description()).isEqualTo("CodeBlock");
        assertThat(codeBlock.content()).hasSize(1);
        var statement = (RealStatement) codeBlock.content().getFirst();
        assertThat(statement.description()).isEqualTo("Statement");
        assertThat(statement.content()).hasSize(1);
        return (RealExpression) statement.children.getFirst();
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
        assertThat(funCall.description()).isEqualTo("Expression(funCall System.out.println)");
        assertThat(funCall.type).isEqualTo(FUN_CALL);
        assertThat(funCall.content()).hasSize(1);
        var funCallParam = (RealExpression) funCall.content().getFirst();
        assertThat(funCallParam.description()).isEqualTo("Expression(funCallParameter)");
        assertThat(funCallParam.content()).hasSize(1);
        var funCallParamAdd = (RealExpression) funCallParam.content().getFirst();
        assertThat(funCallParamAdd.description()).isEqualTo("Expression(add)");
        assertThat(funCallParamAdd.type).isEqualTo(ADD);
        assertThat(funCallParamAdd.content()).hasSize(4);

        var funCallParamConstant1 = (ConstantExpression) funCallParamAdd.content().get(0);
        assertThat(funCallParamConstant1.description()).isEqualTo("ConstantExpression(\"Hello, \")");

        var funCallParamArray1 = (RealExpression) funCallParamAdd.content().get(1);
        assertThat(funCallParamArray1.description()).isEqualTo("Expression(indexing args)");
        assertThat(funCallParamArray1.type).isEqualTo(INDEXING);
        assertThat(funCallParamArray1.content()).hasSize(1);
        var funCallParamArrayIndex1 = (ConstantExpression) funCallParamArray1.content().getFirst();
        assertThat(funCallParamArrayIndex1.description()).isEqualTo("ConstantExpression(0)");

        var funCallParamConstant2 = (ConstantExpression) funCallParamAdd.content().get(2);
        assertThat(funCallParamConstant2.description()).isEqualTo("ConstantExpression(\" and \")");

        var funCallParamArray2 = (RealExpression) funCallParamAdd.content().get(3);
        assertThat(funCallParamArray2.description()).isEqualTo("Expression(indexing args)");
        assertThat(funCallParamArray2.type).isEqualTo(INDEXING);
        assertThat(funCallParamArray2.content()).hasSize(1);
        var funCallParamArrayIndex2 = (ConstantExpression) funCallParamArray2.content().getFirst();
        assertThat(funCallParamArrayIndex2.description()).isEqualTo("ConstantExpression(1)");

        print(astFile);
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
        verifyPackage(astFile);
        var imports = astFile.imports;
        assertThat(imports).isEmpty();
        var root = astFile.rootElements.getFirst();
        assertThat(root).isNotNull();
        assertThat(root.elementType).isEqualTo(CLASS);
        assertThat(root.modifiers).isEmpty();
        assertThat(root.identifier).isNotNull();
        assertThat(root.identifier.identifier).isEqualTo("Example");
        assertThat(root.description()).isEqualTo("Element(class Example)");
        assertThat(root.children).hasSize(1);
        assertThat(root.children.getFirst()).isInstanceOf(ClassBody.class);
        var classBody = (ClassBody) root.children.getFirst();
        assertThat(classBody.content()).hasSize(2);

        var property = (RealElement) classBody.content().getFirst();
        assertThat(property.elementType).isEqualTo(VAL);
        assertThat(property.modifiers).extracting("modifier")
                .containsExactly("static");
        assertThat(property.identifier).isNotNull();
        assertThat(property.identifier.identifier).isEqualTo("PROP");
        assertThat(property.type).isNull();
        assertThat(property.children).hasSize(1);
        var propertyInit = (RealElement) property.children.getFirst();
        assertThat(propertyInit.elementType).isEqualTo(PROPERTY_INITIALIZER);
        var propertyExpression = (ConstantExpression) propertyInit.children.getFirst();
        assertThat(propertyExpression.description()).isEqualTo("ConstantExpression(\"Hello, World!\")");

        var funDeclaration = (RealElement) classBody.content().getLast();
        var codeBlock = (CodeBlock) funDeclaration.children.getLast();
        var statement = (RealStatement) codeBlock.content().getFirst();
        var funCall = (RealExpression) statement.children.getFirst();
        assertThat(funCall.description()).isEqualTo("Expression(funCall System.out.println)");
        assertThat(funCall.type).isEqualTo(FUN_CALL);
        assertThat(funCall.content()).hasSize(1);
        var funCallParam = (RealExpression) funCall.content().getFirst();
        assertThat(funCallParam.description()).isEqualTo("Expression(funCallParameter)");
        assertThat(funCallParam.content()).hasSize(1);
        var funCallParamPropAccess = (RealExpression) funCallParam.content().getFirst();
        assertThat(funCallParamPropAccess.description()).isEqualTo("Expression(variableOrPropAccess PROP)");

        print(astFile);
    }

    private static AstFile astForCode(String code) {
        var parser = new OolangParser(new CommonTokenStream(new OolangLexer(CharStreams.fromString(code))));
        var oolangFile = parser.oolangFile();
        var visitor = new OolangAstVisitor();
        return visitor.visitOolangFile(oolangFile);
    }

    private static void verifyPackage(AstFile astFile) {
        assertThat(astFile.packageHeader.description()).isEqualTo("PackageHeader(com.example)");
    }

    private static void print(AstFile astFile) {
        System.out.println("AstFile:");
        new AstFileWriter(astFile).write(System.out, true);
        System.out.println();
    }
}
