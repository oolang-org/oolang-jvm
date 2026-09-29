/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.element;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AbstractAst;
import org.oolang.ast.Annotation;
import org.oolang.ast.Ast;
import org.oolang.ast.AstType;

import java.lang.invoke.TypeDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static org.oolang.ast.Identifier.SimpleIdentifier;

public final class RealElement extends AbstractAst implements ElementNode, TypeDescriptor {
    public final @NonNull ElementType elementType;
    public @Nullable SimpleIdentifier identifier = null;
    public @Nullable AstType type = null;
    public @Nullable List<@NonNull Annotation> annotations = null;
    public @NonNull List<@NonNull ElementModifier> modifiers = new ArrayList<>();
    public @NonNull List<@NonNull Ast> children = new ArrayList<>();

    // can be set during semantic analysis phase.
    private @Nullable String descriptorString = null;

    public RealElement(final @NonNull ElementType elementType) {
        this.elementType = Objects.requireNonNull(elementType);
    }

    @Override
    public @NonNull String description() {
        final var sb = new StringBuilder();
        sb.append("Element(");
        sb.append(elementType.name().toLowerCase(Locale.US));
        if (identifier != null) {
            sb.append(" ").append(identifier.identifier);
        }
        if (type != null) {
            sb.append(":").append(type.rawName());
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
        content.addAll(modifiers);
        content.addAll(children);
        return content;
    }

    @Override
    public @Nullable String descriptorString() {
        if (descriptorString != null) {
            return descriptorString;
        }
        if (type != null) {
            return type.descriptorString;
        }
        return null;
    }

    public void setDescriptorString(@Nullable String descriptorString) {
        this.descriptorString = descriptorString;
    }

    public enum ElementType {
        CLASS,
        INTERFACE,
        CONSTRUCTOR,
        PARAMETER,
        FUN,
        // property elements
        VAR, VAL, PROPERTY_INITIALIZER, PROPERTY_GETTER, PROPERTY_SETTER
    }
}
