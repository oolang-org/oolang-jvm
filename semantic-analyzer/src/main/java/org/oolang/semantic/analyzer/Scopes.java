/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.semantic.analyzer;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.symbol.table.*;
import org.oolang.symbol.table.BaseFunction.SimpleFunction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import static org.oolang.symbol.table.FunctionUtils.compatibleParameters;
import static org.oolang.symbol.table.TypeResolver.DOUBLE_PRIMITIVE_KLASS;
import static org.oolang.symbol.table.TypeResolver.LONG_PRIMITIVE_KLASS;
import static org.oolang.symbol.table.Visibility.HIDDEN;

final class Scopes {
    private /* lateinit */ Scope currentStaticScope = null;
    private /* lateinit */ Scope currentInstanceScope = null;

    @NonNull Scopes enterStatic() {
        final var newScopes = new Scopes();
        newScopes.currentStaticScope = currentStaticScope;
        newScopes.currentInstanceScope = new Scope(null);
        return newScopes;
    }

    void pushKlass(final @NonNull OolangKlass oolangKlass) {
        assert oolangKlass != null;

        currentStaticScope = new Scope(currentStaticScope, oolangKlass.properties().staticProperties,
                oolangKlass.functions().staticFunctions);
        currentInstanceScope = new Scope(currentInstanceScope, oolangKlass.properties().instanceProperties,
                oolangKlass.functions().instanceFunctions);

        if (!oolangKlass.isInterface()) {
            currentInstanceScope.putVariable("this", oolangKlass, /* isFinal */ true);
        }
    }

    void popKlass() {
        currentStaticScope = currentStaticScope.previous;
        currentInstanceScope = currentInstanceScope.previous;
    }

    void pushFunction(final boolean isStatic) {
        if (isStatic) {
            currentStaticScope = new Scope(currentStaticScope);
        } else {
            currentInstanceScope = new Scope(currentInstanceScope);
        }
    }

    void popFunction(final boolean isStatic) {
        if (isStatic) {
            currentStaticScope = currentStaticScope.previous;
        } else {
            currentInstanceScope = currentInstanceScope.previous;
        }
    }

    int putVariable(final @NonNull String name,
                    final @NonNull ActualType type,
                    final boolean isFinal,
                    final boolean isStatic,
                    final boolean noDuplicate) {
        assert name != null;
        assert type != null;

        if (noDuplicate && resolveVariableOrProperty(name, false) != null) {
            throw new OolangSemanticException(
                    "There is already a variable or property in the scope with the same name: " + name);
        }

        return (isStatic)
                ? currentStaticScope.putVariable(name, type, isFinal)
                : currentInstanceScope.putVariable(name, type, isFinal);
    }

    @Nullable ScopeElement resolveVariableOrProperty(final @NonNull String name, final boolean isMutable) {
        assert name != null;

        var variable = resolveVariableOrProperty(name, isMutable, currentInstanceScope);
        if (variable == null) {
            variable = resolveVariableOrProperty(name, isMutable, currentStaticScope);
        }
        return variable;
    }

    private static @Nullable ScopeElement resolveVariableOrProperty(final @NonNull String name,
                                                                    final boolean isMutable,
                                                                    final @NonNull Scope current) {
        assert name != null;
        assert current != null;

        Scope scope = current;
        while (scope != null) {
            final var variable = scope.varsAndProps.get(name);
            if (variable != null) {
                final var scopeElement = accessibleVariableOrProperty(variable, isMutable);
                if (scopeElement != null) {
                    return scopeElement;
                }
            }
            scope = scope.previous;
        }
        return null;
    }

    private static @Nullable ScopeElement accessibleVariableOrProperty(
            final @NonNull VariableOrProperty variableOrProperty,
            final boolean isMutable
    ) {
        assert variableOrProperty != null;

        if (isMutable && variableOrProperty.isFinal()) {
            return null;
        }

        return switch (variableOrProperty) {
            case Variable var -> var;
            case Property prop -> {
                // 1) property can be an accessible field
                if (prop.visibility() != HIDDEN) {
                    yield prop;
                }
                // 2) property can be a function property
                yield isMutable ? prop.setter : prop.getter;
            }
        };
    }

    @Nullable Function resolveFunction(final @NonNull String name,
                                       final @NonNull List<@NonNull ActualType> parameterTypes) {
        assert name != null;
        assert parameterTypes != null;

        var function = resolveFunction(name, parameterTypes, currentInstanceScope);
        if (function == null) {
            function = resolveFunction(name, parameterTypes, currentStaticScope);
        }
        return function;
    }

    private static @Nullable Function resolveFunction(final @NonNull String name,
                                                      final @NonNull List<@NonNull ActualType> parameterTypes,
                                                      final @NonNull Scope current) {
        assert name != null;
        assert parameterTypes != null;
        assert current != null;

        // search limits = funName / funName0. There may be several functions with the same name.
        final var searchFunctionFrom = new SimpleFunction(name);
        final var searchFunctionTo = new SimpleFunction(name + "0");

        Scope scope = current;
        while (scope != null) {
            if (scope.functions == null) {
                continue;
            }
            final var candidateFunctions = scope.functions.subSet(searchFunctionFrom, searchFunctionTo);
            for (final var candidateBaseFunction : candidateFunctions) {
                final var candidateFunction = (Function) candidateBaseFunction;
                if (compatibleParameters(candidateFunction, parameterTypes)) {
                    return candidateFunction;
                }
            }
            scope = scope.previous;
        }
        return null;
    }

    static final class Scope {
        private int slot;
        private final @Nullable Scope previous;

        private final @NonNull Map<@NonNull String, @NonNull VariableOrProperty> varsAndProps;
        private final @Nullable SortedSet<@NonNull BaseFunction> functions;

        private Scope(final @Nullable Scope previous) {
            this(previous, null, null);
        }

        private Scope(final @Nullable Scope previous,
                      final @Nullable Map<@NonNull String, @NonNull Property> properties,
                      final @Nullable SortedSet<@NonNull BaseFunction> functions) {
            this.slot = (previous != null) ? previous.slot : 0;
            this.previous = previous;
            this.varsAndProps = (properties != null) ? new HashMap<>(properties) : new HashMap<>();
            this.functions = functions;
        }

        private int putVariable(final @NonNull String name,
                                final @NonNull ActualType type,
                                final boolean isFinal) {
            assert name != null;
            assert type != null;

            final var variableSlot = slot;
            varsAndProps.put(name, new Variable(type, isFinal, variableSlot));
            slot += (type == LONG_PRIMITIVE_KLASS || type == DOUBLE_PRIMITIVE_KLASS) ? 2 : 1;
            return variableSlot;
        }
    }
}
