/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.element;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.AbstractAst;
import org.oolang.ast.Ast;

import java.util.ArrayList;
import java.util.List;

public final class ClassBody extends AbstractAst implements ElementNode {
    public final @NonNull List<@NonNull RealElement> children = new ArrayList<>();

    @Override
    public @NonNull String description() {
        return "ClassBody";
    }

    @Override
    public @NonNull List<? extends @NonNull Ast> content() {
        return children;
    }
}