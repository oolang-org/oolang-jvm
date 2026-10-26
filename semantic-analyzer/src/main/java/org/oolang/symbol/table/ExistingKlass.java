/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.oolang.symbol.table.Function.Parameter;
import org.oolang.symbol.table.FunctionPropertyUtils.*;

import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

import static org.oolang.symbol.table.FunctionPropertyUtils.*;


@SuppressWarnings("preview")
final class ExistingKlass implements Klass {
    private final @NonNull Class<?> javaClass;
    private final @NonNull LazyConstant<@NonNull Parents> parents = LazyConstant.of(this::getAllParents);
    private final @NonNull LazyConstant<@NonNull Map<@NonNull String, @NonNull Property>> properties =
            LazyConstant.of(this::getProperties);
    private final @NonNull LazyConstant<@NonNull Functions> functions =
            LazyConstant.of(this::getFunctions);

    ExistingKlass(final @NonNull Class<?> javaClass) {
        assert javaClass != null;

        this.javaClass = javaClass;
    }

    /// Recursively finds all superclasses and interfaces [#javaClass] extends/implements.
    private @NonNull Parents getAllParents() {
        final var parents = new Parents();
        // Traverse superclasses (recursively)
        processSuperclass(javaClass, parents);
        // Traverse interfaces (recursively)
        processInterfaces(javaClass, parents);
        return parents;
    }

    // Recursively collect all superclasses and their superinterfaces
    private static void processSuperclass(final @NonNull Class<?> clazz,
                                          final @NonNull Parents parents) {
        assert clazz != null;
        assert parents != null;

        final var genericSuperclass = clazz.getGenericSuperclass();
        if (genericSuperclass != null) {
            parents.genericSuperKlasses.add(TypeResolver.resolveType(genericSuperclass)); // Add direct superclass
            final var superclass = clazz.getSuperclass();
            processSuperclass(superclass, parents); // Recurse on the superclass's superClass
            processInterfaces(superclass, parents); // Recurse on the superclass's superinterfaces
        }
    }

    // Recursively collect all interfaces and their superinterfaces
    private static void processInterfaces(final @NonNull Class<?> clazz,
                                          final @NonNull Parents parents) {
        assert clazz != null;
        assert parents != null;

        final var genericInterfaces = clazz.getGenericInterfaces();
        final var interfaces = clazz.getInterfaces();
        for (var i = 0; i < genericInterfaces.length; i++) {
            final var genericInterface = genericInterfaces[i];
            // Add the interface only if it's not already in the set (avoids duplicates)
            if (parents.genericSuperInterfaces.add(TypeResolver.resolveType(genericInterface))) {
                processInterfaces(interfaces[i], parents); // Recurse on the interface's superinterfaces
            }
        }
    }

    @Override
    public boolean isInterface() {
        return javaClass.isInterface();
    }

    @Override
    public @NonNull String packageName() {
        return javaClass.getPackageName();
    }

    @Override
    public @NonNull SequencedCollection<@NonNull ActualType> genericSuperKlasses() {
        return parents.get().genericSuperKlasses;
    }

    @Override
    public @NonNull SequencedCollection<@NonNull ActualType> genericSuperInterfaces() {
        return parents.get().genericSuperInterfaces;
    }

    @Override
    public @NonNull Map<@NonNull String, @NonNull Property> properties() {
        return properties.get();
    }

    @Override
    public @NonNull SortedSet<@NonNull BaseFunction> functions() {
        return functions.get().functions;
    }

    private @NonNull Map<@NonNull String, @NonNull Property> getProperties() {
        final var properties = new HashMap<@NonNull String, @NonNull Property>();
        // 1) add regular fields
        addFieldProperties(properties);
        // 2) add function properties
        addFunctionProperties(functions.get().propertyCandidates, javaClass, properties);
        return properties;
    }

    private void addFieldProperties(final @NonNull Map<@NonNull String, @NonNull Property> properties) {
        assert properties != null;

        for (final var field : javaClass.getDeclaredFields()) {
            final var mod = field.getModifiers();
            if (Modifier.isPrivate(mod)) {
                continue;
            }
            final var name = field.getName();

            final var property = new Property(this,
                    name,
                    visibilityFromModifiers(mod),
                    Modifier.isStatic(mod),
                    Modifier.isAbstract(mod),
                    Modifier.isFinal(mod),
                    TypeResolver.resolveType(field.getGenericType()));
            properties.put(name, property);
        }
    }

    private @NonNull Functions getFunctions() {
        final var maybeProperties = new HashMap<@NonNull String, @NonNull MaybeProperty>();
        final SortedSet<@NonNull BaseFunction> functions = Arrays.stream(javaClass.getDeclaredMethods())
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .map(method -> {
                    final var parameters = Arrays.stream(method.getParameters())
                            .map(p -> {
                                final var paramName = p.isNamePresent() ? p.getName() : null;
                                return new Parameter(paramName, TypeResolver.resolveType(p.getParameterizedType()));
                            }).toList();

                    final var mod = method.getModifiers();
                    final var function = new Function(this,
                            method.getName(),
                            visibilityFromModifiers(mod),
                            Modifier.isStatic(mod),
                            Modifier.isAbstract(mod),
                            Modifier.isFinal(mod),
                            TypeResolver.resolveType(method.getGenericReturnType()),
                            parameters);
                    // this function may be a property candidate
                    addToMaybePropertiesIfEligible(function, maybeProperties);
                    return function;
                }).collect(Collectors.toCollection(TreeSet::new));

        return new Functions(
                functions,
                propertyCandidatesFromMaybeProperties(maybeProperties));
    }

    private static @NonNull Visibility visibilityFromModifiers(final int mod) {
        // no need for private
        if (Modifier.isPublic(mod)) {
            return Visibility.PUBLIC;
        }
        if (Modifier.isProtected(mod)) {
            return Visibility.JAVA_PROTECTED;
        }
        return Visibility.JAVA_PACKAGE_PRIVATE;
    }

    @Override
    public @NonNull String descriptorString() {
        return javaClass.descriptorString();
    }

    @Override
    public boolean isArray() {
        return javaClass.isArray();
    }

    @Override
    public @NonNull Klass componentType() {
        return TypeResolver.resolveKlass(javaClass.componentType());
    }

    @Override
    public @NonNull Klass arrayType() {
        return TypeResolver.resolveKlass(javaClass.arrayType());
    }

    private static final class Parents {
        private final @NonNull SequencedCollection<@NonNull ActualType> genericSuperKlasses = new ArrayList<>();
        private final @NonNull SequencedCollection<@NonNull ActualType> genericSuperInterfaces = new TreeSet<>();
    }

    private record Functions(
            @NonNull SortedSet<@NonNull BaseFunction> functions,
            @NonNull PropertyCandidates propertyCandidates) {
    }
}
