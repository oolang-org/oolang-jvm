/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;

public sealed class BaseSymbol permits Property, Function, OolangKlass {
    public final @NonNull String name;
    public @NonNull Visibility visibility;
    public final boolean isStatic;
    public final boolean isAbstract;
    private final boolean isFinal;

    BaseSymbol(final @NonNull BaseSymbol baseSymbol) {
        assert baseSymbol != null;
        this(baseSymbol.name, baseSymbol.visibility, baseSymbol.isStatic, baseSymbol.isAbstract, baseSymbol.isFinal);
    }

    BaseSymbol(final @NonNull String name,
               final @NonNull Visibility visibility,
               final boolean isStatic,
               final boolean isAbstract,
               final boolean isFinal) {
        assert name != null;
        assert visibility != null;

        this.name = name;
        this.visibility = visibility;
        this.isStatic = isStatic;
        this.isAbstract = isAbstract;
        this.isFinal = isFinal;
    }

    public boolean isFinal() {
        return isFinal;
    }
}
