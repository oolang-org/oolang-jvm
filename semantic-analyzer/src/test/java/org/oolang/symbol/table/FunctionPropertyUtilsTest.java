/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.oolang.KlassesCacheInterceptor;
import org.oolang.symbol.table.FunctionPropertyUtils.MaybeProperty;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.oolang.symbol.table.TypeResolver.*;
import static org.oolang.symbol.table.Visibility.PUBLIC;

@ExtendWith(KlassesCacheInterceptor.class)
public class FunctionPropertyUtilsTest {
    @ParameterizedTest
    @CsvSource({
            "getA,a",
            "getÉ,É",
            "getName,name",
            "getURL,url",
            "getETPhoneHome,etPhoneHome",
            "getNICEFunction,niceFunction",
            "getÉtoile,Étoile",
            "getÉTOILE,ÉTOILE",
    })
    void testAddToMaybePropertiesIfEligible_GetterGet(String functionName, String expected) {
        final var maybeProperties = new HashMap<String, MaybeProperty>();
        final var function = new Function((ExistingKlass) VOID_KLASS, functionName, PUBLIC, false,
                false, false, STRING_KLASS, List.of());
        FunctionPropertyUtils.addToMaybePropertiesIfEligible(function, maybeProperties);
        assertThat(maybeProperties).containsKey(expected);
        var maybeProperty = maybeProperties.get(expected);
        assertThat(maybeProperty.getter).isNull();
        assertThat(maybeProperty.oldSchoolGetter).isNotNull();
        assertThat(maybeProperty.oldSchoolGetter).isEqualTo(function);
        assertThat(maybeProperty.setters).isEmpty();
        assertThat(maybeProperty.oldSchoolSetters).isEmpty();
    }

    @ParameterizedTest
    @CsvSource({
            "isA,isA",
            "isÉ,isÉ",
            "isName,isName",
            "isURL,isURL",
            "isETPhoneHome,isETPhoneHome",
            "isNICEFunction,isNICEFunction",
            "isÉtoile,isÉtoile",
            "isÉTOILE,isÉTOILE",
    })
    void testAddToMaybePropertiesIfEligible_GetterIs(String functionName, String expected) {
        final var maybeProperties = new HashMap<String, MaybeProperty>();
        final var function = new Function((ExistingKlass) VOID_KLASS, functionName, PUBLIC, false,
                false, false, BOOLEAN_PRIMITIVE_KLASS, List.of());
        FunctionPropertyUtils.addToMaybePropertiesIfEligible(function, maybeProperties);
        assertThat(maybeProperties).containsKey(expected);
        var maybeProperty = maybeProperties.get(expected);
        assertThat(maybeProperty.getter).isNull();
        assertThat(maybeProperty.oldSchoolGetter).isNotNull();
        assertThat(maybeProperty.oldSchoolGetter).isEqualTo(function);
        assertThat(maybeProperty.setters).isEmpty();
        assertThat(maybeProperty.oldSchoolSetters).isEmpty();
    }


    @ParameterizedTest
    @CsvSource({
            "name, name",
            "get,get",
            "getr,getr",
            "getter,getter",
            "is,is",
            "isa,isa",
            "isabelle,isabelle",
            "isA,isA",
            "isÉ,isÉ",
            "isName,isName",
            "isURL,isURL",
            "isETPhoneHome,isETPhoneHome",
            "isNICEFunction,isNICEFunction",
            "isÉtoile,isÉtoile",
            "isÉTOILE,isÉTOILE",
    })
    void testAddToMaybePropertiesIfEligible_GetterNoGetNorIs(String functionName, String expected) {
        final var maybeProperties = new HashMap<String, MaybeProperty>();
        final var function = new Function((ExistingKlass) VOID_KLASS, functionName, PUBLIC, false,
                false, false, STRING_KLASS, List.of());
        FunctionPropertyUtils.addToMaybePropertiesIfEligible(function, maybeProperties);
        assertThat(maybeProperties).containsKey(expected);
        var maybeProperty = maybeProperties.get(expected);
        assertThat(maybeProperty.getter).isNotNull();
        assertThat(maybeProperty.getter).isEqualTo(function);
        assertThat(maybeProperty.oldSchoolGetter).isNull();
        assertThat(maybeProperty.setters).isEmpty();
        assertThat(maybeProperty.oldSchoolSetters).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "toString",
            "hashCode",
            "clone"
    })
    void testAddToMaybePropertiesIfEligible_NonGetterSpecificCases(String functionName) {
        final var maybeProperties = new HashMap<String, MaybeProperty>();
        final var function = new Function((ExistingKlass) VOID_KLASS, functionName, PUBLIC, false,
                false, false, STRING_KLASS, List.of());
        FunctionPropertyUtils.addToMaybePropertiesIfEligible(function, maybeProperties);
        assertThat(maybeProperties).isEmpty();
    }
}
