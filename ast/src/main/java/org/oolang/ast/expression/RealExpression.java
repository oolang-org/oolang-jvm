/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.expression;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AbstractAst;
import org.oolang.ast.Annotation;
import org.oolang.ast.Ast;

import java.util.ArrayList;
import java.util.List;

import static org.oolang.ast.Identifier.SimpleIdentifier;

public non-sealed class RealExpression extends AbstractAst implements ExpressionNode {
    public /* lateinit */ ExpressionType type;
    public final @NonNull List<@NonNull SimpleIdentifier> identifiers = new ArrayList<>();
    public @Nullable List<@NonNull Annotation> annotations = null;
    public final @NonNull List<@NonNull Expression> children = new ArrayList<>();

    // set during semantic analysis phase.
    public @Nullable String invocation; // getstatic / invokevirtual / invokedynamic etc.
    public @Nullable String ownerDescriptorString;
    public @Nullable String typeDescriptorString;
    private @Nullable String descriptorString;

    public RealExpression() {
    }

    public RealExpression(final @NonNull ExpressionType type) {
        assert type != null;
        this.type = type;
    }

    @Override
    public @NonNull String description() {
        final var sb = new StringBuilder();
        sb.append("Expression(");
        sb.append(type.label);
        if (!identifiers.isEmpty()) {
            sb.append(" ");
            for (var i = 0; i < identifiers.size(); i++) {
                if (i > 0) {
                    sb.append(".");
                }
                sb.append(identifiers.get(i).rawName());
            }
        }
        sb.append(")");
        return sb.toString();
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

    @Override
    public @Nullable String descriptorString() {
        return descriptorString;
    }

    public void setDescriptorString(final @NonNull String descriptorString) {
        assert descriptorString != null;
        this.descriptorString = descriptorString;
    }

    public enum ExpressionType {
        /**
         * Semantic analysis will enrich this type with a child. Either a {@link #PROP_ACCESS} typed
         * {@link RealExpression} for property or a {@link LoadExpression} for variable.
         */
        VARIABLE_OR_PROP_ACCESS("variableOrPropAccess"),

        PROP_ACCESS("propAccess"),
        FUN_CALL("funCall"),
        FUN_CALL_PARAMETER("funCallParameter"),
        STRING_LITERAL("stringLiteral"),
        ADD("add"),
        SUB("sub"),
        INDEXING("indexing");

        private final @NonNull String label;

        ExpressionType(final @NonNull String label) {
            assert label != null;
            this.label = label;
        }
    }
}
