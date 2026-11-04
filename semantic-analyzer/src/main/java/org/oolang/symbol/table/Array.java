/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/// This Array pseudo-class represents an array type in the Oolang language.
final class Array extends Klass {
    private static /* lateinit */ Array INSTANCE;

    // only called once by getInstance()
    private Array() {
    }

    static Array getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Array();
        }
        return INSTANCE;
    }

    @Override
    public boolean isInterface() {
        throw new IllegalCallerException("Array is a pseudo-class, don't call it!");
    }

    @Override
    public @NonNull String packageName() {
        throw new IllegalCallerException("Array is a pseudo-class, don't call it!");
    }

    @Override
    @Nullable ActualType superKlass() {
        throw new IllegalCallerException("Array is a pseudo-class, don't call it!");
    }

    @Override
    @NonNull List<@NonNull ActualType> interfaces() {
        throw new IllegalCallerException("Array is a pseudo-class, don't call it!");
    }

    @Override
    public @NonNull Map<@NonNull String, @NonNull Property> properties() {
        throw new IllegalCallerException("Array is a pseudo-class, don't call it!");
    }

    @Override
    public @NonNull SortedSet<@NonNull BaseFunction> functions() {
        throw new IllegalCallerException("Array is a pseudo-class, don't call it!");
    }

    @Override
    public @NonNull String descriptorString() {
        throw new IllegalCallerException("Array is a pseudo-class, don't call it!");
    }

    @Override
    public boolean isArray() {
        throw new IllegalCallerException("Array is a pseudo-class, don't call it!");
    }

    @Override
    public Klass componentType() {
        throw new IllegalCallerException("Array is a pseudo-class, don't call it!");
    }

    @Override
    public @NonNull Klass arrayType() {
        throw new IllegalCallerException("Array is a pseudo-class, don't call it!");
    }
}
