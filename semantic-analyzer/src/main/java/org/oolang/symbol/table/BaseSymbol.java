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

public sealed class BaseSymbol permits BaseSymbol.Property, BaseSymbol.Function, OolangKlass {
    public final @NonNull String name;
    public @NonNull Visibility visibility;
    public final boolean isStatic;
    public final boolean isAbstract;
    private final boolean isFinal;

    BaseSymbol(final @NonNull BaseSymbol baseSymbol) {
        assert baseSymbol != null;
        this(baseSymbol.name, baseSymbol.visibility, baseSymbol.isStatic, baseSymbol.isAbstract, baseSymbol.isFinal);
    }

    BaseSymbol(final @NonNull String name,
               final @NonNull Visibility visibility,
               final boolean isStatic,
               final boolean isAbstract,
               final boolean isFinal) {
        assert name != null;
        assert visibility != null;

        this.name = name;
        this.visibility = visibility;
        this.isStatic = isStatic;
        this.isAbstract = isAbstract;
        this.isFinal = isFinal;
    }

    public boolean isFinal() {
        return isFinal;
    }

    @SuppressWarnings("preview")
    public static final class Property extends BaseSymbol implements Variable, TypeDescriptor {
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

    /// An interface representing the most basic function symbol, to allow quick O(log n) range search by name.
    public sealed interface BaseFunction extends Comparable<BaseFunction> permits Function, Klass.SimpleFunction {
        @NonNull String name();

        @Override
        default int compareTo(final @NonNull BaseFunction other) {
            assert other != null;
            return name().compareTo(other.name());
        }
    }

    @SuppressWarnings("preview")
    public static final class Function extends BaseSymbol implements BaseFunction, TypeDescriptor {
        public final @NonNull Klass declaringKlass;
        private final @NonNull Type returnType;
        public final @NonNull List<@NonNull Parameter> parameters;
        private final @NonNull LazyConstant<@NonNull String> descriptorString =
                LazyConstant.of(this::buildDescriptorString);
        private final @NonNull LazyConstant<@NonNull String> typeDescriptorString =
                LazyConstant.of(this::buildTypeDescriptorString);

        /// @param returnType a type, or null for constructors. The type will resolve to `declaringKlass`
        Function(final @NonNull Klass declaringKlass,
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

        Function(final @NonNull Klass declaringKlass,
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

        public @NonNull ActualType returnType() {
            return switch (returnType) {
                case ActualType actualType -> actualType;
                case Type.Lazy lazyType -> lazyType.type();
                case Type.Lateinit lateinitType -> lateinitType.type();
            };
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

        public static final class Parameter {
            public final @NonNull String name;
            private final Type.@Nullable Lazy lazyType;
            private final @Nullable ActualType type;

            Parameter(final @NonNull String name, final Type.@NonNull Lazy lazyType) {
                assert name != null;
                assert lazyType != null;

                this.name = name;
                this.lazyType = lazyType;
                this.type = null;
            }

            Parameter(final @NonNull String name, final @NonNull ActualType type) {
                assert name != null;
                assert type != null;

                this.name = name;
                this.type = type;
                this.lazyType = null;
            }

            public @NonNull ActualType type() {
                if (type != null) {
                    return type;
                }
                assert lazyType != null;
                return lazyType.type();
            }
        }
    }
}
