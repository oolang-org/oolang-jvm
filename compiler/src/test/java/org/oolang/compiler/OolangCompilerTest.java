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
        assertThat(classModel.minorVersion()).isEqualTo(0);
        assertThat(classModel.majorVersion()).isEqualTo(70);
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
        assertThat(classModel.minorVersion()).isEqualTo(0);
        assertThat(classModel.majorVersion()).isEqualTo(70);
        assertThat(classModel.flags().flags()).containsExactlyInAnyOrder(
                AccessFlag.PUBLIC,
                AccessFlag.FINAL
        );
        assertThat(classModel.thisClass().asInternalName()).isEqualTo("com/example/Example");
        assertThat(classModel.superclass()).hasValueSatisfying(superClass ->
                assertThat(superClass.asInternalName()).isEqualTo("java/lang/Object"));
        assertThat(classModel.interfaces()).isEmpty();
        assertThat(classModel.fields()).isEmpty();
        assertThat(classModel.methods()).hasSize(2);

        verifyDefaultConstructor(classModel);

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

        var fieldModel = classModel.fields().getFirst();
        assertThat(fieldModel.flags().flags()).containsExactlyInAnyOrder(
                AccessFlag.PUBLIC,
                AccessFlag.STATIC,
                AccessFlag.FINAL
        );
        assertThat(fieldModel.fieldName().stringValue()).isEqualTo("PROP");
        assertThat(fieldModel.fieldTypeSymbol().descriptorString()).isEqualTo("Ljava/lang/String;");

        assertThat(classModel.methods()).hasSize(2);

        verifyDefaultConstructor(classModel);

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

    private void verifyDefaultConstructor(ClassModel classModel) {
        // default method is added after everything
        var constructorMethodModel = classModel.methods().getLast();
        assertThat(constructorMethodModel.flags().flags()).containsExactlyInAnyOrder(
                AccessFlag.PUBLIC,
                AccessFlag.FINAL
        );
        assertThat(constructorMethodModel.methodName().stringValue()).isEqualTo(ConstantDescs.INIT_NAME);
    }

    private @NonNull ClassModel compileAst(AstFile ast) {
        assertThat(ast.rootElements).hasSize(1);
        var classPath = OolangCompiler.compile(ast.packageHeader, ast.imports, ast.rootElements.getFirst(), tempDir);
        System.out.println("breakpoint here, then execute with");
        System.out.println("java -cp " + classPath.getParent().getParent().getParent() + " com.example.Example");
        var classFile = ClassFile.of();
        try {
            return classFile.parse(classPath);
        } catch (IOException e) {
            fail(e);
            return null;
        }
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
