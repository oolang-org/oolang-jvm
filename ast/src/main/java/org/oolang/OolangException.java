/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang;

import org.jspecify.annotations.NonNull;

import java.util.Objects;

/**
 * The parent class of all Oolang compilation exceptions.
 */
public abstract class OolangException extends RuntimeException {
    public OolangException(final @NonNull String message) {
        super(Objects.requireNonNull(message));
    }
}
