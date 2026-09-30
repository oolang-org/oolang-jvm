/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static org.oolang.ast.Identifier.SimpleIdentifier;
import static org.oolang.ast.Identifier.identifierName;

public final class Import extends AbstractAst implements Ast {
    public final @NonNull List<@NonNull SimpleIdentifier> identifiers = new ArrayList<>();
    public @Nullable SimpleIdentifier alias = null;

    public @NonNull String raw() {
        final var sb = new StringBuilder();
        identifierName(identifiers, sb);
        return sb.toString();
    }

    @Override
    public @NonNull String description() {
        return "Import(" + raw() + ((alias != null) ? " as " + alias.rawName() : "") + ")";
    }
}
