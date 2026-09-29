/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.element.RealElement;

import java.util.ArrayList;
import java.util.List;

public final class AstFile extends AbstractAst implements AstNode {
    public /* lateinit */ PackageHeader packageHeader;
    public final @NonNull List<@NonNull Import> imports = new ArrayList<>();
    public final @NonNull List<@NonNull RealElement> rootElements = new ArrayList<>();

    @Override
    public @NonNull String description() {
        final var sb = new StringBuilder();
        new AstFileWriter(this).write(sb, false);
        return sb.toString();
    }

    @Override
    public @NonNull List<? extends @NonNull Ast> content() {
        final var content = new ArrayList<@NonNull Ast>();
        content.add(packageHeader);
        content.addAll(imports);
        content.addAll(rootElements);
        return content;
    }
}
