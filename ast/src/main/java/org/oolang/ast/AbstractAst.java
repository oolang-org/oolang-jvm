/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

public abstract class AbstractAst implements Ast {
    private @Nullable AstInfo info;

    @Override
    public final @NonNull AstInfo info() {
        return Objects.requireNonNull(this.info);
    }

    @Override
    public final void setInfo(final @NonNull AstInfo info) {
        Objects.requireNonNull(info);
        if (info.start().compareTo(info.stop()) > 0) {
            throw new IllegalArgumentException("Invalid AstInfo: start must be before stop");
        }
        this.info = info;
    }
}
