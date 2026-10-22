/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.compiler;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.oolang.KlassesCacheInterceptor;
import org.oolang.OolangCustomAttribute;
import org.oolang.ast.AstFile;
import org.oolang.parser.OolangAstVisitor;
import org.oolang.parser.generated.OolangLexer;
import org.oolang.parser.generated.OolangParser;
import org.oolang.semantic.analyzer.OolangSemanticAnalyzer;

import java.io.IOException;
import java.lang.classfile.*;
import java.lang.classfile.instruction.*;
import java.lang.constant.ConstantDescs;
import java.lang.reflect.AccessFlag;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

@SuppressWarnings("OptionalGetWithoutIsPresent")
@ExtendWith(KlassesCacheInterceptor.class)
public class OolangCompilerTest {
    @TempDir
    public Path tempDir;

    @Test
    public void compileSimplestClass() {
        var astFile = astForCode("""
                package com.example
                class Example""");
        var classModel = compileAst(astFile);
        assertThat(classModel.flags().flags()).containsExactlyInAnyOrder(
                AccessFlag.PUBLIC,
                AccessFlag.FINAL
        );
        assertThat(classModel.thisClass().asInternalName()).isEqualTo("com/example/Example");
        assertThat(classModel.superclass()).hasValueSatisfying(superClass ->
                assertThat(superClass.asInternalName()).isEqualTo("java/lang/Object"));
        assertThat(classModel.interfaces()).isEmpty();
        assertThat(classModel.fields()).isEmpty();
        assertThat(classModel.methods()).isEmpty();
    }

    @Test
    public void compileSimplestClassWithMainFunctionFullTypes() {
        var astFile = astForCode("""
                package com.example
                class Example {
                static fun main(args: Array<java.lang.String>) {
                java.lang.System.out.println("Hello, World!")
                }
                }""");
        compileSimplestClassWithMainFunction(astFile);
    }

    @Test
    public void compileSimplestClassWithMainFunctionShortTypes() {
        var astFile = astForCode("""
                package com.example
                class Example {
                static fun main(args: Array<java.lang.String>) {
                System.out.println("Hello, World!")
                }
                }""");
        compileSimplestClassWithMainFunction(astFile);
    }

