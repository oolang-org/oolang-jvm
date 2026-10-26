/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.oolang.KlassesCacheInterceptor;
import org.oolang.symbol.table.external.AbstractPrincipalLvll1;
import org.oolang.symbol.table.external.ClassC;

import java.security.Principal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(KlassesCacheInterceptor.class)
public class InheritanceTest {
    @Test
    public void subinterfacesWin() {
        var klass = new ExistingKlass(ClassC.class);
        assertThat(klass.genericSuperInterfaces()).hasSize(2);
        var superInterface1 = (Klass) klass.genericSuperInterfaces().getFirst();
        assertThat(superInterface1.descriptorString()).isEqualTo("Lorg/oolang/symbol/table/external/InterfaceB;");
        var superInterface2 = (Klass) klass.genericSuperInterfaces().getLast();
        assertThat(superInterface2.descriptorString()).isEqualTo("Lorg/oolang/symbol/table/external/InterfaceA;");
    }

    @Test
    public void isAssignableFromTest() {
        var klass = new ExistingKlass(PrincipalImpl.class);
        assertThat(klass.isAssignableFrom(new ExistingKlass(PrincipalImpl.class))).isTrue();
        assertThat(klass.isAssignableFrom(new ExistingKlass(AbstractPrincipalLvll1.class))).isTrue();
        assertThat(klass.isAssignableFrom(new ExistingKlass(Comparable.class))).isTrue();
        assertThat(klass.isAssignableFrom(new ExistingKlass(AbstractPrincipalLvl2.class))).isTrue();
        assertThat(klass.isAssignableFrom(new ExistingKlass(Principal.class))).isTrue();
    }

    @Test
    public void getAccessiblePropertyIncludeSelfTest() {
        var klass = new ExistingKlass(PrincipalImpl.class);

        // properties from the PrincipalImpl class itself
        var property = (Property) klass.accessiblePropertyOrFunctionProperty("publicProp", true);
        assertThat(property).isNotNull();
        assertThat(((ExistingKlass) property.type()).descriptorString()).isEqualTo("Ljava/lang/String;");
        property = (Property) klass.accessiblePropertyOrFunctionProperty("protectedProp", true);
        assertThat(property).isNotNull();
        assertThat(((ExistingKlass) property.type()).descriptorString()).isEqualTo("Ljava/lang/String;");
        property = (Property) klass.accessiblePropertyOrFunctionProperty("packageProp", true);
        assertThat(property).isNotNull();
        assertThat(((ExistingKlass) property.type()).descriptorString()).isEqualTo("Ljava/lang/String;");
        property = (Property) klass.accessiblePropertyOrFunctionProperty("privateProp", true);
        assertThat(property).isNull();

        // properties from lvl1 parent
        property = (Property) klass.accessiblePropertyOrFunctionProperty("parentPublicPropLvl1", false);
        assertThat(property).isNotNull();
        assertThat(((ExistingKlass) property.type()).descriptorString()).isEqualTo("Ljava/lang/String;");
        property = (Property) klass.accessiblePropertyOrFunctionProperty("parentProtectedPropLvl1", false);
        assertThat(property).isNotNull();
        assertThat(((ExistingKlass) property.type()).descriptorString()).isEqualTo("Ljava/lang/String;");
        // not in the same package
        property = (Property) klass.accessiblePropertyOrFunctionProperty("parentPackagePropLvl1", false);
        assertThat(property).isNull();
        property = (Property) klass.accessiblePropertyOrFunctionProperty("privatePropLvl1", false);
        assertThat(property).isNull();

        // properties from lvl2 parent
        property = (Property) klass.accessiblePropertyOrFunctionProperty("parentPublicPropLvl2", false);
        assertThat(property).isNotNull();
        assertThat(((ExistingKlass) property.type()).descriptorString()).isEqualTo("Ljava/lang/String;");
        property = (Property) klass.accessiblePropertyOrFunctionProperty("parentProtectedPropLvl2", false);
        assertThat(property).isNotNull();
        assertThat(((ExistingKlass) property.type()).descriptorString()).isEqualTo("Ljava/lang/String;");
        // in the same package
        property = (Property) klass.accessiblePropertyOrFunctionProperty("parentPackagePropLvl2", false);
        assertThat(property).isNotNull();
        assertThat(((ExistingKlass) property.type()).descriptorString()).isEqualTo("Ljava/lang/String;");
        property = (Property) klass.accessiblePropertyOrFunctionProperty("privatePropLvl2", false);
        assertThat(property).isNull();
    }

    @Test
    public void getAccessiblePropertyForParentsTest() {
        var type = new ExistingKlass(PrincipalImpl.class);

        // properties from the PrincipalImpl class itself
        var property = (Property) type.accessiblePropertyOrFunctionProperty("publicProp", false);
        assertThat(property).isNull();
        property = (Property) type.accessiblePropertyOrFunctionProperty("protectedProp", false);
        assertThat(property).isNull();
        property = (Property) type.accessiblePropertyOrFunctionProperty("packageProp", false);
        assertThat(property).isNull();
        property = (Property) type.accessiblePropertyOrFunctionProperty("privateProp", false);
        assertThat(property).isNull();

        // properties from lvl1 parent
        property = (Property) type.accessiblePropertyOrFunctionProperty("parentPublicPropLvl1", false);
        assertThat(property).isNotNull();
        assertThat(((ExistingKlass) property.type()).descriptorString()).isEqualTo("Ljava/lang/String;");
        property = (Property) type.accessiblePropertyOrFunctionProperty("parentProtectedPropLvl1", false);
        assertThat(property).isNotNull();
        assertThat(((ExistingKlass) property.type()).descriptorString()).isEqualTo("Ljava/lang/String;");
        // not in the same package
        property = (Property) type.accessiblePropertyOrFunctionProperty("parentPackagePropLvl1", false);
        assertThat(property).isNull();
        property = (Property) type.accessiblePropertyOrFunctionProperty("privatePropLvl1", false);
        assertThat(property).isNull();

        // properties from lvl2 parent
        property = (Property) type.accessiblePropertyOrFunctionProperty("parentPublicPropLvl2", false);
        assertThat(property).isNotNull();
        assertThat(((ExistingKlass) property.type()).descriptorString()).isEqualTo("Ljava/lang/String;");
        property = (Property) type.accessiblePropertyOrFunctionProperty("parentProtectedPropLvl2", false);
        assertThat(property).isNotNull();
        assertThat(((ExistingKlass) property.type()).descriptorString()).isEqualTo("Ljava/lang/String;");
        // in the same package
        property = (Property) type.accessiblePropertyOrFunctionProperty("parentPackagePropLvl2", false);
        assertThat(property).isNotNull();
        assertThat(((ExistingKlass) property.type()).descriptorString()).isEqualTo("Ljava/lang/String;");
        property = (Property) type.accessiblePropertyOrFunctionProperty("privatePropLvl2", false);
        assertThat(property).isNull();
    }
}
