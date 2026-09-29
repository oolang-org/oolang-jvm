/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import java.security.Principal;

public abstract class AbstractPrincipalLvl2 implements Principal {
    public String parentPublicPropLvl2 = "publicLvl2";
    protected String parentProtectedPropLvl2 = "protectedLvl2";
    String parentPackagePropLvl2 = "packageLvl2";
    private String parentPrivatePropLvl2 = "privateLvl2";
}
