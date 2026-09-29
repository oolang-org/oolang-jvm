/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;

import java.util.List;

public sealed interface Type extends Comparable<Type> permits Klass, Type.GenericType {

    boolean isAssignableFrom(final @NonNull Type otherType);

    record GenericType(@NonNull Klass klass, @NonNull List<@NonNull Type> parameters) implements Type {
        @Override
        public boolean isAssignableFrom(final @NonNull Type otherType) {
            assert otherType != null;

            throw new UnsupportedOperationException();
        }
    }

    default int compareTo(final @NonNull Type other) {
        assert other != null;

        final var thisKlass = TypeResolver.getKlassFromType(this);
        final var otherKlass = TypeResolver.getKlassFromType(other);

        if (thisKlass.equals(otherKlass)) {
            return 0;
        }

        if (thisKlass.genericSuperInterfaces().stream()
                .map(TypeResolver::getKlassFromType)
                .anyMatch(otherKlass::equals)) {
            return -1;
        }

        return 1;
    }
}
