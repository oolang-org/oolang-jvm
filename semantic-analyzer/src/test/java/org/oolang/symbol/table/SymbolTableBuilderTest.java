/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.oolang.KlassesCacheInterceptor;
import org.oolang.parser.OolangAstVisitor;
import org.oolang.parser.generated.OolangLexer;
import org.oolang.parser.generated.OolangParser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.oolang.semantic.analyzer.OolangSemanticAnalyzerTest.buildImports;
import static org.oolang.symbol.table.Visibility.*;

@ExtendWith(KlassesCacheInterceptor.class)
public class SymbolTableBuilderTest {
    @Test
    public void symbolTableOfSimplestClass() {
        var symbolTable = symbolTableForCode("""
                package com.example
                class Example""");
        assertThat(symbolTable.klasses).hasSize(1);
        var rootKlass = symbolTable.klasses.values().iterator().next();
        assertThat(rootKlass.name).isEqualTo("Example");
    }

    @Test
    public void symbolTableOfClassWithEmptyBody() { // exact same behavior as the simplest above
        var symbolTable = symbolTableForCode("""
                package com.example
                class Example {}""");
        assertThat(symbolTable.klasses).hasSize(1);
        var rootKlass = symbolTable.klasses.values().iterator().next();
        assertThat(rootKlass.name).isEqualTo("Example");
    }

    @Test
    public void symbolTableOfInnerClassWithEmptyBody() {
        var symbolTable = symbolTableForCode("""
                package com.example
                class Example {
                class Inner
                }""");
        assertThat(symbolTable.klasses).hasSize(1);
        var rootKlass = symbolTable.klasses.values().iterator().next();
        assertThat(rootKlass.name).isEqualTo("Example");
        assertThat(rootKlass.klasses).hasSize(1);
        var childKlass = rootKlass.klasses.values().iterator().next();
        assertThat(childKlass.name).isEqualTo("Inner");
    }

    @Test
    public void symbolTableOfClassWithProperty() {
        var symbolTable = symbolTableForCode("""
                package com.example
                class Example {
                val foo: String
                }""");
        assertThat(symbolTable.klasses).hasSize(1);
        var rootKlass = symbolTable.klasses.values().iterator().next();
        assertThat(rootKlass.name).isEqualTo("Example");
        assertThat(rootKlass.properties()).hasSize(1);
        var childProperty = rootKlass.properties().values().iterator().next();
        assertThat(childProperty.name).isEqualTo("foo");
        assertThat(childProperty.visibility).isEqualTo(PUBLIC);
        assertThat(childProperty.isStatic).isFalse();
        assertThat(childProperty.isAbstract).isFalse();
        assertThat(childProperty.isFinal()).isTrue();
        var klass = (Klass) childProperty.type();
        assertThat(klass.descriptorString()).isEqualTo("Ljava/lang/String;");
    }

    @Test
    public void symbolTableOfClassWithStaticProperty() {
        var symbolTable = symbolTableForCode("""
                package com.example
                import java.math.BigInteger
                class Example {
                protected static var FOO: BigInteger
                }""");
        assertThat(symbolTable.klasses).hasSize(1);
        var rootKlass = symbolTable.klasses.values().iterator().next();
        assertThat(rootKlass.name).isEqualTo("Example");
        assertThat(rootKlass.properties()).hasSize(1);
        var childProperty = rootKlass.properties().values().iterator().next();
        assertThat(childProperty.name).isEqualTo("FOO");
        assertThat(childProperty.visibility).isEqualTo(OOLANG_PROTECTED);
        assertThat(childProperty.isStatic).isTrue();
        assertThat(childProperty.isAbstract).isFalse();
        assertThat(childProperty.isFinal()).isFalse();
        var klass = (Klass) childProperty.type();
        assertThat(klass.descriptorString()).isEqualTo("Ljava/math/BigInteger;");
    }

    @Test
    public void symbolTableOfClassWithSimplestFunction() {
        var symbolTable = symbolTableForCode("""
                package com.example
                class Example {
                private fun foo() {}
                }""");
        assertThat(symbolTable.klasses).hasSize(1);
        var rootKlass = symbolTable.klasses.values().iterator().next();
        assertThat(rootKlass.name).isEqualTo("Example");
        assertThat(rootKlass.functions).hasSize(1);
        var childFunction = rootKlass.functions.getFirst();
        assertThat(childFunction.name).isEqualTo("foo");
        assertThat(childFunction.visibility).isEqualTo(PRIVATE);
        assertThat(childFunction.isStatic).isFalse();
        assertThat(childFunction.isAbstract).isFalse();
        assertThat(childFunction.isFinal()).isTrue();
        var klass = (Klass) childFunction.returnType();
        assertThat(klass.descriptorString()).isEqualTo("V");
        assertThat(childFunction.parameters).isEmpty();
    }

