/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.ast;

import org.jspecify.annotations.NonNull;

public /* value */ record Position(
        int index,
        int line,
        int row
) implements Comparable<@NonNull Position> {

    @Override
    public @NonNull String toString() {
        return line + ":" + row;
    }

    @Override
    public int compareTo(final @NonNull Position other) {
        assert other != null;

        final var lineComparison = Integer.compare(line, other.line);
        return (lineComparison != 0) ? lineComparison : Integer.compare(row, other.row);
    }
}
