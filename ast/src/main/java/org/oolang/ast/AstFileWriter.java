/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast;

import org.jspecify.annotations.NonNull;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Objects;

public final class AstFileWriter {
    private final @NonNull AstFile astFile;

    public AstFileWriter(final @NonNull AstFile astFile) {
        this.astFile = Objects.requireNonNull(astFile);
    }

    public void write(final @NonNull Appendable appendable, final boolean withAstInfo) {
        Objects.requireNonNull(appendable);

        try {
            if (withAstInfo) {
                appendable.append("   ID Index        Position       Token").append(System.lineSeparator());
            }
            for (final var ast : astFile.content()) {
                write(ast, appendable, 0, withAstInfo);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static void write(final @NonNull Ast ast,
                              final @NonNull Appendable appendable,
                              final int depth,
                              final boolean withAstInfo) throws IOException {
        assert ast != null;
        assert appendable != null;

        if (withAstInfo) {
            appendable.append(ast.info().toString());
        }
        indent(appendable, depth);
        appendable.append(ast.description()).append(System.lineSeparator());
        if (ast instanceof AstNode astNode) {
            for (final var child : astNode.content()) {
                write(child, appendable, depth + 1, withAstInfo);
            }
        }
    }

    private static void indent(final @NonNull Appendable appendable, final int depth) throws IOException {
        assert appendable != null;

        for (var i = 0; i < depth; i++) {
            appendable.append("  ");
        }
    }
}