    @Test
    public void symbolTableOfClassWithSimpleFunctionAndReturnType() {
        var symbolTable = symbolTableForCode("""
                package com.example
                class Example {
                private fun foo(): Void {}
                }""");
        assertThat(symbolTable.klasses).hasSize(1);
        var rootKlass = symbolTable.klasses.values().iterator().next();
        assertThat(rootKlass.name).isEqualTo("Example");
        assertThat(rootKlass.functions).hasSize(1);
        var childFunction = rootKlass.functions.getFirst();
        assertThat(childFunction.name).isEqualTo("foo");
        assertThat(childFunction.visibility).isEqualTo(PRIVATE);
        assertThat(childFunction.isStatic).isFalse();
        assertThat(childFunction.isAbstract).isFalse();
        assertThat(childFunction.isFinal()).isTrue();
        var klass = (Klass) childFunction.returnType();
        assertThat(klass.descriptorString()).isEqualTo("V");
        assertThat(childFunction.parameters).isEmpty();
    }

    @Test
    public void symbolTableOfClassWithFunctionWithParameter() {
        var symbolTable = symbolTableForCode("""
                package com.example
                class Example {
                fun foo(bar: Int): String {}
                }""");
        assertThat(symbolTable.klasses).hasSize(1);
        var rootKlass = symbolTable.klasses.values().iterator().next();
        assertThat(rootKlass.name).isEqualTo("Example");
        assertThat(rootKlass.functions).hasSize(1);
        var childFunction = rootKlass.functions.getFirst();
        assertThat(childFunction.name).isEqualTo("foo");
        assertThat(childFunction.visibility).isEqualTo(PUBLIC);
        assertThat(childFunction.isStatic).isFalse();
        assertThat(childFunction.isAbstract).isFalse();
        assertThat(childFunction.isFinal()).isTrue();
        var klass = (Klass) childFunction.returnType();
        assertThat(klass.descriptorString()).isEqualTo("Ljava/lang/String;");
        assertThat(childFunction.parameters).hasSize(1);
        var parameter = childFunction.parameters.getFirst();
        assertThat(parameter.name).isEqualTo("bar");
        klass = (Klass) parameter.type();
        assertThat(klass.descriptorString()).isEqualTo("I");
    }

    @Test
    public void parseClassWithMainFunction() {
        var symbolTable = symbolTableForCode("""
                package com.example
                class Example {
                static fun main(args: Array<String>) {}
                }""");
        assertThat(symbolTable.klasses).hasSize(1);
        var rootKlass = symbolTable.klasses.values().iterator().next();
        assertThat(rootKlass.name).isEqualTo("Example");
        assertThat(rootKlass.functions).hasSize(1);
        var childFunction = rootKlass.functions.getFirst();
        assertThat(childFunction.name).isEqualTo("main");
        assertThat(childFunction.visibility).isEqualTo(PUBLIC);
        assertThat(childFunction.isStatic).isTrue();
        assertThat(childFunction.isAbstract).isFalse();
        assertThat(childFunction.isFinal()).isTrue();
        var klass = (Klass) childFunction.returnType();
        assertThat(klass.descriptorString()).isEqualTo("V");
        assertThat(childFunction.parameters).hasSize(1);
        var parameter = childFunction.parameters.getFirst();
        assertThat(parameter.name).isEqualTo("args");
        klass = (Klass) parameter.type();
        assertThat(klass.descriptorString()).isEqualTo("[Ljava/lang/String;"); // = an array '[' for strings
    }

    private static OolangKlass symbolTableForCode(String code) {
        var parser = new OolangParser(new CommonTokenStream(new OolangLexer(CharStreams.fromString(code))));
        var oolangFile = parser.oolangFile();
        var visitor = new OolangAstVisitor();
        var astFile = visitor.visitOolangFile(oolangFile);
        return SymbolTableBuilder.build(astFile, buildImports(astFile.imports));
    }
}
