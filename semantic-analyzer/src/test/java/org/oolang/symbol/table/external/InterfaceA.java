/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table.external;

public interface InterfaceA {
    default void foo() {
        System.out.println("A");
    }
}