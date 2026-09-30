/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.compiler;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.expression.RealExpression;

import java.lang.constant.ConstantDesc;
import java.lang.constant.DirectMethodHandleDesc;
import java.util.ArrayList;
import java.util.List;

import static org.oolang.ast.expression.JvmInvocationUtils.INVOKE_DYNAMIC;
import static org.oolang.ast.expression.RealExpression.ExpressionType.FUN_CALL;

final class InvokeDynamicExpression extends RealExpression {
    final @NonNull DirectMethodHandleDesc bootstrapMethod;
    final @NonNull List<@NonNull ConstantDesc> bootstrapArgs = new ArrayList<>();

    InvokeDynamicExpression(final @NonNull DirectMethodHandleDesc bootstrapMethod) {
        assert bootstrapMethod != null;
        super(FUN_CALL);

        this.invocation = INVOKE_DYNAMIC;
        this.bootstrapMethod = bootstrapMethod;
    }
}