    private void compileSimplestClassWithMainFunction(AstFile astFile) {
        var codeElements = verifyMainUntilStatement(astFile);
        assertThat(codeElements).hasSize(4);

        var expression1 = (FieldInstruction) codeElements.get(0);
        assertThat(expression1.opcode()).isEqualTo(Opcode.GETSTATIC);
        assertThat(expression1.name().stringValue()).isEqualTo("out");
        assertThat(expression1.owner().asInternalName()).isEqualTo("java/lang/System");
        assertThat(expression1.typeSymbol().descriptorString()).isEqualTo("Ljava/io/PrintStream;");

        var expression2 = (ConstantInstruction.LoadConstantInstruction) codeElements.get(1);
        assertThat(expression2.opcode()).isEqualTo(Opcode.LDC);
        assertThat(expression2.typeKind()).isEqualTo(TypeKind.REFERENCE);
        assertThat(expression2.constantValue()).isEqualTo("Hello, World!");

        var expression3 = (InvokeInstruction) codeElements.get(2);
        assertThat(expression3.opcode()).isEqualTo(Opcode.INVOKEVIRTUAL);
        assertThat(expression3.name().stringValue()).isEqualTo("println");
        assertThat(expression3.owner().asInternalName()).isEqualTo("java/io/PrintStream");
        assertThat(expression3.typeSymbol().descriptorString()).isEqualTo("(Ljava/lang/String;)V");

        var expression4 = (ReturnInstruction) codeElements.get(3);
        assertThat(expression4.opcode()).isEqualTo(Opcode.RETURN);
        assertThat(expression4.typeKind()).isEqualTo(TypeKind.VOID);
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
        var codeElements = verifyMainUntilStatement(astFile);
        assertThat(codeElements).hasSize(10);

        var expression1 = (FieldInstruction) codeElements.get(0);
        assertThat(expression1.opcode()).isEqualTo(Opcode.GETSTATIC);
        assertThat(expression1.name().stringValue()).isEqualTo("out");
        assertThat(expression1.owner().asInternalName()).isEqualTo("java/lang/System");
        assertThat(expression1.typeSymbol().descriptorString()).isEqualTo("Ljava/io/PrintStream;");

        var expression2 = (LoadInstruction) codeElements.get(1);
        assertThat(expression2.opcode()).isEqualTo(Opcode.ALOAD_0);
        assertThat(expression2.typeKind()).isEqualTo(TypeKind.REFERENCE);

        var expression3 = (ConstantInstruction.IntrinsicConstantInstruction) codeElements.get(2);
        assertThat(expression3.opcode()).isEqualTo(Opcode.ICONST_0);
        assertThat(expression3.typeKind()).isEqualTo(TypeKind.INT);
        assertThat(expression3.constantValue()).isEqualTo(0);

        var expression4 = (ArrayLoadInstruction) codeElements.get(3);
        assertThat(expression4.opcode()).isEqualTo(Opcode.AALOAD);
        assertThat(expression4.typeKind()).isEqualTo(TypeKind.REFERENCE);

        var expression5 = (LoadInstruction) codeElements.get(4);
        assertThat(expression5.opcode()).isEqualTo(Opcode.ALOAD_0);
        assertThat(expression5.typeKind()).isEqualTo(TypeKind.REFERENCE);

        var expression6 = (ConstantInstruction.IntrinsicConstantInstruction) codeElements.get(5);
        assertThat(expression6.opcode()).isEqualTo(Opcode.ICONST_1);
        assertThat(expression6.typeKind()).isEqualTo(TypeKind.INT);
        assertThat(expression6.constantValue()).isEqualTo(1);

        var expression7 = (ArrayLoadInstruction) codeElements.get(6);
        assertThat(expression7.opcode()).isEqualTo(Opcode.AALOAD);
        assertThat(expression7.typeKind()).isEqualTo(TypeKind.REFERENCE);

        var expression8 = (InvokeDynamicInstruction) codeElements.get(7);
        assertThat(expression8.opcode()).isEqualTo(Opcode.INVOKEDYNAMIC);
        assertThat(expression8.name().stringValue()).isEqualTo("jvmDynamicStringConcat");
        assertThat(expression8.typeSymbol().descriptorString())
                .isEqualTo("(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;");
        var invokeDynamicBootstrapMethod = expression8.bootstrapMethod();
        assertThat(invokeDynamicBootstrapMethod.methodName()).isEqualTo("makeConcatWithConstants");
        assertThat(invokeDynamicBootstrapMethod.owner().descriptorString())
                .isEqualTo("Ljava/lang/invoke/StringConcatFactory;");

        var expression9 = (InvokeInstruction) codeElements.get(8);
        assertThat(expression9.opcode()).isEqualTo(Opcode.INVOKEVIRTUAL);
        assertThat(expression9.name().stringValue()).isEqualTo("println");
        assertThat(expression9.owner().asInternalName()).isEqualTo("java/io/PrintStream");
        assertThat(expression9.typeSymbol().descriptorString())
                .isEqualTo("(Ljava/lang/String;)V");

        var expression10 = (ReturnInstruction) codeElements.get(9);
        assertThat(expression10.opcode()).isEqualTo(Opcode.RETURN);
        assertThat(expression10.typeKind()).isEqualTo(TypeKind.VOID);
    }

