/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;

record BaseSymbol(@NonNull String name,
                  @NonNull Visibility visibility,
                  boolean isStatic,
                  boolean isAbstract,
                  boolean isFinal) {
}
