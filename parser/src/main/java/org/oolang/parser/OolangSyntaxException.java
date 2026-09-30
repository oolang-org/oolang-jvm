/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.parser;

import org.jspecify.annotations.NonNull;
import org.oolang.OolangException;

public class OolangSyntaxException extends OolangException {
    public OolangSyntaxException(final @NonNull String message) {
        super(message);
    }
}
