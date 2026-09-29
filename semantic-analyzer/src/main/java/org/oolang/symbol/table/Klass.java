/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.symbol.table.BaseSymbol.BaseFunction;
import org.oolang.symbol.table.BaseSymbol.Function;
import org.oolang.symbol.table.BaseSymbol.Property;

import java.lang.invoke.TypeDescriptor;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public sealed interface Klass extends TypeDescriptor.OfField<Klass>, Type
        permits Array, ExistingKlass, OolangKlass {

    boolean isInterface();

    @NonNull String packageName();

    /**
     * @return all superclasses; empty if this klass is an interface, {@link Object}, a primitive class, or void.
     */
    @NonNull SequencedCollection<@NonNull Type> genericSuperKlasses();

    /**
     * @return all superinterfaces.
     */
    @NonNull SequencedCollection<@NonNull Type> genericSuperInterfaces();

    @NonNull Map<@NonNull String, @NonNull Property> properties();

    /**
     * A {@link TreeSet} allows quick O(log n) range search by function name.
     * <p>
     * If we stored the functions with a regular collection, a {@linkplain java.util.stream.Stream} could be used to
     * filter the functions by name, but with a worse 0(n) performance.
     */
    @NonNull SortedSet<@NonNull BaseFunction> functions();

    @Override
    default boolean isAssignableFrom(final @NonNull Type otherType) {
        if (!(otherType instanceof Klass otherKlass)) {
            return false;
        }
        return this.descriptorString().equals(otherKlass.descriptorString())
                || hasAssignableParent(genericSuperKlasses(), otherKlass)
                || hasAssignableParent(genericSuperInterfaces(), otherKlass);
    }

    private static boolean hasAssignableParent(final @NonNull SequencedCollection<@NonNull Type> parents,
                                               final @NonNull Klass otherKlass) {
        return parents.stream()
                .map(TypeResolver::getKlassFromType)
                .anyMatch(superType -> superType.descriptorString().equals(otherKlass.descriptorString()));
    }

    default @Nullable Property accessibleProperty(final @NonNull String name, final boolean includeSelf) {
        assert name != null;

        final var includeProtected = !includeSelf;

        if (includeSelf) {
            final var property = accessibleProperty(name, false, this);
            if (property != null) {
                return property;
            }
        }

        // Try all superclasses, then all superinterfaces
        for (final var superKlass : genericSuperKlasses()) {
            final var property = accessibleProperty(name, includeProtected, TypeResolver.getKlassFromType(superKlass));
            if (property != null) {
                return property;
            }
        }
        for (final var superInterface : genericSuperInterfaces()) {
            final var property = accessibleProperty(name, includeProtected,
                    TypeResolver.getKlassFromType(superInterface));
            if (property != null) {
                return property;
            }
        }
        return null;
    }

    private @Nullable Property accessibleProperty(final @NonNull String name,
                                                  final boolean includeProtected,
                                                  final @NonNull Klass klass) {
        assert name != null;
        assert klass != null;

        final var properties = klass.properties();
        if (properties.containsKey(name)) {
            final var property = properties.get(name);
            switch (property.visibility) {
                case PUBLIC -> {
                    return property;
                }
                case JAVA_PACKAGE_PRIVATE -> {
                    if (this.packageName().equals(klass.packageName())) { // within the same package
                        return property;
                    }
                }
                case JAVA_PROTECTED -> {
                    if (includeProtected // protected in a superclass
                            || this.packageName().equals(klass.packageName())) { // within the same package
                        return property;
                    }
                }
                case OOLANG_PROTECTED -> {
                    if (includeProtected) { // protected in a superclass
                        return property;
                    }
                }
            }
        }
        return null;
    }

    default @Nullable Function accessibleFunction(final @NonNull String name,
                                                  final @NonNull List<@NonNull Type> parameterTypes,
                                                  final boolean includeProtected) {
        assert name != null;
        assert parameterTypes != null;

        var function = accessibleFunction(name, parameterTypes, includeProtected, includeProtected, this);
        if (function != null) {
            return function;
        }

        // Try all superclasses, then all superinterfaces
        for (final var superKlass : genericSuperKlasses()) {
            function = accessibleFunction(name, parameterTypes, includeProtected, false,
                    TypeResolver.getKlassFromType(superKlass));
            if (function != null) {
                return function;
            }
        }
        for (final var superInterface : genericSuperInterfaces()) {
            function = accessibleFunction(name, parameterTypes, includeProtected, false,
                    TypeResolver.getKlassFromType(superInterface));
            if (function != null) {
                return function;
            }
        }
        return null;
    }

    private @Nullable Function accessibleFunction(final @NonNull String name,
                                                  final @NonNull List<@NonNull Type> parameterTypes,
                                                  final boolean includeProtected,
                                                  final boolean includePrivate,
                                                  final @NonNull Klass klass) {
        assert name != null;
        assert parameterTypes != null;
        assert klass != null;

        // search limits = funName / funName0. There may be several functions with the same name.
        final var searchFunctionFrom = new SimpleFunction(name);
        final var searchFunctionTo = new SimpleFunction(name + "0");
        final var candidateFunctions = klass.functions().subSet(searchFunctionFrom, searchFunctionTo);
        for (final var candidateBaseFunction : candidateFunctions) {
            final var candidateFunction = (Function) candidateBaseFunction;
            switch (candidateFunction.visibility) {
                case PUBLIC -> {
                    if (compatibleParameters(candidateFunction, parameterTypes)) {
                        return candidateFunction;
                    }
                }
                case PRIVATE -> {
                    if (includePrivate && compatibleParameters(candidateFunction, parameterTypes)) {
                        return candidateFunction;
                    }
                }
                case JAVA_PACKAGE_PRIVATE -> {
                    if (this.packageName().equals(klass.packageName()) // within the same package
                            && compatibleParameters(candidateFunction, parameterTypes)) {
                        return candidateFunction;
                    }
                }
                case JAVA_PROTECTED -> {
                    if ((includeProtected || /*within the same package*/ this.packageName().equals(klass.packageName()))
                            && compatibleParameters(candidateFunction, parameterTypes)) {
                        return candidateFunction;
                    }
                }
                case OOLANG_PROTECTED -> {
                    if (includeProtected && compatibleParameters(candidateFunction, parameterTypes)) {
                        return candidateFunction;
                    }
                }
            }
        }
        return null;
    }

    private static boolean compatibleParameters(final @NonNull Function candidateFunction,
                                                final @NonNull List<@NonNull Type> parameterTypes) {
        assert candidateFunction != null;
        assert parameterTypes != null;

        // fail-fast if candidate function has wrong number of parameters
        if (candidateFunction.parameters.size() != parameterTypes.size()) {
            return false;
        }

        for (var i = 0; i < candidateFunction.parameters.size(); i++) {
            if (!candidateFunction.parameters.get(i).type().isAssignableFrom(parameterTypes.get(i))) {
                return false;
            }
        }
        return true;
    }

    record SimpleFunction(@NonNull String name) implements BaseFunction {
    }

    /**
     * The cache of all resolved {@linkplain Klass classes}.
     */
    @NonNull ScopedValue<@NonNull ConcurrentHashMap<@NonNull String, @NonNull Klass>> KLASSES_CACHE =
            ScopedValue.newInstance();

    @Override
    default boolean isPrimitive() {
        throw new UnsupportedOperationException("We don't need this method");
    }
}
