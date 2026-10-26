/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AstType;
import org.oolang.ast.expression.ConstantExpression;
import org.oolang.ast.expression.Expression;
import org.oolang.semantic.analyzer.OolangSemanticException;
import org.oolang.symbol.table.ActualType.GenericType;

import java.lang.constant.ConstantDesc;
import java.lang.constant.ConstantDescs;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

import static org.oolang.ast.Identifier.MultipleIdentifier;
import static org.oolang.ast.Identifier.SimpleIdentifier;
import static org.oolang.symbol.table.Klass.KLASSES_CACHE;

public final class TypeResolver {
    // un-instantiable
    private TypeResolver() {
    }

    static @NonNull ActualType resolveType(final java.lang.reflect.@NonNull Type javaType) {
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

    private static @NonNull ActualType resolveParameterizedType(final @NonNull ParameterizedType parameterizedType) {
        assert parameterizedType != null;

        if (!(parameterizedType.getRawType() instanceof Class<?> javaClass)) {
            throw new IllegalArgumentException("Raw type: " + parameterizedType.getRawType() + " is not a class");
        }
        final var parameters = Arrays.stream(parameterizedType.getActualTypeArguments())
                .map(TypeResolver::resolveType)
                .toList();

        return new GenericType(resolveKlass(javaClass), parameters);
    }

    private static @NonNull ActualType resolveWildcardType(final @NonNull WildcardType wildcardType) {
        assert wildcardType != null;

        // todo proper implementation
        if (wildcardType.getUpperBounds().length != 1) {
            throw new IllegalArgumentException("Problem resolving wildcard type: " + wildcardType);
        }
        return resolveType(wildcardType.getUpperBounds()[0]);
    }

    public static @NonNull ActualType resolveType(final @Nullable AstType astType,
                                                  final @NonNull OolangKlass oolangKlass,
                                                  final boolean isArray) {
        assert oolangKlass != null;

        // no type = void
        if (astType == null) {
            return VOID_KLASS;
        }

        // generic type with parameters
        if (astType.parameters != null) {
            final var klass = resolveKlass(astType, oolangKlass, isArray);

            // specific array pseudo-class case
            if (klass == Array.getInstance()) {
                if (astType.parameters.size() != 1) {
                    // todo throw a semantic analysis exception
                    throw new RuntimeException("An array must have exactly one parameter");
                }
                return resolveType(astType.parameters.getFirst(), oolangKlass, true);
            }

            return new GenericType(
                    klass,
                    astType.parameters.stream()
                            .map(parameterType -> resolveType(parameterType, oolangKlass, false))
                            .toList()
            );
        }

        // simple type
        return resolveKlass(astType, oolangKlass, isArray);
    }

    private static @NonNull Klass resolveKlass(final @NonNull AstType astType,
                                               final @NonNull OolangKlass oolangKlass,
                                               final boolean isArray) {
        assert astType != null;
        assert oolangKlass != null;

        final var klass = switch (astType.identifier) {
            // must resolve the class name
            case SimpleIdentifier simpleId -> resolveKlassFromSimpleName(simpleId.identifier, oolangKlass);
            // fully qualified class name
            case MultipleIdentifier multipleId -> getKlassFromName(multipleId.rawName());
        };
        if (klass == null) {
            throw new OolangSemanticException("Could not resolve klass from name " + astType.identifier.description());
        }

        return (isArray) ? klass.arrayType() : klass;
    }

    public static @Nullable Klass resolveKlassFromSimpleName(final @NonNull String simpleKlassName,
                                                             final @NonNull OolangKlass oolangKlass) {
        assert simpleKlassName != null;
        assert oolangKlass != null;

        // 1) try to get the fully qualified class name from an import, if present search with this full class name
        var fullKlassName = oolangKlass.imports.get(simpleKlassName);
        if (fullKlassName != null) {
            return getKlassFromName(fullKlassName);
        }

        // 2) search for class from the same package that doesn't need to be imported
        final var klass = getKlassFromName(oolangKlass.packageName() + "." + simpleKlassName);
        if (klass != null) {
            return klass;
        }

        // 3) fast-path for primitives and most often used classes and for the Array pseudo-class, no cache call
        switch (simpleKlassName) {
            case STRING_KLASS_NAME -> {
                return STRING_KLASS;
            }
            case INT_KLASS_NAME -> {
                return INT_PRIMITIVE_KLASS;
            }
            case LONG_KLASS_NAME -> {
                return LONG_PRIMITIVE_KLASS;
            }
            case FLOAT_KLASS_NAME -> {
                return FLOAT_PRIMITIVE_KLASS;
            }
            case DOUBLE_KLASS_NAME -> {
                return DOUBLE_PRIMITIVE_KLASS;
            }
            case OBJECT_KLASS_NAME -> {
                return OBJECT_KLASS;
            }
            case VOID_KLASS_NAME -> {
                return VOID_KLASS;
            }
            case ARRAY_KLASS_NAME -> {
                return Array.getInstance();
            }
        }

        // 4) search for class from the java.lang package that doesn't need to be imported
        return getKlassFromName("java.lang." + simpleKlassName);
    }

    /// **Important note:** this method requires that the symbol table was built for all Oolang files, and therefore
    /// the corresponding [OolangKlass] is present in the [klass cache][Klass#KLASSES_CACHE].
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

    public static @NonNull Klass getKlassFromType(final @NonNull ActualType type) {
        assert type != null;

        return switch (type) {
            case Klass klass -> klass;
            case GenericType genericType -> genericType.klass();
        };
    }

    static @Nullable Klass inferKlass(final Expression expression) {
        if (expression instanceof ConstantExpression constantExpression) {
            return getKlassFromConstantDesc(constantExpression.value);
        }
        return null;
    }

    public static @NonNull Klass getKlassFromConstantDesc(final @NonNull ConstantDesc value) {
        assert value != null;

        // should we avoid switch expressions here? (why?)
        if (value == ConstantDescs.NULL) {
            throw new UnsupportedOperationException("Null value is not supported yet");
        }
        return switch (value) {
            case String _ -> STRING_KLASS;
            case Integer _ -> INT_PRIMITIVE_KLASS;
            case Long _ -> LONG_PRIMITIVE_KLASS;
            case Float _ -> FLOAT_PRIMITIVE_KLASS;
            case Double _ -> DOUBLE_PRIMITIVE_KLASS;
            default -> resolveKlass(value.getClass());
        };
    }


    // Array pseudo-class
    private static final @NonNull String ARRAY_KLASS_NAME = "Array";

    // --------------------------------------
    // Primitive and most often used classes.
    // --------------------------------------

    // Int
    public static final @NonNull Klass INT_PRIMITIVE_KLASS = resolveKlass(Integer.TYPE);
    private static final @NonNull Klass INT_WRAPPER_KLASS = resolveKlass(Integer.class);
    private static final @NonNull String INT_KLASS_NAME = "Int";
    // Long
    public static final @NonNull Klass LONG_PRIMITIVE_KLASS = resolveKlass(Long.TYPE);
    private static final @NonNull Klass LONG_WRAPPER_KLASS = resolveKlass(Long.class);
    private static final @NonNull String LONG_KLASS_NAME = "Long";
    // Float
    public static final @NonNull Klass FLOAT_PRIMITIVE_KLASS = resolveKlass(Float.TYPE);
    private static final @NonNull Klass FLOAT_WRAPPER_KLASS = resolveKlass(Float.class);
    private static final @NonNull String FLOAT_KLASS_NAME = "Float";
    // Double
    public static final @NonNull Klass DOUBLE_PRIMITIVE_KLASS = resolveKlass(Double.TYPE);
    private static final @NonNull Klass DOUBLE_WRAPPER_KLASS = resolveKlass(Double.class);
    private static final @NonNull String DOUBLE_KLASS_NAME = "Double";
    // String
    public static final @NonNull Klass STRING_KLASS = resolveKlass(String.class);
    private static final @NonNull String STRING_KLASS_NAME = "String";
    // Object
    public static final @NonNull Klass OBJECT_KLASS = resolveKlass(Object.class);
    private static final @NonNull String OBJECT_KLASS_NAME = "Object";
    // Void
    private static final @NonNull Klass VOID_KLASS = resolveKlass(Void.TYPE);
    private static final @NonNull String VOID_KLASS_NAME = "Void";
}
