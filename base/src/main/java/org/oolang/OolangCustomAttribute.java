/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.lang.classfile.*;
import java.util.Objects;

import static java.nio.charset.StandardCharsets.US_ASCII;

/// A Oolang metadata [CustomAttribute] that holds a name and an optional value encoded as plain ASCII strings.
public final class OolangCustomAttribute extends CustomAttribute<OolangCustomAttribute> {
    public static final @NonNull String NAME = "OolangCustomAttribute";
    private static final byte @NonNull [] EMPTY = new byte[0];

    private final @NonNull String name;
    private final @Nullable String value;


    public OolangCustomAttribute(final @NonNull String attributeName, final @Nullable String attributeValue) {
        Objects.requireNonNull(attributeName);

        this.name = attributeName;
        this.value = attributeValue;

        final var mapper = new AttributeMapper<OolangCustomAttribute>() {
            @Override
            public String name() {
                return NAME;
            }

            @Override
            public OolangCustomAttribute readAttribute(AttributedElement enclosing, ClassReader reader, int offset) {
                // `offset` points to the attribute contents(info): name, value, u4 name_length.
                // The u4 attribute_length is just before it.
                final var nameAndValueLength = reader.readInt(offset - 4) - 4;
                final var nameLength = reader.readInt(offset + nameAndValueLength);
                final var name = new String(reader.readBytes(offset, nameLength), US_ASCII);
                final var valueLength = nameAndValueLength - nameLength;
                final var value = (valueLength == 0)
                        ? null
                        : new String(reader.readBytes(offset + nameLength, valueLength), US_ASCII);
                return new OolangCustomAttribute(name, value);
            }

            @Override
            public void writeAttribute(BufWriter writer, OolangCustomAttribute attr) {
                final var nameContent = attr.name.getBytes(US_ASCII);
                final var valueContent = (attr.value == null) ? EMPTY : attr.value.getBytes(US_ASCII);

                // The mapper is responsible for writing the whole attribute structure:
                // u2 attribute_name_index, u4 attribute_length, then u1 info[attribute_length].
                writer.writeIndex(writer.constantPool().utf8Entry(NAME));
                // attribute_length must cover the whole info: both contents + u4 name length.
                writer.writeInt(nameContent.length + valueContent.length + 4);
                writer.writeBytes(nameContent);
                writer.writeBytes(valueContent);
                writer.writeInt(nameContent.length);
            }

            @Override
            public AttributeStability stability() {
                // STATELESS means this attribute contains pure, self-contained data that doesn't hold indices
                // to the outer class Constant Pool.
                return AttributeStability.STATELESS;
            }
        };

        super(mapper);
    }

    public @NonNull String name() {
        return name;
    }

    public @Nullable String value() {
        return value;
    }
}
