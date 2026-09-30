/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.statement;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AbstractAst;
import org.oolang.ast.Ast;
import org.oolang.ast.expression.RealExpression;

import java.util.ArrayList;
import java.util.List;

public final class ConstructorCodeBlock extends AbstractAst implements StatementNode {
    public final @NonNull List<@NonNull Statement> earlyLarvalStatements = new ArrayList<>();
    /**
     * Expression to another constructor in the current class or a super constructor.
     * <p>
     * If null, an implicit call to the no-arg super constructor is performed.
     */
    public @Nullable RealExpression initCall = null;
    public final @NonNull List<@NonNull Statement> lateLarvalStatements = new ArrayList<>();

    @Override
    public @NonNull String description() {
        return "ConstructorBody";
    }

    @Override
    public @NonNull List<? extends @NonNull Ast> content() {
        final var content = new ArrayList<@NonNull Ast>(earlyLarvalStatements);
        if (initCall != null) {
            content.add(initCall);
        }
        content.addAll(lateLarvalStatements);
        return content;
    }
}
