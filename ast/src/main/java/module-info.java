/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

module oolang.ast {
    requires transitive oolang.base;

    requires static org.jspecify;

    exports org.oolang.ast;
    exports org.oolang.ast.element;
    exports org.oolang.ast.expression;
    exports org.oolang.ast.statement;
}
