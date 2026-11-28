/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.expression;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AstInfo;

public non-sealed abstract class DelegateExpression implements Expression {
    public final @NonNull Expression delegate;

    protected DelegateExpression(final @NonNull Expression delegate) {
        assert delegate != null;

        this.delegate = delegate;
    }

    @Override
    public final String descriptorString() {
        return delegate.descriptorString();
    }

    @Override
    public final @NonNull String description() {
        return delegate.description();
    }

    @Override
    public final @Nullable AstInfo info() {
        return delegate.info();
    }

    @Override
    public final void setInfo(final @NonNull AstInfo info) {
        throw new UnsupportedOperationException(); // not needed
    }
}
