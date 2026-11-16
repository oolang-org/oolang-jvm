/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.semantic.analyzer;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.symbol.table.*;
import org.oolang.symbol.table.Variable.SimpleVariable;

import java.util.HashMap;
import java.util.Map;

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

    void pushKlass(final @NonNull OolangKlass klass) {
        assert klass != null;

        currentStaticScope = new Scope(currentStaticScope);
        currentInstanceScope = new Scope(currentInstanceScope);

        if (!klass.isInterface()) {
            currentInstanceScope.putVariable("this", klass, true);
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

    void putProperty(final @NonNull Property property) {
        assert property != null;

        if (property.isStatic()) {
            currentStaticScope.putProperty(property);
        } else {
            currentInstanceScope.putProperty(property);
        }
    }

    int putVariable(final @NonNull String name,
                    final @NonNull ActualType type,
                    final boolean isFinal,
                    final boolean isStatic) {
        assert name != null;
        assert type != null;

        return (isStatic)
                ? currentStaticScope.putVariable(name, type, isFinal)
                : currentInstanceScope.putVariable(name, type, isFinal);
    }

    @Nullable ScopeElement resolveScopeElement(final @NonNull String name, final boolean setter) {
        assert name != null;

        var variable = resolveScopeElement(name, currentInstanceScope, setter);
        if (variable == null) {
            variable = resolveScopeElement(name, currentStaticScope, setter);
        }
        return variable;
    }

    private static @Nullable ScopeElement resolveScopeElement(final @NonNull String name,
                                                              final @NonNull Scope current,
                                                              final boolean setter) {
        assert name != null;
        assert current != null;

        Scope scope = current;
        while (scope != null) {
            final var variable = scope.variables.get(name);
            if (variable != null) {
                final var scopeElement = accessibleScopeElement(variable, setter);
                if (scopeElement != null) {
                    return scopeElement;
                }
            }
            scope = scope.previous;
        }
        return null;
    }

    private static @Nullable ScopeElement accessibleScopeElement(final @NonNull Variable variable,
                                                                 final boolean setter) {
        assert variable != null;

        if (setter && variable.isFinal()) {
            return null;
        }

        return switch (variable) {
            case SimpleVariable var -> var;
            case Property prop -> {
                // 1) property can be an accessible field
                if (prop.visibility != HIDDEN) {
                    yield prop;
                }
                // 2) property can be a function property
                yield setter ? prop.setter : prop.getter;
            }
        };
    }

    static final class Scope {
        private int slot;
        private final @Nullable Scope previous;

        private final @NonNull Map<@NonNull String, @NonNull Variable> variables = new HashMap<>();

        private Scope(final @Nullable Scope previous) {
            this.slot = (previous != null) ? previous.slot : 0;
            this.previous = previous;
        }

        private void putProperty(final @NonNull Property property) {
            assert property != null;

            variables.put(property.name(), property);
        }

        private int putVariable(final @NonNull String name,
                                final @NonNull ActualType type,
                                final boolean isFinal) {
            assert name != null;
            assert type != null;

            final var variableSlot = slot;
            variables.put(name, new SimpleVariable(type, isFinal, variableSlot));
            slot += (type == LONG_PRIMITIVE_KLASS || type == DOUBLE_PRIMITIVE_KLASS) ? 2 : 1;
            return variableSlot;
        }
    }
}
