/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang;

import org.jspecify.annotations.NonNull;

import java.lang.classfile.*;

/// A Oolang metadata [CustomAttribute] that indicates that a method is a property (either a getter or a setter).
public final class OolangPropCustomAttribute extends CustomAttribute<OolangPropCustomAttribute> {
    public static final @NonNull String NAME = "oolang-prop";
    public static final @NonNull AttributeMapper<@NonNull OolangPropCustomAttribute> MAPPER = new AttributeMapper<>() {
        @Override
        public @NonNull String name() {
            return NAME;
        }

        @Override
        public @NonNull OolangPropCustomAttribute readAttribute(final @NonNull AttributedElement enclosing,
                                                                final @NonNull ClassReader reader,
                                                                final int offset) {
            return new OolangPropCustomAttribute();
        }

        @Override
        public void writeAttribute(final @NonNull BufWriter writer, final @NonNull OolangPropCustomAttribute attr) {
            assert writer != null;

            // The mapper is responsible for writing the whole attribute structure:
            // u2 attribute_name_index, u4 attribute_length, then u1 info[attribute_length] = nothing in our case.
            writer.writeIndex(writer.constantPool().utf8Entry(NAME));
            writer.writeInt(0);
        }

        @Override
        public @NonNull AttributeStability stability() {
            return AttributeStability.STATELESS;
        }
    };

    public OolangPropCustomAttribute() {
        super(MAPPER);
    }
}
