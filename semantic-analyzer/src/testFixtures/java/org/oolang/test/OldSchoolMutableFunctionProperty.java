/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.test;

public class OldSchoolMutableFunctionProperty {
    private String name_;

    public String getName() {
        return name_;
    }

    public String name() {
        throw new IllegalStateException("You should have called getName()!");
    }

    public void setName(String name_) {
        this.name_ = name_;
    }

    public void name(String name_) {
        throw new IllegalStateException("You should have called setName(name_)!");
    }
}
