/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;

@SuppressWarnings("preview")
public final class Variable implements VariableOrProperty {
    private final @NonNull ActualType type;
    private final boolean isFinal;
    private final int slot;

    private final @NonNull LazyConstant<@NonNull String> descriptorString =
            LazyConstant.of(this::buildDescriptorString);

    public Variable(final @NonNull ActualType type,
                    final boolean isFinal,
                    final int slot) {
        assert type != null;
        this.type = type;
        this.isFinal = isFinal;
        this.slot = slot;
    }

    @Override
    public @NonNull ActualType type() {
        return type;
    }

    @Override
    public boolean isFinal() {
        return isFinal;
    }

    @Override
    public @NonNull String descriptorString() {
        return descriptorString.get();
    }

    private @NonNull String buildDescriptorString() {
        return TypeResolver.getKlassFromType(type).descriptorString();
    }

    public int slot() {
        return slot;
    }
}
