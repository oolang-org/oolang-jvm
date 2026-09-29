/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class Annotation extends AbstractAst implements AstNode {
    public final @NonNull AstType type;
    public @Nullable UseSiteTarget useSiteTarget;

    public Annotation(final @NonNull AstType type) {
        this.type = Objects.requireNonNull(type);
    }

    @Override
    public @NonNull String description() {
        final var sb = new StringBuilder();
        sb.append("Annotation(");
        if (useSiteTarget != null) {
            sb.append(useSiteTarget.name().toLowerCase(Locale.US)).append(":");
        }
        sb.append(type.rawName()).append(")");
        return sb.toString();
    }

    @Override
    public @NonNull List<@NonNull Ast> content() {
        return List.of();
    }

    public enum UseSiteTarget {
        GET,
        SET,
        PARAM,
    }
}
