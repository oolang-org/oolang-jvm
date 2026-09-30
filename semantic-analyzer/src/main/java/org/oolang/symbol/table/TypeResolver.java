/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AstType;
import org.oolang.symbol.table.Type.GenericType;

import java.lang.constant.ConstantDesc;
import java.lang.constant.ConstantDescs;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Map;

import static org.oolang.ast.Identifier.MultipleIdentifier;
import static org.oolang.ast.Identifier.SimpleIdentifier;
import static org.oolang.symbol.table.Klass.KLASSES_CACHE;

public final class TypeResolver {
    // un-instantiable
    private TypeResolver() {
    }

    static @NonNull Type resolveType(final java.lang.reflect.@NonNull Type javaType) {
        assert javaType != null;

        return switch (javaType) {
            case Class<?> javaClass -> resolveKlass(javaClass);
            case ParameterizedType parameterizedType -> resolveParameterizedType(parameterizedType);
            case WildcardType wildcardType -> resolveWildcardType(wildcardType);
            default -> throw new UnsupportedOperationException("Unsupported type: " + javaType.getClass().getName());
        };
    }

    static @NonNull Klass resolveKlass(final @NonNull Class<?> javaClass) {
        assert javaClass != null;

        // todo fast-path for primitive and most often used classes ?
        return KLASSES_CACHE.get().computeIfAbsent(javaClass.getName(), ignored -> new ExistingKlass(javaClass));
    }

    private static @NonNull Type resolveParameterizedType(final @NonNull ParameterizedType parameterizedType) {
        assert parameterizedType != null;

        if (!(parameterizedType.getRawType() instanceof Class<?> javaClass)) {
            throw new IllegalArgumentException("Raw type: " + parameterizedType.getRawType() + " is not a class");
        }
        final var parameters = Arrays.stream(parameterizedType.getActualTypeArguments())
                .map(TypeResolver::resolveType)
                .toList();

        return new GenericType(resolveKlass(javaClass), parameters);
    }

    private static @NonNull Type resolveWildcardType(final @NonNull WildcardType wildcardType) {
        assert wildcardType != null;

        // todo proper implementation
        if (wildcardType.getUpperBounds().length != 1) {
            throw new IllegalArgumentException("Problem resolving wildcard type: " + wildcardType);
        }
        return resolveType(wildcardType.getUpperBounds()[0]);
    }

    static @NonNull Type resolveType(final @Nullable AstType astType,
                                     final @NonNull Map<String, String> imports,
                                     final boolean isArray) {
        assert imports != null;

        // no type = void
        if (astType == null) {
            return VOID_KLASS;
        }

        // generic type with parameters
        if (astType.parameters != null) {
            final var klass = resolveKlass(astType, imports, isArray);

            // specific array pseudo-class case
            if (klass == Array.getInstance()) {
                if (astType.parameters.size() != 1) {
                    // todo throw a semantic analysis exception
                    throw new RuntimeException("An array must have exactly one parameter");
                }
                return resolveType(astType.parameters.getFirst(), imports, true);
            }

            return new GenericType(
                    klass,
                    astType.parameters.stream()
                            .map(parameterType -> resolveType(parameterType, imports, false))
                            .toList()
            );
        }

        // simple type
        return resolveKlass(astType, imports, isArray);
    }

    private static @NonNull Klass resolveKlass(final @NonNull AstType astType,
                                               final @NonNull Map<String, String> imports,
                                               final boolean isArray) {
        assert astType != null;
        assert imports != null;

        final var klass = switch (astType.identifier) {
            // must resolve the class name
            case SimpleIdentifier simpleId -> resolveKlassFromSimpleName(simpleId.identifier, imports);
            // fully qualified class name
            case MultipleIdentifier multipleId -> getKlassFromName(multipleId.rawName());
        };
        if (klass == null) {
            throw new RuntimeException("Could not resolve klass from name"); // todo semantic exception
        }

        return (isArray) ? klass.arrayType() : klass;
    }

