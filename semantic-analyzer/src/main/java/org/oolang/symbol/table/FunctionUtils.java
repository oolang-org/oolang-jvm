/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;

import java.util.List;

public final class FunctionUtils {
    // un-instantiable
    private FunctionUtils() {
    }

    public static boolean compatibleParameters(final @NonNull Function candidateFunction,
                                               final @NonNull List<@NonNull ActualType> parameterTypes) {
        assert candidateFunction != null;
        assert parameterTypes != null;

        // fail-fast if candidate function has wrong number of parameters
        if (candidateFunction.parameters.size() != parameterTypes.size()) {
            return false;
        }

        for (var i = 0; i < candidateFunction.parameters.size(); i++) {
            if (!candidateFunction.parameters.get(i).type().isAssignableFrom(parameterTypes.get(i))) {
                return false;
            }
        }
        return true;
    }
}
