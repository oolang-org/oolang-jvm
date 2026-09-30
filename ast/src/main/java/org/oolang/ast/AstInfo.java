/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast;

import org.jspecify.annotations.NonNull;

public /* value */ record AstInfo(
        int id,
        @NonNull Position start,
        @NonNull Position stop
) {
    @Override
    public @NonNull String toString() {
        final var index = String.format("[%d..%d]", start.index(), stop.index());
        final var pos = String.format("[%s..%s]", start, stop);
        return String.format("%5s %-12s %-15s", id, index, pos);
    }
}
