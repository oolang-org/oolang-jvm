/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;

public sealed interface Variable permits BaseSymbol.Property, Variable.SimpleVariable {
    @NonNull Type type();

    boolean isFinal();

    record SimpleVariable(@NonNull Type type, boolean isFinal, int slot) implements Variable {
    }
}
