/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;

import java.lang.invoke.TypeDescriptor;

public sealed interface Variable extends TypeDescriptor permits Property, Variable.SimpleVariable {
    @NonNull ActualType type();

    boolean isFinal();

    @SuppressWarnings("preview")
    final class SimpleVariable implements Variable {
        private final @NonNull ActualType type;
        private final boolean isFinal;
        final int slot;

        private final @NonNull LazyConstant<@NonNull String> descriptorString =
                LazyConstant.of(this::buildDescriptorString);

        public SimpleVariable(final @NonNull ActualType type,
                       final boolean isFinal,
                       final int slot) {
            assert type != null;
            this.type = type;
            this.isFinal = isFinal;
            this.slot = slot;
        }

        private @NonNull String buildDescriptorString() {
            return TypeResolver.getKlassFromType(type).descriptorString();
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
        public String descriptorString() {
            return descriptorString.get();
        }

        public int slot() {
            return slot;
        }
    }
}