    private @NonNull List<@NonNull CodeElement> verifyMainUntilStatement(AstFile astFile) {
        var classModel = compileAst(astFile);
        assertThat(classModel.flags().flags()).containsExactlyInAnyOrder(
                AccessFlag.PUBLIC,
                AccessFlag.FINAL
        );
        assertThat(classModel.thisClass().asInternalName()).isEqualTo("com/example/Example");
        assertThat(classModel.superclass()).hasValueSatisfying(superClass ->
                assertThat(superClass.asInternalName()).isEqualTo("java/lang/Object"));
        assertThat(classModel.interfaces()).isEmpty();
        assertThat(classModel.fields()).isEmpty();
        assertThat(classModel.methods()).hasSize(1);
        var methodModel = classModel.methods().getFirst();
        assertThat(methodModel.flags().flags()).containsExactlyInAnyOrder(
                AccessFlag.PUBLIC,
                AccessFlag.STATIC,
                AccessFlag.FINAL
        );
        assertThat(methodModel.methodName().stringValue()).isEqualTo("main");
        assertThat(methodModel.methodTypeSymbol().descriptorString()).isEqualTo("([Ljava/lang/String;)V");
        assertThat(methodModel.code()).isPresent();
        var methodCode = methodModel.code().get();
        return methodCode.elementList();
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
        var classModel = compileAst(astFile);

        assertThat(classModel.fields()).hasSize(1);
        var fieldModel = classModel.fields().getFirst();
        assertThat(fieldModel.flags().flags()).containsExactlyInAnyOrder(
                AccessFlag.PUBLIC,
                AccessFlag.STATIC,
                AccessFlag.FINAL
        );
        assertThat(fieldModel.fieldName().stringValue()).isEqualTo("PROP");
        assertThat(fieldModel.fieldTypeSymbol().descriptorString()).isEqualTo("Ljava/lang/String;");

        assertThat(classModel.methods()).hasSize(1);
        var methodModel = classModel.methods().getFirst();
        var methodCode = methodModel.code().get();
        var codeElements = methodCode.elementList();
        assertThat(codeElements).hasSize(4);

        var expression1 = (FieldInstruction) codeElements.get(0);
        assertThat(expression1.opcode()).isEqualTo(Opcode.GETSTATIC);
        assertThat(expression1.name().stringValue()).isEqualTo("out");
        assertThat(expression1.owner().asInternalName()).isEqualTo("java/lang/System");
        assertThat(expression1.typeSymbol().descriptorString()).isEqualTo("Ljava/io/PrintStream;");

        var expression2 = (FieldInstruction) codeElements.get(1);
        assertThat(expression2.opcode()).isEqualTo(Opcode.GETSTATIC);
        assertThat(expression2.name().stringValue()).isEqualTo("PROP");
        assertThat(expression2.owner().asInternalName()).isEqualTo("com/example/Example");
        assertThat(expression2.typeSymbol().descriptorString()).isEqualTo("Ljava/lang/String;");

        var expression3 = (InvokeInstruction) codeElements.get(2);
        assertThat(expression3.opcode()).isEqualTo(Opcode.INVOKEVIRTUAL);
        assertThat(expression3.name().stringValue()).isEqualTo("println");
        assertThat(expression3.owner().asInternalName()).isEqualTo("java/io/PrintStream");
        assertThat(expression3.typeSymbol().descriptorString()).isEqualTo("(Ljava/lang/String;)V");

        var expression4 = (ReturnInstruction) codeElements.get(3);
        assertThat(expression4.opcode()).isEqualTo(Opcode.RETURN);
        assertThat(expression4.typeKind()).isEqualTo(TypeKind.VOID);
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
        var classModel = compileAst(astFile);

        assertThat(classModel.fields()).hasSize(1);
        var fieldModel = classModel.fields().getFirst();
        assertThat(fieldModel.flags().flags()).containsExactlyInAnyOrder(
                AccessFlag.PRIVATE,
                AccessFlag.FINAL
        );
        assertThat(fieldModel.fieldName().stringValue()).isEqualTo("prop");
        assertThat(fieldModel.fieldTypeSymbol().descriptorString()).isEqualTo("Ljava/lang/String;");

        assertThat(classModel.methods()).hasSize(3);

        verifyMainWithPropUsageAndPropGetter(classModel);

        // default constructor is added after everything
        var constructorMethodModel = classModel.methods().getLast();
        assertThat(constructorMethodModel.flags().flags()).containsExactly(
                AccessFlag.PUBLIC
        );
        assertThat(constructorMethodModel.methodName().stringValue()).isEqualTo(ConstantDescs.INIT_NAME);
        var constructorMethodCode = constructorMethodModel.code().get();
        var constructorCodeElements = constructorMethodCode.elementList();
        assertThat(constructorCodeElements).hasSize(6);

        var constructorExpression1 = (LoadInstruction) constructorCodeElements.get(0);
        assertThat(constructorExpression1.opcode()).isEqualTo(Opcode.ALOAD_0);
        assertThat(constructorExpression1.typeKind()).isEqualTo(TypeKind.REFERENCE);

        var constructorExpression2 = (ConstantInstruction.LoadConstantInstruction) constructorCodeElements.get(1);
        assertThat(constructorExpression2.opcode()).isEqualTo(Opcode.LDC);
        assertThat(constructorExpression2.typeKind()).isEqualTo(TypeKind.REFERENCE);
        assertThat(constructorExpression2.constantValue()).isEqualTo("Hello, World!");

        var constructorExpression3 = (FieldInstruction) constructorCodeElements.get(2);
        assertThat(constructorExpression3.opcode()).isEqualTo(Opcode.PUTFIELD);
        assertThat(constructorExpression3.name().stringValue()).isEqualTo("prop");
        assertThat(constructorExpression3.owner().asInternalName()).isEqualTo("com/example/Example");
        assertThat(constructorExpression3.typeSymbol().descriptorString()).isEqualTo("Ljava/lang/String;");

        var constructorExpression4 = (LoadInstruction) constructorCodeElements.get(3);
        assertThat(constructorExpression4.opcode()).isEqualTo(Opcode.ALOAD_0);
        assertThat(constructorExpression4.typeKind()).isEqualTo(TypeKind.REFERENCE);

        var constructorExpression5 = (InvokeInstruction) constructorCodeElements.get(4);
        assertThat(constructorExpression5.opcode()).isEqualTo(Opcode.INVOKESPECIAL);
        assertThat(constructorExpression5.name().stringValue()).isEqualTo(ConstantDescs.INIT_NAME);
        assertThat(constructorExpression5.owner().asInternalName()).isEqualTo("java/lang/Object");
        assertThat(constructorExpression5.typeSymbol().descriptorString()).isEqualTo("()V");

        var constructorExpression6 = (ReturnInstruction) constructorCodeElements.get(5);
        assertThat(constructorExpression6.opcode()).isEqualTo(Opcode.RETURN);
        assertThat(constructorExpression6.typeKind()).isEqualTo(TypeKind.VOID);
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
        var classModel = compileAst(astFile);

        assertThat(classModel.fields()).hasSize(2);
        var staticField = classModel.fields().getFirst();
        assertThat(staticField.flags().flags()).containsExactlyInAnyOrder(
                AccessFlag.PRIVATE,
                AccessFlag.STATIC,
                AccessFlag.FINAL
        );
        assertThat(staticField.fieldName().stringValue()).isEqualTo("HELLO");
        assertThat(staticField.fieldTypeSymbol().descriptorString()).isEqualTo("Ljava/lang/String;");
        var instanceField = classModel.fields().getLast();
        assertThat(instanceField.flags().flags()).containsExactlyInAnyOrder(
                AccessFlag.PRIVATE,
                AccessFlag.FINAL
        );
        assertThat(instanceField.fieldName().stringValue()).isEqualTo("prop");
        assertThat(instanceField.fieldTypeSymbol().descriptorString()).isEqualTo("Ljava/lang/String;");

        assertThat(classModel.methods()).hasSize(3);

        verifyMainWithPropUsageAndPropGetter(classModel);

        // default constructor is added after everything
        var constructorMethodModel = classModel.methods().getLast();
        assertThat(constructorMethodModel.flags().flags()).containsExactly(
                AccessFlag.PUBLIC
        );
        assertThat(constructorMethodModel.methodName().stringValue()).isEqualTo(ConstantDescs.INIT_NAME);
        var constructorMethodCode = constructorMethodModel.code().get();
        var constructorCodeElements = constructorMethodCode.elementList();
        assertThat(constructorCodeElements).hasSize(7);

        var constructorExpression1 = (LoadInstruction) constructorCodeElements.get(0);
        assertThat(constructorExpression1.opcode()).isEqualTo(Opcode.ALOAD_0);
        assertThat(constructorExpression1.typeKind()).isEqualTo(TypeKind.REFERENCE);

        var constructorExpression2 = (FieldInstruction) constructorCodeElements.get(1);
        assertThat(constructorExpression2.opcode()).isEqualTo(Opcode.GETSTATIC);
        assertThat(constructorExpression2.name().stringValue()).isEqualTo("HELLO");
        assertThat(constructorExpression2.owner().asInternalName()).isEqualTo("com/example/Example");
        assertThat(constructorExpression2.typeSymbol().descriptorString()).isEqualTo("Ljava/lang/String;");

        var constructorExpression3 = (InvokeDynamicInstruction) constructorCodeElements.get(2);
        assertThat(constructorExpression3.opcode()).isEqualTo(Opcode.INVOKEDYNAMIC);
        assertThat(constructorExpression3.name().stringValue()).isEqualTo("jvmDynamicStringConcat");
        assertThat(constructorExpression3.typeSymbol().descriptorString())
                .isEqualTo("(Ljava/lang/String;)Ljava/lang/String;");
        var invokeDynamicBootstrapMethod = constructorExpression3.bootstrapMethod();
        assertThat(invokeDynamicBootstrapMethod.methodName()).isEqualTo("makeConcatWithConstants");
        assertThat(invokeDynamicBootstrapMethod.owner().descriptorString())
                .isEqualTo("Ljava/lang/invoke/StringConcatFactory;");

        var constructorExpression4 = (FieldInstruction) constructorCodeElements.get(3);
        assertThat(constructorExpression4.opcode()).isEqualTo(Opcode.PUTFIELD);
        assertThat(constructorExpression4.name().stringValue()).isEqualTo("prop");
        assertThat(constructorExpression4.owner().asInternalName()).isEqualTo("com/example/Example");
        assertThat(constructorExpression4.typeSymbol().descriptorString()).isEqualTo("Ljava/lang/String;");

        var constructorExpression5 = (LoadInstruction) constructorCodeElements.get(4);
        assertThat(constructorExpression5.opcode()).isEqualTo(Opcode.ALOAD_0);
        assertThat(constructorExpression5.typeKind()).isEqualTo(TypeKind.REFERENCE);

        var constructorExpression6 = (InvokeInstruction) constructorCodeElements.get(5);
        assertThat(constructorExpression6.opcode()).isEqualTo(Opcode.INVOKESPECIAL);
        assertThat(constructorExpression6.name().stringValue()).isEqualTo(ConstantDescs.INIT_NAME);
        assertThat(constructorExpression6.owner().asInternalName()).isEqualTo("java/lang/Object");
        assertThat(constructorExpression6.typeSymbol().descriptorString()).isEqualTo("()V");

        var constructorExpression7 = (ReturnInstruction) constructorCodeElements.get(6);
        assertThat(constructorExpression7.opcode()).isEqualTo(Opcode.RETURN);
        assertThat(constructorExpression7.typeKind()).isEqualTo(TypeKind.VOID);
    }

