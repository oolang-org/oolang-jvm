/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package oo.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;
import org.oolang.parser.generated.OolangLexer;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OolangLexerTest {
    @Test
    public void lexSimplestClass() {
        assertThat(tokens(lexerForCode("class A")))
                .containsExactly("CLASS", "HexDigitOrSeparator", "EOF");
    }

    @Test
    public void lexSimplestClassWithBraces() {
        assertThat(tokens(lexerForCode("class A {}")))
                .containsExactly("CLASS", "HexDigitOrSeparator", "LCURL", "RCURL", "EOF");
    }

    private static List<String> tokens(OolangLexer lexer) {
        List<String> tokens = new ArrayList<>();
        Token t;
        do {
            t = lexer.nextToken();
            if (t.getType() == -1) {
                tokens.add("EOF");
            } else {
                if (t.getType() != OolangLexer.WS) {
                    tokens.add(OolangLexer.ruleNames[t.getType()]);
                }
            }
        } while (t.getType() != -1);
        return tokens;
    }

    private static OolangLexer lexerForCode(String code) {
        return new OolangLexer(CharStreams.fromString(code));
    }
}
