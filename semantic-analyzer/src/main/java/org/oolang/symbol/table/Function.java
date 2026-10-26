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
public final class Function extends BaseSymbol implements BaseFunction, TypeDescriptor {
    public final @NonNull Klass declaringKlass;
    private final @NonNull Type returnType;
    public final @NonNull List<@NonNull Parameter> parameters;

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
        super(baseSymbol);

        this.declaringKlass = declaringKlass;
        this.returnType = (returnType != null) ? returnType : declaringKlass;
        this.parameters = parameters;
    }

    Function(final @NonNull ExistingKlass declaringKlass,
             final @NonNull String name,
             final @NonNull Visibility visibility,
             final boolean isStatic,
             final boolean isAbstract,
             final boolean isFinal,
             final @NonNull ActualType returnType,
             final @NonNull List<@NonNull Parameter> parameters) {
        assert declaringKlass != null;
        assert name != null;
        assert visibility != null;
        assert returnType != null;
        assert parameters != null;
        super(name, visibility, isStatic, isAbstract, isFinal);

        this.declaringKlass = declaringKlass;
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
