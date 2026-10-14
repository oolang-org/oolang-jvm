/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;

import java.util.List;

public sealed interface ActualType extends Comparable<ActualType> permits Klass, ActualType.GenericType {

    boolean isAssignableFrom(final @NonNull ActualType otherType);

    record GenericType(@NonNull Klass klass, @NonNull List<@NonNull ActualType> parameters) implements ActualType {
        @Override
        public boolean isAssignableFrom(final @NonNull ActualType otherType) {
            assert otherType != null;

            throw new UnsupportedOperationException();
        }
    }

    default int compareTo(final @NonNull ActualType other) {
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
