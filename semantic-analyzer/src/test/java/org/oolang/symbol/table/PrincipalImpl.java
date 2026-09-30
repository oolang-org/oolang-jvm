/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.oolang.symbol.table.external.AbstractPrincipalLvll1;

import java.security.Principal;

public class PrincipalImpl extends AbstractPrincipalLvll1 implements Comparable<Principal> {
    public String publicProp = "public";
    protected String protectedProp = "protected";
    String packageProp = "package";
    private String privateProp = "private";

    @Override
    public int compareTo(Principal other) {
        return getName().compareTo(other.getName());
    }

    @Override
    public String getName() {
        return "PrincipalImpl";
    }
}
