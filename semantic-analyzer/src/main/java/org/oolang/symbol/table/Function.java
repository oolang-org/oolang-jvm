/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.lang.constant.ConstantDescs;
import java.lang.invoke.TypeDescriptor;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("preview")
public final class Function implements Symbol, BaseFunction, TypeDescriptor {
    public final @NonNull Klass declaringKlass;
    private final @NonNull String name;
    private final @NonNull Visibility visibility;
    private final boolean isStatic;
    private final boolean isAbstract;
    private final boolean isFinal;
    private final @NonNull Type returnType;
    public final @NonNull List<@NonNull Parameter> parameters;
    // the reference of the property if this function is part of a function property
    public @Nullable Property property = null;

    private final @NonNull LazyConstant<@NonNull ActualType> returnActualType =
            LazyConstant.of(this::buildReturnActualType);
    private final @NonNull LazyConstant<@NonNull String> descriptorString =
            LazyConstant.of(this::buildDescriptorString);
    private final @NonNull LazyConstant<@NonNull String> typeDescriptorString =
            LazyConstant.of(this::buildTypeDescriptorString);

    /// @param returnType a type, or null for constructors. The type will then resolve to `declaringKlass`.
    Function(final @NonNull OolangKlass declaringKlass,
             final @NonNull BaseSymbol baseSymbol,
             final @Nullable Type returnType,
             final @NonNull List<@NonNull Parameter> parameters) {
        assert declaringKlass != null;
        assert baseSymbol != null;
        assert parameters != null;

        this(declaringKlass, baseSymbol.name(), baseSymbol.visibility(), baseSymbol.isStatic(), baseSymbol.isAbstract(),
                baseSymbol.isFinal(),
                (returnType != null) ? returnType : declaringKlass,
                parameters);
    }

    Function(final @NonNull Klass declaringKlass,
             final @NonNull String name,
             final @NonNull Visibility visibility,
             final boolean isStatic,
             final boolean isAbstract,
             final boolean isFinal,
             final @NonNull Type returnType,
             final @NonNull List<@NonNull Parameter> parameters) {
        assert declaringKlass != null;
        assert name != null;
        assert visibility != null;
        assert returnType != null;
        assert parameters != null;

        this.declaringKlass = declaringKlass;
        this.name = name;
        this.visibility = visibility;
        this.isStatic = isStatic;
        this.isAbstract = isAbstract;
        this.isFinal = isFinal;
        this.returnType = returnType;
        this.parameters = parameters;
    }

    private @NonNull ActualType buildReturnActualType() {
        return switch (returnType) {
            case ActualType actualType -> actualType;
            case Type.Lazy lazyType -> lazyType.type();
            case Type.Lateinit lateinitType -> lateinitType.type();
        };
    }

    public @NonNull ActualType returnType() {
        return returnActualType.get();
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

    @Override
    public boolean isFinal() {
        return isFinal;
    }

    private @NonNull String buildDescriptorString() {
        return TypeResolver.getKlassFromType(returnType()).descriptorString();
    }

    private @NonNull String buildTypeDescriptorString() {
        final var suffix = (name.equals(ConstantDescs.INIT_NAME)) ? ")V" : ")" + buildDescriptorString();
        return parameters.stream()
                .map(parameter -> TypeResolver.getKlassFromType(parameter.type()).descriptorString())
                .collect(Collectors.joining(
                        /*delimiter*/ "",
                        /*prefix*/ "(",
                        suffix));
    }

    @Override
    public @NonNull String descriptorString() {
        return descriptorString.get();
    }

    public @NonNull String typeDescriptorString() {
        return typeDescriptorString.get();
    }

    /// The parameter of a function.
    public static final class Parameter {
        public final @Nullable String name;
        private final @NonNull Type type;

        Parameter(final @Nullable String name, final @NonNull Type type) {
            assert type != null;

            this.name = name;
            this.type = type;
        }

        public @NonNull ActualType type() {
            return switch (type) {
                case ActualType actualType -> actualType;
                case Type.Lazy lazyType -> lazyType.type();
                case Type.Lateinit _ ->
                        throw new IllegalArgumentException("Lateinit type is not supported for parameter");
            };
        }
    }
}
