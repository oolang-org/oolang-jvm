/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.element;

import org.oolang.ast.Ast;

public sealed interface Element extends Ast permits ElementModifier, Element.Node {
    sealed interface Node extends Element, Ast.Node permits ClassBody, RealElement {
    }
}
