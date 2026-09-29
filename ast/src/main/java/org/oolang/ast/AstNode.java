/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast;

import org.jspecify.annotations.NonNull;

import java.util.List;

public interface AstNode extends Ast {
    @NonNull List<? extends @NonNull Ast> content();
}
