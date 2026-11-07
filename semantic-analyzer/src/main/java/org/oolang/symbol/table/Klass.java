/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.lang.invoke.TypeDescriptor;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

@SuppressWarnings("preview")
public sealed abstract class Klass implements TypeDescriptor.OfField<Klass>, ActualType
        permits Array, ExistingKlass, OolangKlass {

    private final @NonNull LazyConstant<@NonNull Parents> parents = LazyConstant.of(this::getAllParents);

    /// The cache of all resolved [classes][Klass].
    public static final @NonNull ScopedValue<@NonNull ConcurrentMap<@NonNull String, @NonNull Klass>> KLASSES_CACHE =
            ScopedValue.newInstance();

    public abstract boolean isInterface();

    abstract @NonNull String packageName();

    /// @return the superclass; null if this klass is an interface, [Object], a primitive class, or void.
    abstract @Nullable ActualType superKlass();

    /// @return the interfaces this class implements, can be empty.
    abstract @NonNull List<@NonNull ActualType> interfaces();

    /// @return all superclasses; empty if this klass is an interface, [Object], a primitive class, or void.
    public final @NonNull SequencedCollection<@NonNull ActualType> allSuperKlasses() {
        return parents.get().allSuperKlasses;
    }

    /// @return all interfaces this class implements, can be empty.
    final @NonNull SequencedCollection<@NonNull ActualType> allInterfaces() {
        return parents.get().allInterfaces;
    }

    abstract @NonNull Map<@NonNull String, @NonNull Property> properties();

    /// A [TreeSet] allows quick O(log n) range search by function name.
    ///
    /// If we stored the functions with a regular collection, a [java.util.stream.Stream] could be used to filter the
    /// functions by name, but with a worse 0(n) performance.
    abstract @NonNull SortedSet<@NonNull BaseFunction> functions();

    @Override
    public final boolean isAssignableFrom(final @NonNull ActualType otherType) {
        if (!(otherType instanceof Klass otherKlass)) {
            return false;
        }
        return this.descriptorString().equals(otherKlass.descriptorString())
                || hasAssignableParent(allSuperKlasses(), otherKlass)
                || hasAssignableParent(allInterfaces(), otherKlass);
    }

    private static boolean hasAssignableParent(final @NonNull SequencedCollection<@NonNull ActualType> parents,
                                               final @NonNull Klass otherKlass) {
        assert parents != null;
        assert otherKlass != null;

        return parents.stream()
                .map(TypeResolver::getKlassFromType)
                .anyMatch(superType -> superType.descriptorString().equals(otherKlass.descriptorString()));
    }

    public final @Nullable Symbol accessiblePropertyOrFunctionProperty(final @NonNull String name,
                                                                       final boolean includeSelf) {
        assert name != null;

        final var includeProtected = !includeSelf;

        if (includeSelf) {
            final var property = accessiblePropertyOrFunctionProperty(name, false, this);
            if (property != null) {
                return property;
            }
        }

        // Try all superclasses, then all superinterfaces
        for (final var superKlass : allSuperKlasses()) {
            final var property = accessiblePropertyOrFunctionProperty(name, includeProtected,
                    TypeResolver.getKlassFromType(superKlass));
            if (property != null) {
                return property;
            }
        }
        for (final var superInterface : allInterfaces()) {
            final var property = accessiblePropertyOrFunctionProperty(name, includeProtected,
                    TypeResolver.getKlassFromType(superInterface));
            if (property != null) {
                return property;
            }
        }
        return null;
    }

    private @Nullable Symbol accessiblePropertyOrFunctionProperty(final @NonNull String name,
                                                                  final boolean includeProtected,
                                                                  final @NonNull Klass klass) {
        assert name != null;
        assert klass != null;

        final var property = klass.properties().get(name);
        if (property == null) {
            return null;
        }
        // 1) property can be an accessible field
        switch (property.visibility()) {
            case PUBLIC -> {
                return property;
            }
            case JAVA_PROTECTED -> {
                if (includeProtected // protected in a superclass or itself
                        || this.packageName().equals(klass.packageName())) { // within the same package
                    return property;
                }
            }
            case OOLANG_PROTECTED -> {
                if (includeProtected) { // protected in a superclass
                    return property;
                }
            }
            case JAVA_PACKAGE_PRIVATE -> {
                if (this.packageName().equals(klass.packageName())) { // within the same package
                    return property;
                }
            }
            case PRIVATE -> {
                if (includeProtected && this.descriptorString().equals(klass.descriptorString())) { // the current class
                    return property;
                }
            }
        }

        // 2) property can be a function property
        final var getterFunction = property.getter;
        if (getterFunction != null) {
            switch (getterFunction.visibility()) {
                case PUBLIC -> {
                    return getterFunction;
                }
                case JAVA_PROTECTED -> {
                    if (includeProtected // protected in a superclass or itself
                            || this.packageName().equals(klass.packageName())) { // within the same package
                        return getterFunction;
                    }
                }
                case OOLANG_PROTECTED -> {
                    if (includeProtected) { // protected in a superclass
                        return getterFunction;
                    }
                }
            }
        }

        return null;
    }

    public final @Nullable Function accessibleFunction(final @NonNull String name,
                                                       final @NonNull List<@NonNull ActualType> parameterTypes,
                                                       final boolean includeProtected,
                                                       final boolean includePrivate) {
        assert name != null;
        assert parameterTypes != null;

        var function = accessibleFunction(name, parameterTypes, includeProtected, includePrivate, this);
        if (function != null) {
            return function;
        }

        // Try all superclasses, then all superinterfaces
        for (final var superKlass : allSuperKlasses()) {
            function = accessibleFunction(name, parameterTypes, includeProtected, false,
                    TypeResolver.getKlassFromType(superKlass));
            if (function != null) {
                return function;
            }
        }
        for (final var superInterface : allInterfaces()) {
            function = accessibleFunction(name, parameterTypes, includeProtected, false,
                    TypeResolver.getKlassFromType(superInterface));
            if (function != null) {
                return function;
            }
        }
        return null;
    }

    private @Nullable Function accessibleFunction(final @NonNull String name,
                                                  final @NonNull List<@NonNull ActualType> parameterTypes,
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
            switch (candidateFunction.visibility()) {
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
                                                final @NonNull List<@NonNull ActualType> parameterTypes) {
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

    /// Recursively finds all superclasses and interfaces this klass extends/implements.
    private @NonNull Parents getAllParents() {
        final var parents = new Parents();
        // Traverse superclasses (recursively)
        processSuperclass(this, parents);
        // Traverse interfaces (recursively)
        processInterfaces(this, parents);
        return parents;
    }

    // Recursively collect all superclasses and their superinterfaces
    private static void processSuperclass(final @NonNull Klass klass,
                                          final @NonNull Parents parents) {
        assert klass != null;
        assert parents != null;

        final var superKlassType = klass.superKlass();
        if (superKlassType != null) {
            parents.allSuperKlasses.add(superKlassType); // Add direct superclass
            final var superKlass = TypeResolver.getKlassFromType(superKlassType);
            processSuperclass(superKlass, parents); // Recurse on the superclass's superClass
            processInterfaces(superKlass, parents); // Recurse on the superclass's superinterfaces
        }
    }

    // Recursively collect all interfaces and their superinterfaces
    private static void processInterfaces(final @NonNull Klass klass,
                                          final @NonNull Parents parents) {
        assert klass != null;
        assert parents != null;

        final var interfacesTypes = klass.interfaces();
        for (final var interfaceType : interfacesTypes) {
            // Add the interface only if it's not already in the set (avoids duplicates)
            if (parents.allInterfaces.add(interfaceType)) {
                processInterfaces(TypeResolver.getKlassFromType(interfaceType), parents); // Recurse on the interface's superinterfaces
            }
        }
    }

    record SimpleFunction(@NonNull String name) implements org.oolang.symbol.table.BaseFunction {
    }

    private static final class Parents {
        private final @NonNull SequencedCollection<@NonNull ActualType> allSuperKlasses = new ArrayList<>();
        private final @NonNull SequencedCollection<@NonNull ActualType> allInterfaces = new TreeSet<>();
    }

    @Override
    public final boolean isPrimitive() {
        throw new UnsupportedOperationException("We don't need this method");
    }
}
