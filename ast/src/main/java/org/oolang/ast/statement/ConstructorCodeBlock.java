/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.statement;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.AbstractAst;
import org.oolang.ast.Ast;
import org.oolang.ast.expression.RealExpression;

import java.util.ArrayList;
import java.util.List;

public final class ConstructorCodeBlock extends AbstractAst implements StatementNode {
    public final @NonNull CodeBlock initBlock = new CodeBlock();

    /// Expression to another constructor in the current class or a super constructor.
    ///
    /// If null, an implicit call to the no-arg super constructor is built during semantic analysis.
    public /* lateinit */ RealExpression initCall = null;

    public final @NonNull CodeBlock postConstructBlock = new CodeBlock();

    @Override
    public @NonNull String description() {
        return "ConstructorBody";
    }

    @Override
    public @NonNull List<? extends @NonNull Ast> content() {
        final var content = new ArrayList<@NonNull Ast>(initBlock.statements);
        if (initCall != null) {
            content.add(initCall);
        }
        content.addAll(postConstructBlock.statements);
        return content;
    }
}
