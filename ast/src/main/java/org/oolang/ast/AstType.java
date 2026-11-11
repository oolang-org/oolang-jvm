/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.lang.invoke.TypeDescriptor;
import java.util.List;

public interface AstType extends Ast, TypeDescriptor {

    @Nullable List<@NonNull AstType> parameters();

    @Nullable List<@NonNull Annotation> annotations();

    @NonNull String rawName();

    @Override
    default @NonNull String description() {
        return "Type(" + rawName() + ")";
    }
}
