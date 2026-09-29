/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.statement;

import org.oolang.ast.AstNode;

public sealed interface StatementNode extends Statement, AstNode permits CodeBlock, ConstructorBody, RealStatement {
}
