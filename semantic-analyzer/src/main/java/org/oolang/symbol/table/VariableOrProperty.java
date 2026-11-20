/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

public sealed interface VariableOrProperty extends ScopeElement permits Property, Variable {
}