    private void verifyMainWithPropUsageAndPropGetter(ClassModel classModel) {
        verifyMainWithPropUsage(classModel);

        var methodModel = classModel.methods().get(1);
        assertThat(methodModel.attributes()).hasSize(2);
        var oolangGetAttribute = (OolangCustomAttribute) methodModel.attributes().getFirst();
        assertThat(oolangGetAttribute.name()).isEqualTo("oolang-get");
        assertThat(oolangGetAttribute.value()).isNull();
        var methodCode = methodModel.code().get();
        var codeElements = methodCode.elementList();
        assertThat(codeElements).hasSize(3);

        var expression1 = (LoadInstruction) codeElements.get(0);
        assertThat(expression1.opcode()).isEqualTo(Opcode.ALOAD_0);
        assertThat(expression1.typeKind()).isEqualTo(TypeKind.REFERENCE);

        var expression2 = (FieldInstruction) codeElements.get(1);
        assertThat(expression2.opcode()).isEqualTo(Opcode.GETFIELD);
        assertThat(expression2.name().stringValue()).isEqualTo("prop");
        assertThat(expression2.owner().asInternalName()).isEqualTo("com/example/Example");
        assertThat(expression2.typeSymbol().descriptorString()).isEqualTo("Ljava/lang/String;");

        var expression3 = (ReturnInstruction) codeElements.get(2);
        assertThat(expression3.opcode()).isEqualTo(Opcode.ARETURN);
        assertThat(expression3.typeKind()).isEqualTo(TypeKind.REFERENCE);
    }

