/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.semantic.analyzer;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.expression.DelegateExpression;
import org.oolang.ast.expression.Expression;
import org.oolang.symbol.table.ActualType;

public final class AlreadyVisitedExpression extends DelegateExpression {
    final @NonNull ActualType type;

    AlreadyVisitedExpression(final @NonNull Expression delegate, final @NonNull ActualType type) {
        super(delegate);
        assert type != null;

        this.type = type;
    }
}
