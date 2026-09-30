/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast.element;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.AbstractAst;

import java.util.Locale;
import java.util.Objects;

public final class ElementModifier extends AbstractAst implements Element {
    public final @NonNull ModifierType type;
    public final @NonNull String modifier;

    public ElementModifier(final @NonNull ModifierType type, final @NonNull String modifier) {
        this.type = Objects.requireNonNull(type);
        this.modifier = Objects.requireNonNull(modifier);
    }

    @Override
    public @NonNull String description() {
        return "ElementModifier(" + modifier + " [" + type.name().toLowerCase(Locale.US) + "Modifier])";
    }

    public enum ModifierType {
        CLASS,
        INHERITANCE,
        MEMBER,
        PARAMETER,
        VISIBILITY,
    }
}
