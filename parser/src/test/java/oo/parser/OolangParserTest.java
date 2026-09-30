/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package oo.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import org.oolang.parser.generated.OolangLexer;
import org.oolang.parser.generated.OolangParser;

import static org.assertj.core.api.Assertions.assertThat;

public class OolangParserTest {
    @Test
    public void parseSimplestClass() {
        OolangParser parser = parserForCode("class A");
        OolangParser.ClassDeclarationContext classDecl = parser.classDeclaration();
        assertThat(classDecl.getChildCount()).isEqualTo(2);
        assertThat(classDecl.CLASS().getText()).isEqualTo("class");
        assertThat(classDecl.simpleIdentifier().getText())
                .isEqualTo("A");
        assertThat(classDecl.classBody()).isNull();
    }

    @Test
    public void parseSimplestClassWithBraces() {
        OolangParser parser = parserForCode("class A {}");
        OolangParser.ClassDeclarationContext classDecl = parser.classDeclaration();
        assertThat(classDecl.getChildCount()).isEqualTo(3);
        assertThat(classDecl.CLASS().getText()).isEqualTo("class");
        assertThat(classDecl.simpleIdentifier().getText())
                .isEqualTo("A");
        assertThat(classDecl.classBody().getText()).isEqualTo("{}");
    }

    @Test
    public void parseSimplestInterface() {
        OolangParser parser = parserForCode("interface B");
        OolangParser.ClassDeclarationContext classDecl = parser.classDeclaration();
        assertThat(classDecl.getChildCount()).isEqualTo(2);
        assertThat(classDecl.INTERFACE().getText()).isEqualTo("interface");
        assertThat(classDecl.simpleIdentifier().getText())
                .isEqualTo("B");
        assertThat(classDecl.classBody()).isNull();
    }

    private static OolangParser parserForCode(String code) {
        return new OolangParser(new CommonTokenStream(new OolangLexer(CharStreams.fromString(code))));
    }
}
