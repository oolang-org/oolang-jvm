/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AstType;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public sealed interface Type permits ActualType, Type.Lazy, Type.Lateinit {
    @SuppressWarnings("preview")
    final class Lazy implements Type {
        private final @NonNull LazyConstant<@NonNull ActualType> lazyType;

        Lazy(final @Nullable AstType astType, final @NonNull OolangKlass oolangKlass) {
            assert oolangKlass != null;

            lazyType = LazyConstant.of(() -> {
                final var type = TypeResolver.resolveType(astType, oolangKlass, false);

                // type resolution, the compiler will use that descriptor string
                if (astType != null) {
                    astType.descriptorString = TypeResolver.getKlassFromType(type).descriptorString();
                }

                return type;
            });
        }

        @NonNull ActualType type() {
            return lazyType.get();
        }
    }

    final class Lateinit implements Type {
        private /* lateinit */ ActualType type = null;

        private final @NonNull Lock lock = new ReentrantLock();
        private final @NonNull Condition condition = lock.newCondition();

        public @NonNull ActualType type() {
            lock.lock();
            try {
                if (type == null) {
                    condition.await();
                }
                assert type != null;
                return type;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }

        public void setType(final @NonNull ActualType type) {
            assert type != null;
            assert this.type == null;

            lock.lock();
            try {
                this.type = type;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
