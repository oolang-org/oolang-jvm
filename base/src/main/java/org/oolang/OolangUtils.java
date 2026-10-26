/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang;

import org.jspecify.annotations.NonNull;

import java.nio.charset.StandardCharsets;

public final class OolangUtils {
    // un-instantiable
    private OolangUtils() {
    }

    private static final @NonNull String LANGUAGE_VERSION = "0.1.0";
    public static final byte @NonNull [] OOLANG_COMPILER_METADATA =
            ("compiler: Oolang " + LANGUAGE_VERSION).getBytes(StandardCharsets.UTF_8);
}
