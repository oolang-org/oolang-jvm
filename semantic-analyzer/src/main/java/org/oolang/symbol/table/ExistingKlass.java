/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.symbol.table.Function.Parameter;

import java.lang.constant.ConstantDescs;
import java.lang.reflect.Executable;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

import static org.oolang.symbol.table.FunctionPropertyUtils.*;


@SuppressWarnings("preview")
final class ExistingKlass extends Klass {
    private final @NonNull Class<?> javaClass;
    private final @NonNull LazyConstant<@NonNull Map<@NonNull String, @NonNull Property>> properties =
            LazyConstant.of(this::getProperties);
    private final @NonNull LazyConstant<@NonNull Functions> functions =
            LazyConstant.of(this::getFunctions);

    ExistingKlass(final @NonNull Class<?> javaClass) {
        assert javaClass != null;

        this.javaClass = javaClass;
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
    @Nullable ActualType superKlass() {
        final var javaSuperType = javaClass.getGenericSuperclass();
        return (javaSuperType != null) ? TypeResolver.resolveType(javaSuperType) : null;
    }

    @Override
    @NonNull List<@NonNull ActualType> interfaces() {
        return Arrays.stream(javaClass.getGenericInterfaces())
                .map(TypeResolver::resolveType)
                .toList();
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
        // 2) add function properties, see `FunctionPropertyUtils`
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
        //1) add functions
        final var functions = addFunctions(maybeProperties);
        // 2) add constructors
        addConstructors(functions);

        return new Functions(
                functions,
                propertyCandidatesFromMaybeProperties(maybeProperties));
    }

    private @NonNull SortedSet<@NonNull BaseFunction> addFunctions(
            final @NonNull Map<@NonNull String, @NonNull MaybeProperty> maybeProperties
    ) {
        assert maybeProperties != null;

        return Arrays.stream(javaClass.getDeclaredMethods())
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .map(method -> {
                    final var function = buildFunction(method, method.getName(),
                            TypeResolver.resolveType(method.getGenericReturnType()));
                    // this function may be a property candidate
                    addToMaybePropertiesIfEligible(function, maybeProperties);
                    return function;
                }).collect(Collectors.toCollection(TreeSet::new));
    }

    private void addConstructors(final @NonNull Collection<@NonNull BaseFunction> functions) {
        assert functions != null;

        Arrays.stream(javaClass.getConstructors())
                .filter(constructor -> !Modifier.isPrivate(constructor.getModifiers()))
                .forEach(constructor ->
                        functions.add(buildFunction(constructor, ConstantDescs.INIT_NAME, this)));
    }

    private Function buildFunction(final @NonNull Executable methodOrConstructor,
                                   final @NonNull String functionName,
                                   final @NonNull ActualType returnType) {
        assert methodOrConstructor != null;
        assert functionName != null;
        assert returnType != null;

        final var parameters = Arrays.stream(methodOrConstructor.getParameters())
                .map(p -> {
                    final var paramName = p.isNamePresent() ? p.getName() : null;
                    return new Parameter(paramName, TypeResolver.resolveType(p.getParameterizedType()));
                }).toList();

        final var mod = methodOrConstructor.getModifiers();
        return new Function(this,
                functionName,
                visibilityFromModifiers(mod),
                Modifier.isStatic(mod),
                Modifier.isAbstract(mod),
                Modifier.isFinal(mod),
                returnType,
                parameters);
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

    private record Functions(
            @NonNull SortedSet<@NonNull BaseFunction> functions,
            @NonNull PropertyCandidates propertyCandidates) {
    }
}
