/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;

import java.lang.invoke.TypeDescriptor;

public sealed interface ScopeElement extends TypeDescriptor permits PropertyOrFunction, Variable {
    @NonNull ActualType type();

    boolean isFinal();
}
