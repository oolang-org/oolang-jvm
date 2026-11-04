/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.semantic.analyzer;

import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import static org.oolang.symbol.table.Klass.KLASSES_CACHE;

public final class KlassCacheRunner {
    // un-instantiable
    private KlassCacheRunner() {
    }

    public static void run(final @NonNull Runnable op) {
        Objects.requireNonNull(op);
        ScopedValue.where(KLASSES_CACHE, new ConcurrentHashMap<>()).run(op);
    }
}
