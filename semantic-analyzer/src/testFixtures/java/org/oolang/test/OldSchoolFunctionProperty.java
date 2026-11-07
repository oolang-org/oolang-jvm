/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.test;

import java.security.Principal;

public class OldSchoolFunctionProperty implements Principal {
    public static Principal createPrincipal() {
        return new OldSchoolFunctionProperty();
    }

    @Override
    public String getName() {
        return "Name1";
    }

    public String name() {
        throw new IllegalStateException("You should have called getName()!");
    }
}
