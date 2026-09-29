/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.statement;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AbstractAst;
import org.oolang.ast.Annotation;
import org.oolang.ast.Ast;

import java.util.ArrayList;
import java.util.List;

public final class RealStatement extends AbstractAst implements StatementNode {
    public @Nullable List<@NonNull Annotation> annotations = null;
    public @NonNull List<@NonNull Ast> children = new ArrayList<>();

    @Override
    public @NonNull String description() {
        return "Statement";
    }

    @Override
    public @NonNull List<@NonNull Ast> content() {
        final var content = new ArrayList<@NonNull Ast>();
        if (annotations != null) {
            content.addAll(annotations);
        }
        content.addAll(children);
        return content;
    }
}
