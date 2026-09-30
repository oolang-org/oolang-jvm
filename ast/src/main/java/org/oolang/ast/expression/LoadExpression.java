/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.expression;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.AstInfo;

import static org.oolang.ast.Identifier.SimpleIdentifier;

/**
 * An expression that loads a value from a variable or a field into the operand stack. It is set during the semantic
 * analysis phase.
 */
public record LoadExpression(
        @NonNull SimpleIdentifier identifier,
        int slot,
        @NonNull String descriptorString
) implements Expression {
    @Override
    public @NonNull String description() {
        return "LoadExpression(" + identifier.rawName() + ", " + slot + ")";
    }

    @Override
    public @NonNull AstInfo info() {
        return identifier.info();
    }

    @Override
    public void setInfo(final @NonNull AstInfo info) {
        throw new IllegalCallerException("LoadExpression must not be set an info");
    }
}
