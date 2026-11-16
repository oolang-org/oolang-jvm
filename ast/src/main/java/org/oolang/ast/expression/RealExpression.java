/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.expression;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AbstractAst;
import org.oolang.ast.Annotation;
import org.oolang.ast.Ast;
import org.oolang.ast.RealAstType;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.oolang.ast.Identifier.SimpleIdentifier;

public non-sealed class RealExpression extends AbstractAst implements Expression.Node {
    public /* lateinit */ ExpressionType expressionType;
    public final @NonNull List<@NonNull SimpleIdentifier> identifiers = new ArrayList<>();
    public @Nullable RealAstType type = null;
    public int slot = -1;
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

    public void descriptorString(final @NonNull String descriptorString) {
        assert descriptorString != null;
        this.descriptorString = descriptorString;
    }

    /// Replace all properties of this expression with those of the other expression.
    public void replaceWith(final @NonNull RealExpression other) {
        assert other != null;

        this.expressionType = other.expressionType;
        this.identifiers.clear();
        this.identifiers.addAll(other.identifiers);
        this.slot = other.slot;
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
        /// A variable or property access from the parser phase that must be wrapped in a [#CHAINABLE] expression.
        /// Semantic analysis will replace this undetermined type with either a
        /// - **property access** = a [#PROP_ACCESS] expression.
        /// - **variable access** = a [#LOAD] expression.
        VARIABLE_OR_PROP_ACCESS,
        PROP_ACCESS,

        /// A variable or property assignment from the parser phase that must be wrapped in a [#CHAINABLE] expression.
        /// Semantic analysis will replace this undetermined type with either a
        /// - **property assignment** = a [RealExpression] with a [#PROP_ASSIGNMENT] type.
        /// - **variable assignment** = a [RealExpression] with a [#VARIABLE_STORE] type.
        VARIABLE_OR_PROP_ASSIGNMENT,
        PROP_ASSIGNMENT,
        /// An expression that store a value into a local variable. It is set during the semantic analysis phase, and
        /// need a [slot][RealExpression#slot] number.
        VARIABLE_STORE,

        /// An expression that loads a value from a variable or a field into the operand stack.
        /// It is set during the semantic analysis phase, and need a [slot][RealExpression#slot] number.
        LOAD,

        /// A function call expression that may have some [parameters][#FUN_CALL_PARAMETER].
        /// It must be wrapped in a [#CHAINABLE] expression.
        ///
        /// Note: a constructor invocation is a function call.
        FUN_CALL,
        FUN_CALL_PARAMETER,

        NEW,
        ADD,
        SUB,
        INDEXING,

        /// A "virtual" expression for composed expressions. For example `this.aProperty` will resolve to 2 expressions
        /// in the semantic analysis phase : [load(this)][#LOAD] and [prop aProperty][#PROP_ACCESS].
        CHAINABLE,
    }
}
