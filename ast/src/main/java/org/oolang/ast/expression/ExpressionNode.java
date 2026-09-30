/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.expression;

import org.oolang.ast.AstNode;

public sealed interface ExpressionNode extends Expression, AstNode permits RealExpression {
}