    private void verifyMainWithPropUsage(ClassModel classModel) {
        var methodModel = classModel.methods().getFirst();
        var methodCode = methodModel.code().get();
        var codeElements = methodCode.elementList();
        assertThat(codeElements).hasSize(7);

        var expression1 = (FieldInstruction) codeElements.get(0);
        assertThat(expression1.opcode()).isEqualTo(Opcode.GETSTATIC);
        assertThat(expression1.name().stringValue()).isEqualTo("out");
        assertThat(expression1.owner().asInternalName()).isEqualTo("java/lang/System");
        assertThat(expression1.typeSymbol().descriptorString()).isEqualTo("Ljava/io/PrintStream;");

        var expression2 = (NewObjectInstruction) codeElements.get(1);
        assertThat(expression2.opcode()).isEqualTo(Opcode.NEW);
        assertThat(expression2.className().asInternalName()).isEqualTo("com/example/Example");

        var expression3 = (StackInstruction) codeElements.get(2);
        assertThat(expression3.opcode()).isEqualTo(Opcode.DUP);

        var expression4 = (InvokeInstruction) codeElements.get(3);
        assertThat(expression4.opcode()).isEqualTo(Opcode.INVOKESPECIAL);
        assertThat(expression4.name().stringValue()).isEqualTo(ConstantDescs.INIT_NAME);
        assertThat(expression4.owner().asInternalName()).isEqualTo("com/example/Example");
        assertThat(expression4.typeSymbol().descriptorString()).isEqualTo("()V");

        var expression5 = (FieldInstruction) codeElements.get(4);
        assertThat(expression5.opcode()).isEqualTo(Opcode.GETFIELD);
        assertThat(expression5.name().stringValue()).isEqualTo("prop");
        assertThat(expression5.owner().asInternalName()).isEqualTo("com/example/Example");
        assertThat(expression5.typeSymbol().descriptorString()).isEqualTo("Ljava/lang/String;");

        var expression6 = (InvokeInstruction) codeElements.get(5);
        assertThat(expression6.opcode()).isEqualTo(Opcode.INVOKEVIRTUAL);
        assertThat(expression6.name().stringValue()).isEqualTo("println");
        assertThat(expression6.owner().asInternalName()).isEqualTo("java/io/PrintStream");
        assertThat(expression6.typeSymbol().descriptorString()).isEqualTo("(Ljava/lang/String;)V");

        var expression7 = (ReturnInstruction) codeElements.get(6);
        assertThat(expression7.opcode()).isEqualTo(Opcode.RETURN);
        assertThat(expression7.typeKind()).isEqualTo(TypeKind.VOID);
    }

