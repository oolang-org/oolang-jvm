/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AstType;

@SuppressWarnings("preview")
final class LazyType {
    private final @NonNull LazyConstant<@NonNull ActualType> lazyType;

    LazyType(final @Nullable AstType astType, final @NonNull OolangKlass oolangKlass) {
        assert oolangKlass != null;

        lazyType = LazyConstant.of(() -> {
            final var type = TypeResolver.resolveType(astType, oolangKlass, false);

            // type resolution, the compiler will use that descriptor string
            if (astType != null) {
                astType.descriptorString = TypeResolver.getKlassFromType(type).descriptorString();
            }

            return type;
        });
    }

    @NonNull ActualType type() {
        return lazyType.get();
    }
}
