/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.semantic.analyzer;

import org.oolang.symbol.table.BaseSymbol.Property;
import org.oolang.symbol.table.Type;
import org.oolang.symbol.table.Variable;
import org.oolang.symbol.table.Variable.SimpleVariable;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

import static org.oolang.symbol.table.TypeResolver.DOUBLE_KLASS;
import static org.oolang.symbol.table.TypeResolver.LONG_KLASS;

final class Scopes {
    @NonNull Scope current = new Scope();

    @NonNull Scopes newScopes() {
        return new Scopes();
    }

    void push() {
        final var newHead = new Scope();
        newHead.previous = current;
        current = newHead;
    }

    void pop() {
        final var currentHead = current;
        assert currentHead.previous != null;
        current = currentHead.previous;
        currentHead.previous = null; // release this reference for GC
    }

    @Nullable Variable resolveVariable(final @NonNull String name) {
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
        private int slot = 0;

        void putProperty(final @NonNull Property property) {
            assert property != null;

            variables.put(property.name, property);
        }

        void putVariable(final @NonNull String name,
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
