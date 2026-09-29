/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast;

import org.jspecify.annotations.NonNull;

public interface Ast {
    @NonNull String description();

    @NonNull AstInfo info();

    void setInfo(final @NonNull AstInfo info);
}
