/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface Ast {
    @NonNull String description();

    @Nullable AstInfo info();

    void setInfo(final @NonNull AstInfo info);

    interface Node extends Ast {
        @NonNull List<? extends @NonNull Ast> content();
    }
}
