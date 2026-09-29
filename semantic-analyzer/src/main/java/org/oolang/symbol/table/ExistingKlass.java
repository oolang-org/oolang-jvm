/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.oolang.symbol.table.BaseSymbol.BaseFunction;
import org.oolang.symbol.table.BaseSymbol.Function;
import org.oolang.symbol.table.BaseSymbol.Function.Parameter;
import org.oolang.symbol.table.BaseSymbol.Property;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("preview")
final class ExistingKlass implements Klass {
    private final @NonNull Class<?> javaClass;
    private final @NonNull LazyConstant<@NonNull Parents> parents = LazyConstant.of(this::getAllParents);
    private final @NonNull LazyConstant<@NonNull Map<@NonNull String, @NonNull Property>> properties =
            LazyConstant.of(this::getProperties);
    private final @NonNull LazyConstant<@NonNull SortedSet<@NonNull BaseFunction>> functions =
            LazyConstant.of(this::getFunctions);

    ExistingKlass(final @NonNull Class<?> javaClass) {
        assert javaClass != null;

        this.javaClass = javaClass;
    }

    /**
     * Recursively finds all superclasses and interfaces {@link #javaClass} extends/implements.
     */
    private @NonNull Parents getAllParents() {
        final var parents = new Parents();
        // Traverse superclasses (recursively)
        processSuperclass(javaClass, parents);
        // Traverse interfaces (recursively)
        processInterfaces(javaClass, parents);
        return parents;
    }

    // todo use it to get method attributes (oolang-get / oolang-set)
    private ClassModel classModelFromClass(final @NonNull Class<?> javaClass) {
        assert javaClass != null;

        // 1) Convert the class name to its expected resource path format
        String resourceName = javaClass.getSimpleName() + ".class";

        // 2) Read the raw bytecode bytes using the class loader
        byte[] classBytes;
        try (final var is = javaClass.getResourceAsStream(resourceName)) {
            if (is == null) {
                return null;
            }
            classBytes = is.readAllBytes();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        // 3) Parse the bytes into a ClassModel using the Class-File API
        return ClassFile.of().parse(classBytes);
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
    public @NonNull SequencedCollection<@NonNull Type> genericSuperKlasses() {
        return parents.get().genericSuperKlasses;
    }

    @Override
    public @NonNull SequencedCollection<@NonNull Type> genericSuperInterfaces() {
        return parents.get().genericSuperInterfaces;
    }

    @Override
    public @NonNull Map<@NonNull String, @NonNull Property> properties() {
        return properties.get();
    }

    @Override
    public @NonNull SortedSet<@NonNull BaseFunction> functions() {
        return functions.get();
    }

    private @NonNull Map<@NonNull String, @NonNull Property> getProperties() {
        return Arrays.stream(javaClass.getDeclaredFields())
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .map(field -> {
                    final var name = field.getName();
                    final var mod = field.getModifiers();
                    return new Property(this,
                            name,
                            visibilityFromModifiers(mod),
                            Modifier.isStatic(mod),
                            Modifier.isAbstract(mod),
                            Modifier.isFinal(mod),
                            TypeResolver.resolveType(field.getGenericType()));
                }).collect(Collectors.toMap(p -> p.name, java.util.function.Function.identity()));
    }

    private @NonNull SortedSet<@NonNull BaseFunction> getFunctions() {
        return Arrays.stream(javaClass.getDeclaredMethods())
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .map(method -> {
                    final var parameters = Arrays.stream(method.getParameters())
                            .map(p ->
                                    new Parameter(p.getName(), TypeResolver.resolveType(p.getParameterizedType())))
                            .toList();

                    final var name = method.getName();
                    final var mod = method.getModifiers();
                    return new Function(this,
                            name,
                            visibilityFromModifiers(mod),
                            Modifier.isStatic(mod),
                            Modifier.isAbstract(mod),
                            Modifier.isFinal(mod),
                            TypeResolver.resolveType(method.getGenericReturnType()),
                            parameters);
                }).collect(Collectors.toCollection(TreeSet::new));
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

    private static class Parents {
        private final @NonNull SequencedCollection<@NonNull Type> genericSuperKlasses = new ArrayList<>();
        private final @NonNull SequencedCollection<@NonNull Type> genericSuperInterfaces = new TreeSet<>();
    }
}