    private @NonNull ClassModel compileAst(AstFile ast) {
        assertThat(ast.rootElements).hasSize(1);
        var classPath = OolangCompiler.compile(ast.packageHeader, ast.imports, ast.rootElements.getFirst(), tempDir);
        System.out.println("breakpoint here, then execute with");
        System.out.println("java -cp " + classPath.getParent().getParent().getParent() + " com.example.Example");

        var options = ClassFile.AttributeMapperOption.of(utf8Entry ->
                utf8Entry.equalsString(OolangCustomAttribute.NAME)
                        ? new OolangCustomAttribute("", null).attributeMapper()
                        : null
        );

        var classFile = ClassFile.of(options);
        try {
            final var classModel = classFile.parse(classPath);
            assertThat(classModel.minorVersion()).isEqualTo(0);
            assertThat(classModel.majorVersion()).isEqualTo(71);
            printBytecode(classModel);
            return classModel;
        } catch (IOException e) {
            fail(e);
            return null;
        }
    }

    private void printBytecode(ClassModel model) {
        // 2. Print high-level class metadata
        System.out.println("Class Name: " + model.thisClass().asSymbol().displayName());
        System.out.println("Superclass: " + model.superclass().map(s -> s.asSymbol().displayName()).orElse("None"));

        System.out.println("\n--- Fields ---");
        model.fields().forEach(field ->
                System.out.println(" Field: " + field.fieldName().stringValue() + " (" + field.fieldType().stringValue() + ")")
        );

        System.out.println("\n--- Methods ---");
        model.methods().forEach(method -> {
            System.out.println(" Method: " + method.methodName().stringValue() + method.methodType().stringValue());

            // Look for the Code attribute containing the bytecode
            method.code().ifPresent(codeModel -> {
                // Loop through every single element/instruction in the bytecode block
                for (var element : codeModel) {
                    System.out.println("  " + element);
                }
            });
        });
    }

    private static AstFile astForCode(String code) {
        var parser = new OolangParser(new CommonTokenStream(new OolangLexer(CharStreams.fromString(code))));
        var oolangFile = parser.oolangFile();
        var visitor = new OolangAstVisitor();
        var astFile = visitor.visitOolangFile(oolangFile);
        OolangSemanticAnalyzer.semanticAnalysis(astFile);
        return astFile;
    }
}
