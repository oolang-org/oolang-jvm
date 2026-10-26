/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.semantic.analyzer;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.symbol.table.ActualType;
import org.oolang.symbol.table.OolangKlass;
import org.oolang.symbol.table.Property;
import org.oolang.symbol.table.Variable;
import org.oolang.symbol.table.Variable.SimpleVariable;

import java.util.HashMap;
import java.util.Map;

import static org.oolang.symbol.table.TypeResolver.DOUBLE_PRIMITIVE_KLASS;
import static org.oolang.symbol.table.TypeResolver.LONG_PRIMITIVE_KLASS;

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

        if (property.isStatic) {
            currentStaticScope.putProperty(property);
        } else {
            currentInstanceScope.putProperty(property);
        }
    }

    void putVariable(final @NonNull String name,
                     final @NonNull ActualType type,
                     final boolean isFinal,
                     final boolean isStatic) {
        assert name != null;
        assert type != null;

        if (isStatic) {
            currentStaticScope.putVariable(name, type, isFinal);
        } else {
            currentInstanceScope.putVariable(name, type, isFinal);
        }
    }

    @Nullable Variable resolveVariable(final @NonNull String name) {
        assert name != null;

        var variable = resolveVariable(name, currentInstanceScope);
        if (variable == null) {
            variable = resolveVariable(name, currentStaticScope);
        }
        return variable;
    }

    private static @Nullable Variable resolveVariable(final @NonNull String name,
                                                      final @NonNull Scope current) {
        assert name != null;
        assert current != null;

        var scope = current;
        while (scope != null) {
            final var variable = scope.variables.get(name);
            if (variable != null) {
                return variable;
            }
            scope = scope.previous;
        }
        return null;
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

            variables.put(property.name, property);
        }

        private void putVariable(final @NonNull String name,
                                 final @NonNull ActualType type,
                                 final boolean isFinal) {
            assert name != null;
            assert type != null;

            variables.put(name, new SimpleVariable(type, isFinal, slot));
            slot += (type == LONG_PRIMITIVE_KLASS || type == DOUBLE_PRIMITIVE_KLASS) ? 2 : 1;
        }
    }
}