    public static @Nullable Klass resolveKlassFromSimpleName(final @NonNull String simpleKlassName,
                                                             final @NonNull Map<String, String> imports) {
        assert simpleKlassName != null;
        assert imports != null;

        // 1) todo try to resolve sibling class

        // 2) try to get the fully qualified class name from an import
        final var fullKlassName = imports.get(simpleKlassName);

        // 3) fast-path for primitives and most often used classes and for the Array pseudo-class, no cache call
        if (fullKlassName == null) {
            switch (simpleKlassName) {
                case STRING_KLASS_NAME -> {
                    return STRING_KLASS;
                }
                case INT_KLASS_NAME -> {
                    return INT_KLASS;
                }
                case LONG_KLASS_NAME -> {
                    return LONG_KLASS;
                }
                case FLOAT_KLASS_NAME -> {
                    return FLOAT_KLASS;
                }
                case DOUBLE_KLASS_NAME -> {
                    return DOUBLE_KLASS;
                }
                case ARRAY_KLASS_NAME -> {
                    return Array.getInstance();
                }
                case VOID_KLASS_NAME -> {
                    return VOID_KLASS;
                }
            }
        }

        return getKlassFromName((fullKlassName != null) ? fullKlassName
                // 4) classes from the java.lang package don't need to be imported
                : "java.lang." + simpleKlassName);
    }

    /**
     * <b>Important note:</b> this method requires that the symbol table was built for all Oolang files, and therefore
     * the corresponding {@link OolangKlass} is present in the {@linkplain Klass#KLASSES_CACHE klass cache}.
     */
    public static @Nullable Klass getKlassFromName(final @NonNull String klassName) {
        assert klassName != null;

        final var classType = KLASSES_CACHE.get().get(klassName);
        if (classType != null) {
            return classType;
        }

        try {
            final var existingKlass = Class.forName(klassName);
            return resolveKlass(existingKlass);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static @NonNull Klass getKlassFromType(final @NonNull Type type) {
        assert type != null;

        return switch (type) {
            case Klass klass -> klass;
            case GenericType genericType -> genericType.klass();
        };
    }

    public static @NonNull Klass getKlassFromConstantDesc(final @NonNull ConstantDesc value) {
        assert value != null;

        // should we avoid switch expressions here? (why?)
        if (value == ConstantDescs.NULL) {
            throw new UnsupportedOperationException("Null value is not supported yet");
        }
        return switch (value) {
            case String _ -> STRING_KLASS;
            case Integer _ -> INT_KLASS;
            case Long _ -> LONG_KLASS;
            case Float _ -> FLOAT_KLASS;
            case Double _ -> DOUBLE_KLASS;
            default -> resolveKlass(value.getClass());
        };
    }


    // Array pseudo-class
    private static final @NonNull String ARRAY_KLASS_NAME = "Array";

    // --------------------------------------
    // Primitive and most often used classes.
    // --------------------------------------

    // Void
    private static final @NonNull Klass VOID_KLASS = resolveKlass(Void.TYPE);
    private static final @NonNull String VOID_KLASS_NAME = "Void";
    // Int
    public static final @NonNull Klass INT_KLASS = resolveKlass(Integer.TYPE);
    private static final @NonNull String INT_KLASS_NAME = "Int";
    // Long
    public static final @NonNull Klass LONG_KLASS = resolveKlass(Long.TYPE);
    private static final @NonNull String LONG_KLASS_NAME = "Long";
    // Float
    public static final @NonNull Klass FLOAT_KLASS = resolveKlass(Float.TYPE);
    private static final @NonNull String FLOAT_KLASS_NAME = "Float";
    // Double
    public static final @NonNull Klass DOUBLE_KLASS = resolveKlass(Double.TYPE);
    private static final @NonNull String DOUBLE_KLASS_NAME = "Double";
    // String
    public static final @NonNull Klass STRING_KLASS = resolveKlass(String.class);
    private static final @NonNull String STRING_KLASS_NAME = "String";
}
