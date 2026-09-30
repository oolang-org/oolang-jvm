/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static org.oolang.ast.Identifier.*;

public final class AstType extends AbstractAst implements AstNode {
    public final @NonNull Identifier identifier;
    public final @Nullable List<@NonNull AstType> parameters;

    public @Nullable List<@NonNull Annotation> annotations = null;
    public boolean nullable = false;
    public final @NonNull List<@NonNull Ast> children = new ArrayList<>();

    // set during type resolution in the semantic analysis phase.
    public /* lateinit */ String descriptorString;

    public AstType(final @NonNull Identifier identifier, final @Nullable List<@NonNull AstType> parameters) {
        assert identifier != null;

        this.identifier = identifier;
        this.parameters = parameters;
    }

    public @NonNull String rawName() {
        final var sb = new StringBuilder();
        switch (identifier) {
            case SimpleIdentifier simpleId -> sb.append(simpleId.identifier);
            case MultipleIdentifier multipleId -> identifierName(multipleId.identifiers, sb);
        }
        if (parameters != null && !parameters.isEmpty()) {
            sb.append("<");
            for (var i = 0; i < parameters.size(); i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(parameters.get(i).rawName());
            }
            sb.append(">");
        }
        if (nullable) {
            sb.append("?");
        }
        return sb.toString();
    }

    @Override
    public @NonNull String description() {
        return "Type(" + rawName() + ")";
    }

    @Override
    public @NonNull List<@NonNull Ast> content() {
        final var content = new ArrayList<@NonNull Ast>();
        if (annotations != null) {
            content.addAll(annotations);
        }
        content.addAll(children);
        return content;
    }
}
