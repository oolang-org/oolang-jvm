/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;

/// An interface representing the most basic function symbol, to allow quick O(log n) range search by name.
public sealed interface BaseFunction extends Comparable<BaseFunction> permits Function, Klass.SimpleFunction {
    @NonNull String name();

    @Override
    default int compareTo(final @NonNull BaseFunction other) {
        assert other != null;
        return name().compareTo(other.name());
    }
}
