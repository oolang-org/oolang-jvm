/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.lang.invoke.TypeDescriptor;

@SuppressWarnings("preview")
public final class Property extends BaseSymbol implements Variable, TypeDescriptor {
    public final @NonNull Klass declaringKlass;
    private final @NonNull Type type;
    public @Nullable Function getter = null;

    private final @NonNull LazyConstant<@NonNull String> descriptorString =
            LazyConstant.of(this::buildDescriptorString);

    Property(final @NonNull Klass declaringKlass,
             final @NonNull BaseSymbol baseSymbol,
             final @NonNull Type type) {
        assert declaringKlass != null;
        assert baseSymbol != null;
        assert type != null;
        super(baseSymbol);

        this.declaringKlass = declaringKlass;
        this.type = type;
    }

    Property(final @NonNull Klass declaringKlass,
             final @NonNull String name,
             final @NonNull Visibility visibility,
             final boolean isStatic,
             final boolean isAbstract,
             final boolean isFinal,
             final @NonNull ActualType type) {
        assert declaringKlass != null;
        assert name != null;
        assert visibility != null;
        assert type != null;
        super(name, visibility, isStatic, isAbstract, isFinal);

        this.declaringKlass = declaringKlass;
        this.type = type;
    }

    @Override
    public @NonNull ActualType type() {
        return switch (type) {
            case ActualType actualType -> actualType;
            case Type.Lazy lazyType -> lazyType.type();
            case Type.Lateinit lateinitType -> lateinitType.type();
        };
    }

    public Type.@Nullable Lateinit lateinitTypeOrNull() {
        return (type instanceof Type.Lateinit lateinitType) ? lateinitType : null;
    }

    private @NonNull String buildDescriptorString() {
        return TypeResolver.getKlassFromType(type()).descriptorString();
    }

    @Override
    public String descriptorString() {
        return descriptorString.get();
    }
}
