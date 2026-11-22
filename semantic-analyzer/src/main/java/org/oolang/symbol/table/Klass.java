/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.symbol.table.BaseFunction.SimpleFunction;

import java.lang.invoke.TypeDescriptor;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

import static org.oolang.symbol.table.TypeUtils.compatibleParameters;
import static org.oolang.symbol.table.TypeUtils.hasAssignableParent;

@SuppressWarnings("preview")
public sealed abstract class Klass implements TypeDescriptor.OfField<Klass>, ActualType
        permits Array, ExistingKlass, OolangKlass {

    public static final byte ACCESS_INSTANCE = 1;
    public static final byte ACCESS_STATIC = 2;
    public static final byte ACCESS_BOTH = 3;

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

    abstract @NonNull Properties properties();

    abstract @NonNull Functions functions();

    @Override
    public final boolean isAssignableFrom(final @NonNull ActualType otherType) {
        assert otherType != null;

        if (!(otherType instanceof Klass otherKlass)) {
            return false;
        }
        return this.descriptorString().equals(otherKlass.descriptorString())
                || hasAssignableParent(allSuperKlasses(), otherKlass)
                || hasAssignableParent(allInterfaces(), otherKlass);
    }

    public final @Nullable PropertyOrFunction accessiblePropertyOrFunctionProperty(final @NonNull String name,
                                                                                   final boolean includeSelf,
                                                                                   final boolean includeProtected,
                                                                                   final boolean includePrivate,
                                                                                   final boolean setter,
                                                                                   final byte access) {
        assert name != null;

        if (includeSelf) {
            final var property = accessiblePropertyOrFunctionProperty(name, includeProtected, includePrivate, setter,
                    access, this);
            if (property != null) {
                return property;
            }
        }

        // Try all superclasses, then all superinterfaces
        for (final var superKlass : allSuperKlasses()) {
            final var property = accessiblePropertyOrFunctionProperty(name, includeProtected, false, setter,
                    access, TypeResolver.getKlassFromType(superKlass));
            if (property != null) {
                return property;
            }
        }
        for (final var superInterface : allInterfaces()) {
            final var property = accessiblePropertyOrFunctionProperty(name, includeProtected, false, setter,
                    access, TypeResolver.getKlassFromType(superInterface));
            if (property != null) {
                return property;
            }
        }
        return null;
    }

    private @Nullable PropertyOrFunction accessiblePropertyOrFunctionProperty(final @NonNull String name,
                                                                              final boolean includeProtected,
                                                                              final boolean includePrivate,
                                                                              final boolean setter,
                                                                              final byte access,
                                                                              final @NonNull Klass klass) {
        assert name != null;
        assert klass != null;

        PropertyOrFunction propertyOrFunction = null;
        // search for instance function first
        if ((access & ACCESS_INSTANCE) == ACCESS_INSTANCE) {
            propertyOrFunction = accessiblePropertyOrFunctionProperty(name, includeProtected, includePrivate, setter,
                    klass.properties().instanceProperties, klass.packageName(), klass.descriptorString());
        }
        if (propertyOrFunction == null && (access & ACCESS_STATIC) == ACCESS_STATIC) {
            propertyOrFunction = accessiblePropertyOrFunctionProperty(name, includeProtected, includePrivate, setter,
                    klass.properties().staticProperties, klass.packageName(), klass.descriptorString());
        }
        return propertyOrFunction;
    }

    private @Nullable PropertyOrFunction accessiblePropertyOrFunctionProperty(
            final @NonNull String name,
            final boolean includeProtected,
            final boolean includePrivate,
            final boolean setter,
            final @NonNull Map<@NonNull String, @NonNull Property> properties,
            final @NonNull String klassPackageName,
            final @NonNull String klassDescriptoString
    ) {
        assert name != null;
        assert properties != null;
        assert klassPackageName != null;
        assert klassDescriptoString != null;

        final var property = properties.get(name);
        if (property == null || (setter && property.isFinal())) {
            return null;
        }

        // 1) property can be an accessible field
        switch (property.visibility()) {
            case PUBLIC -> {
                return property;
            }
            case JAVA_PROTECTED -> {
                if (includeProtected // protected in a superclass or itself
                        || this.packageName().equals(klassPackageName)) { // within the same package
                    return property;
                }
            }
            case OOLANG_PROTECTED -> {
                if (includeProtected) { // protected in a superclass
                    return property;
                }
            }
            case JAVA_PACKAGE_PRIVATE -> {
                if (this.packageName().equals(klassPackageName)) { // within the same package
                    return property;
                }
            }
            case PRIVATE -> {
                if (includePrivate && this.descriptorString().equals(klassDescriptoString)) { // the current class
                    return property;
                }
            }
        }

        // 2) property can be a function property
        final var function = setter ? property.setter : property.getter;
        if (function != null) {
            switch (function.visibility()) {
                case PUBLIC -> {
                    return function;
                }
                case JAVA_PROTECTED -> {
                    if (includeProtected // protected in a superclass or itself
                            || this.packageName().equals(klassPackageName)) { // within the same package
                        return function;
                    }
                }
                case OOLANG_PROTECTED -> {
                    if (includeProtected) { // protected in a superclass
                        return function;
                    }
                }
            }
        }

        return null;
    }

    public final @Nullable Function accessibleFunction(final @NonNull String name,
                                                       final @NonNull List<@NonNull ActualType> parameterTypes,
                                                       final boolean includeSelf,
                                                       final boolean includeProtected,
                                                       final boolean includePrivate,
                                                       final byte access) {
        assert name != null;
        assert parameterTypes != null;

        if (includeSelf) {
            final var function = accessibleFunction(name, parameterTypes, includeProtected, includePrivate, access,
                    this);
            if (function != null) {
                return function;
            }
        }

        // Try all superclasses, then all superinterfaces
        for (final var superKlass : allSuperKlasses()) {
            final var function = accessibleFunction(name, parameterTypes, includeProtected, false, access,
                    TypeResolver.getKlassFromType(superKlass));
            if (function != null) {
                return function;
            }
        }
        for (final var superInterface : allInterfaces()) {
            final var function = accessibleFunction(name, parameterTypes, includeProtected, false, access,
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
                                                  final byte access,
                                                  final @NonNull Klass klass) {
        assert name != null;
        assert parameterTypes != null;
        assert klass != null;

        // search limits = funName / funName0. There may be several functions with the same name.
        final var searchFunctionFrom = new SimpleFunction(name);
        final var searchFunctionTo = new BaseFunction.SimpleFunction(name + "0");
        Function function = null;
        // search for instance function first
        if ((access & ACCESS_INSTANCE) == ACCESS_INSTANCE) {
            function = accessibleFunction(searchFunctionFrom, searchFunctionTo, parameterTypes,
                    includeProtected, includePrivate, klass.functions().instanceFunctions, klass.packageName());
        }
        if (function == null && (access & ACCESS_STATIC) == ACCESS_STATIC) {
            function = accessibleFunction(searchFunctionFrom, searchFunctionTo, parameterTypes,
                    includeProtected, includePrivate, klass.functions().staticFunctions, klass.packageName());
        }
        return function;
    }

    private @Nullable Function accessibleFunction(final @NonNull SimpleFunction searchFunctionFrom,
                                                  final @NonNull SimpleFunction searchFunctionTo,
                                                  final @NonNull List<@NonNull ActualType> parameterTypes,
                                                  final boolean includeProtected,
                                                  final boolean includePrivate,
                                                  final @NonNull SortedSet<@NonNull BaseFunction> klassFunctions,
                                                  final @NonNull String klassPackageName) {
        assert searchFunctionFrom != null;
        assert searchFunctionTo != null;
        assert parameterTypes != null;
        assert klassFunctions != null;
        assert klassPackageName != null;

        final var candidateFunctions = klassFunctions.subSet(searchFunctionFrom, searchFunctionTo);
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
                    if (this.packageName().equals(klassPackageName) // within the same package
                            && compatibleParameters(candidateFunction, parameterTypes)) {
                        return candidateFunction;
                    }
                }
                case JAVA_PROTECTED -> {
                    if ((includeProtected || /*within the same package*/ this.packageName().equals(klassPackageName))
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

    private static final class Parents {
        private final @NonNull SequencedCollection<@NonNull ActualType> allSuperKlasses = new ArrayList<>();
        private final @NonNull SequencedCollection<@NonNull ActualType> allInterfaces = new TreeSet<>();
    }

    public static final class Properties {
        public final @NonNull Map<@NonNull String, @NonNull Property> instanceProperties = new HashMap<>();
        public final @NonNull Map<@NonNull String, @NonNull Property> staticProperties = new HashMap<>();
    }

    /// Impl note: A [TreeSet] allows quick O(log n) range search by function name.
    ///
    /// If we stored the functions with a regular collection, a [java.util.stream.Stream] could be used to filter the
    /// functions by name, but with a worse 0(n) performance.
    public static sealed class Functions permits ExistingKlass.FunctionsAndPropertyCandidates {
        public final @NonNull SortedSet<@NonNull BaseFunction> instanceFunctions = new TreeSet<>();
        public final @NonNull SortedSet<@NonNull BaseFunction> staticFunctions = new TreeSet<>();
    }

    @Override
    public final boolean isPrimitive() {
        throw new UnsupportedOperationException("We don't need this method");
    }
}
