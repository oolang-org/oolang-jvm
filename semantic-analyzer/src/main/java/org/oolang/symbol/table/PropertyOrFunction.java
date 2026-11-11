/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.lang.invoke.TypeDescriptor;

@SuppressWarnings("preview")
public sealed abstract class PropertyOrFunction implements Symbol, TypeDescriptor permits Function, Property {
    public final @NonNull Klass declaringKlass;
    public final @NonNull String name;
    public @NonNull Visibility visibility;
    public final boolean isStatic;
    public final boolean isAbstract;
    private final boolean isFinal;
    final @NonNull Type type;

    private final @NonNull LazyConstant<@NonNull String> descriptorString =
            LazyConstant.of(this::buildDescriptorString);

    PropertyOrFunction(final @NonNull OolangKlass declaringKlass,
                       final @NonNull BaseSymbol baseSymbol,
                       final @NonNull Type type) {
        assert baseSymbol != null;
        this(declaringKlass, baseSymbol.name(), baseSymbol.visibility(), baseSymbol.isStatic(), baseSymbol.isAbstract(),
                baseSymbol.isFinal(), type);
    }

    PropertyOrFunction(final @NonNull Klass declaringKlass,
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

        this.declaringKlass = declaringKlass;
        this.name = name;
        this.visibility = visibility;
        this.isStatic = isStatic;
        this.isAbstract = isAbstract;
        this.isFinal = isFinal;
        this.type = type;
    }

    public @NonNull ActualType type() {
        return TypeResolver.getActualTypeFromType(type);
    }

    public Type.@Nullable Lateinit lateinitTypeOrNull() {
        return (type instanceof Type.Lateinit lateinitType && lateinitType.type == null) ? lateinitType : null;
    }

    private @NonNull String buildDescriptorString() {
        return TypeResolver.getKlassFromType(type()).descriptorString();
    }

    @Override
    public @NonNull String descriptorString() {
        return descriptorString.get();
    }

    @Override
    public @NonNull String name() {
        return name;
    }

    @Override
    public @NonNull Visibility visibility() {
        return visibility;
    }

    @Override
    public boolean isStatic() {
        return isStatic;
    }

    @Override
    public boolean isAbstract() {
        return isAbstract;
    }

    public boolean isFinal() {
        return isFinal;
    }
}
