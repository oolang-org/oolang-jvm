/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.statement;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AbstractAst;
import org.oolang.ast.Annotation;
import org.oolang.ast.Ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class RealStatement extends AbstractAst implements StatementNode {
    public final @NonNull StatementType statementType;
    public @Nullable List<@NonNull Annotation> annotations = null;
    public @NonNull List<@NonNull Ast> children = new ArrayList<>();

    public RealStatement(final @NonNull StatementType statementType) {
        this.statementType = Objects.requireNonNull(statementType);
    }

    @Override
    public @NonNull String description() {
        return "Statement(" + statementType.name().toLowerCase(Locale.US) + ")";
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

    public enum StatementType {
        /// a class / function / variable declaration. `children` is a single
        ///  [RealElement][org.oolang.ast.element.RealElement]
        DECLARATION,
        /// a statement that executes an expression. `children` is a single
        /// [Expression][org.oolang.ast.expression.Expression]
        EXPRESSION,
        /// a `return` statement. A single `children` is present for value return, empty for no-value return.
        RETURN,
        /// An assignment. First child is the left-side [Expression][org.oolang.ast.expression.Expression], the second
        /// children is the value [Expression][org.oolang.ast.expression.Expression].
        ASSIGNMENT,
    }
}
