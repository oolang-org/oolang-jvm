/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.expression;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.AbstractAst;

import java.lang.constant.ConstantDesc;

public final class ConstantExpression extends AbstractAst implements Expression {
    public final @NonNull ConstantDesc value;
    // set during semantic analysis phase.
    private /* lateinit */ String descriptorString;

    public ConstantExpression(final @NonNull ConstantDesc value) {
        assert value != null;
        this.value = value;
    }

    @Override
    public @NonNull String description() {
        final String printableValue;
        if (value instanceof String string) {
            final var formatted = (string.length() > 64) ? string.substring(0, 64) + "..." : string;
            printableValue = "\"" + formatted + "\"";
        } else {
            printableValue = value.toString();
        }
        return "ConstantExpression(" + printableValue + ")";
    }

    @Override
    public @NonNull String descriptorString() {
        return descriptorString;
    }

    public void setDescriptorString(final @NonNull String descriptorString) {
        assert descriptorString != null;
        this.descriptorString = descriptorString;
    }
}
