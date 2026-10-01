/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.semantic.analyzer;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.symbol.table.BaseSymbol.Property;
import org.oolang.symbol.table.Type;
import org.oolang.symbol.table.Variable;
import org.oolang.symbol.table.Variable.SimpleVariable;

import java.util.HashMap;
import java.util.Map;

import static org.oolang.symbol.table.TypeResolver.DOUBLE_KLASS;
import static org.oolang.symbol.table.TypeResolver.LONG_KLASS;

final class Scopes {
    private @NonNull Scope currentStatic;
    private @NonNull Scope currentInstance;

    Scopes() {
        this(new Scope(0));
    }

    private Scopes(final @NonNull Scope currentStatic) {
        this.currentStatic = currentStatic;
        this.currentInstance = new Scope(1); // keep the 0 index for 'this'
    }

    @NonNull Scopes enterStatic() {
        return new Scopes(currentStatic);
    }

    void push(final boolean isStatic, final boolean isClass) {
        if (isStatic) {
            final var newStaticHead = new Scope(0);
            newStaticHead.previous = currentStatic;
            currentStatic = newStaticHead;
        } else {
            final var newSlot = (isClass) ? currentInstance.slot + 1 : currentInstance.slot;
            final var newInstanceHead = new Scope(newSlot);
            newInstanceHead.previous = currentInstance;
            currentInstance = newInstanceHead;
        }
    }

    void pop(final boolean isStatic) {
        if (isStatic) {
            final var currentStaticHead = currentStatic;
            assert currentStaticHead.previous != null;
            currentStatic = currentStaticHead.previous;
            currentStaticHead.previous = null; // release this reference for GC
        } else {
            final var currentInstanceHead = currentInstance;
            assert currentInstanceHead.previous != null;
            currentInstance = currentInstanceHead.previous;
            currentInstanceHead.previous = null; // release this reference for GC
        }
    }

    void putProperty(final @NonNull Property property) {
        assert property != null;

        if (property.isStatic) {
            currentStatic.putProperty(property);
        } else {
            currentInstance.putProperty(property);
        }
    }

    void putVariable(final @NonNull String name,
                     final @NonNull Type type,
                     final boolean isFinal,
                     final boolean isStatic) {
        assert name != null;
        assert type != null;

        if (isStatic) {
            currentStatic.putVariable(name, type, isFinal);
        } else {
            currentInstance.putVariable(name, type, isFinal);
        }
    }

    @Nullable Variable resolveVariable(final @NonNull String name) {
        assert name != null;

        var variable = resolveVariable(name, currentInstance);
        if (variable == null) {
            variable = resolveVariable(name, currentStatic);
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
        private final @NonNull Map<@NonNull String, @NonNull Variable> variables = new HashMap<>();
        private int slot;

        private Scope(final int slot) {
            this.slot = slot;
        }

        private void putProperty(final @NonNull Property property) {
            assert property != null;

            variables.put(property.name, property);
        }

        private void putVariable(final @NonNull String name,
                                 final @NonNull Type type,
                                 final boolean isFinal) {
            assert name != null;
            assert type != null;

            variables.put(name, new SimpleVariable(type, isFinal, slot));
            slot += (type == LONG_KLASS || type == DOUBLE_KLASS) ? 2 : 1;
        }

        private @Nullable Scope previous = null;
    }
}
