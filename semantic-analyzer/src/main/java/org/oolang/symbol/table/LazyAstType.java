/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.Annotation;
import org.oolang.ast.AstInfo;
import org.oolang.ast.AstType;

import java.util.List;

@SuppressWarnings("preview")
final class LazyAstType implements AstType {
    final @NonNull Type type;
    private final @NonNull LazyConstant<@NonNull Klass> lazyKlass;

    LazyAstType(final @NonNull Type type) {
        assert type != null;

        this.type = type;
        this.lazyKlass = LazyConstant.of(() -> TypeResolver.getKlassFromType(TypeResolver.getActualTypeFromType(type)));
    }

    @NonNull Klass lazyKlass() {
        return lazyKlass.get();
    }

    @Override
    public @NonNull String descriptorString() {
        return lazyKlass().descriptorString();
    }

    @Override
    public @Nullable List<@NonNull AstType> parameters() {
        throw new UnsupportedOperationException("todo");
    }

    @Override
    public @Nullable List<@NonNull Annotation> annotations() {
        throw new UnsupportedOperationException("todo");
    }

    @Override
    public @NonNull String rawName() {
        final var sb = new StringBuilder();
        sb.append(descriptorString());
        // todo add parameters and nullable ?
        return sb.toString();
    }

    @Override
    public @Nullable AstInfo info() {
        return null;
    }

    @Override
    public void setInfo(final @NonNull AstInfo info) {
        throw new UnsupportedOperationException(); // not needed
    }
}
