/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.expression;

import org.jspecify.annotations.NonNull;

import static org.oolang.ast.expression.RealExpression.ExpressionType.CHAINABLE;

public final class ExpressionUtils {
    // un-instantiable
    private ExpressionUtils() {
    }

    public static void addExpressionToChain(final @NonNull RealExpression chainableExpression,
                                            final @NonNull Expression childExpression) {
        assert chainableExpression != null;
        assert chainableExpression.expressionType == CHAINABLE;
        assert childExpression != null;

        if (childExpression instanceof RealExpression childRealExpression) {
            childRealExpression.parent = chainableExpression;
        }
        chainableExpression.children.add(childExpression);
    }
}
