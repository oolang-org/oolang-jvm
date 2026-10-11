/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.expression;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AbstractAst;
import org.oolang.ast.Annotation;
import org.oolang.ast.Ast;
import org.oolang.ast.AstType;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.oolang.ast.Identifier.SimpleIdentifier;

public non-sealed class RealExpression extends AbstractAst implements Expression.Node {
    public /* lateinit */ ExpressionType expressionType;
    public final @NonNull List<@NonNull SimpleIdentifier> identifiers = new ArrayList<>();
    public @Nullable AstType type = null;
    public @Nullable List<@NonNull Annotation> annotations = null;
    public @Nullable RealExpression parent = null;
    public final @NonNull List<@NonNull Expression> children = new ArrayList<>();

    // set during semantic analysis phase.
    public @Nullable String invocation; // getstatic / invokevirtual / invokedynamic etc.
    public @Nullable String ownerDescriptorString;
    public @Nullable String typeDescriptorString;
    private @Nullable String descriptorString;

    public RealExpression() {
    }

    public RealExpression(final @NonNull ExpressionType expressionType) {
        assert expressionType != null;
        this.expressionType = expressionType;
    }

    @Override
    public @NonNull String description() {
        final var sb = new StringBuilder();
        sb.append("Expression(");
        sb.append(expressionType.name().toLowerCase(Locale.US));
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

    /// Replace all properties of this expression with those of the other expression.
    public void replaceWith(final @NonNull RealExpression other) {
        assert other != null;

        this.expressionType = other.expressionType;
        this.identifiers.clear();
        this.identifiers.addAll(other.identifiers);
        this.type = other.type;
        this.annotations = other.annotations;
        // we do not copy parent, keeping the current one, if any
        this.children.clear();
        this.children.addAll(other.children);

        this.invocation = other.invocation;
        this.ownerDescriptorString = other.ownerDescriptorString;
        this.typeDescriptorString = other.typeDescriptorString;
        this.descriptorString = other.descriptorString;
    }

    public enum ExpressionType {
        /// Semantic analysis will replace this undetermined type with either a
        /// - **property access** = a [RealExpression] with a [#PROP_ACCESS] type.
        /// - **variable access** = a [LoadExpression].
        VARIABLE_OR_PROP_ACCESS,
        CHAINABLE,
        PROP_ACCESS,
        PROP_ASSIGNMENT,
        FUN_CALL,
        FUN_CALL_PARAMETER,
        NEW,
        ADD,
        SUB,
        INDEXING
    }
}
