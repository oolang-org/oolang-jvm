/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.compiler;

import org.jspecify.annotations.NonNull;

final class Descriptors {
    // un-instantiable
    private Descriptors() {
    }

    // primitive types
    static final @NonNull String INTEGER = "I";
    static final @NonNull String LONG = "J";
    static final @NonNull String FLOAT = "F";
    static final @NonNull String DOUBLE = "D";
    static final @NonNull String BOOLEAN = "Z";
    static final @NonNull String VOID = "V";


    static final @NonNull String STRING = "Ljava/lang/String;";
    static final @NonNull String OBJECT = "Ljava/lang/Object;";
}
