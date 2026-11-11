/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public final class Property extends PropertyOrFunction implements Variable {
    // For function property
    public @Nullable Function getter = null;
    public @Nullable Function setter = null;

    Property(final @NonNull OolangKlass declaringKlass,
             final @NonNull BaseSymbol baseSymbol,
             final @NonNull Type type) {
        assert declaringKlass != null;
        assert baseSymbol != null;
        assert type != null;

        super(declaringKlass, baseSymbol, type);
    }

    Property(final @NonNull Klass declaringKlass,
             final @NonNull String name,
             final @NonNull Visibility visibility,
             final boolean isStatic,
             final boolean isAbstract,
             final boolean isFinal,
             final @NonNull Type type) {
        assert declaringKlass != null;
        assert name != null;
        assert visibility != null;
        assert type != null;

        super(declaringKlass, name, visibility, isStatic, isAbstract, isFinal, type);
    }
}
