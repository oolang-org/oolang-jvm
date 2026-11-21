/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.oolang.test.KlassesCacheInterceptor;
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
            "getA,setA,a",
            "getÉ,setÉ,É",
            "getName,setName,name",
            "getURL,setURL,url",
            "getETPhoneHome,setETPhoneHome,etPhoneHome",
            "getNICEFunction,setNICEFunction,niceFunction",
            "getÉtoile,setÉtoile,Étoile",
            "getÉTOILE,setÉTOILE,ÉTOILE",
    })
    void testAddToMaybePropertiesIfEligible_GetterGetAndSetter(String getterName,
                                                               String setterName,
                                                               String expectedProperty) {
        final var maybeProperties = new HashMap<String, MaybeProperty>();
        final var getterFunction = new Function(VOID_KLASS, getterName, PUBLIC, false, false,
                false, STRING_KLASS, List.of());
        FunctionPropertyUtils.addToMaybePropertiesIfEligible(getterFunction, maybeProperties);
        final var setterFunction = new Function(VOID_KLASS, setterName, PUBLIC, false, false,
                false, VOID_KLASS, List.of(new Function.Parameter(expectedProperty, STRING_KLASS)));
        FunctionPropertyUtils.addToMaybePropertiesIfEligible(setterFunction, maybeProperties);

        assertThat(maybeProperties).containsKey(expectedProperty);
        var maybeProperty = maybeProperties.get(expectedProperty);
        assertThat(maybeProperty.getter).isNull();
        assertThat(maybeProperty.oldSchoolGetter).isNotNull();
        assertThat(maybeProperty.oldSchoolGetter).isEqualTo(getterFunction);
        assertThat(maybeProperty.setters).isEmpty();
        assertThat(maybeProperty.oldSchoolSetters).hasSize(1);
        assertThat(maybeProperty.oldSchoolSetters).containsOnly(setterFunction);
    }

    @ParameterizedTest
    @CsvSource({
            "isA,setA,isA",
            "isÉ,setÉ,isÉ",
            "isName,setName,isName",
            "isURL,setURL,isURL",
            "isETPhoneHome,setETPhoneHome,isETPhoneHome",
            "isNICEFunction,setNICEFunction,isNICEFunction",
            "isÉtoile,setÉtoile,isÉtoile",
            "isÉTOILE,setÉTOILE,isÉTOILE",
    })
    void testAddToMaybePropertiesIfEligible_GetterIsAndSetter(String getterName,
                                                             String setterName,
                                                             String expectedProperty) {
        final var maybeProperties = new HashMap<String, MaybeProperty>();
        final var getterFunction = new Function(VOID_KLASS, getterName, PUBLIC, false, false,
                false, BOOLEAN_PRIMITIVE_KLASS, List.of());
        FunctionPropertyUtils.addToMaybePropertiesIfEligible(getterFunction, maybeProperties);
        final var setterFunction = new Function(VOID_KLASS, setterName, PUBLIC, false, false,
                false, VOID_KLASS, List.of(new Function.Parameter(expectedProperty, BOOLEAN_PRIMITIVE_KLASS)));
        FunctionPropertyUtils.addToMaybePropertiesIfEligible(setterFunction, maybeProperties);

        assertThat(maybeProperties).containsKey(expectedProperty);
        var maybeProperty = maybeProperties.get(expectedProperty);
        assertThat(maybeProperty.getter).isNull();
        assertThat(maybeProperty.oldSchoolGetter).isNotNull();
        assertThat(maybeProperty.oldSchoolGetter).isEqualTo(getterFunction);
        assertThat(maybeProperty.setters).isEmpty();
        assertThat(maybeProperty.oldSchoolSetters).hasSize(1);
        assertThat(maybeProperty.oldSchoolSetters).containsOnly(setterFunction);
    }


    @ParameterizedTest
    @CsvSource({
            "name,setName,name",
            "get,setGet,get",
            "getr,setGetr,getr",
            "getter,setGetter,getter",
            "is,setIs,is",
            "isa,setIsa,isa",
            "isabelle,setIsabelle,isabelle",
            "isA,setA,isA",
            "isÉ,setÉ,isÉ",
            "isName,setName,isName",
            "isURL,setURL,isURL",
            "isETPhoneHome,setETPhoneHome,isETPhoneHome",
            "isNICEFunction,setNICEFunction,isNICEFunction",
            "isÉtoile,setÉtoile,isÉtoile",
            "isÉTOILE,setÉTOILE,isÉTOILE",
    })
    void testAddToMaybePropertiesIfEligible_GetterNoGetNorIsAndSetter(String getterName,
                                                                      String setterName,
                                                                      String expectedProperty) {
        final var maybeProperties = new HashMap<String, MaybeProperty>();
        final var getterFunction = new Function(VOID_KLASS, getterName, PUBLIC, false, false,
                false, STRING_KLASS, List.of());
        FunctionPropertyUtils.addToMaybePropertiesIfEligible(getterFunction, maybeProperties);
        final var setterFunction = new Function(VOID_KLASS, setterName, PUBLIC, false, false,
                false, VOID_KLASS, List.of(new Function.Parameter(expectedProperty, BOOLEAN_PRIMITIVE_KLASS)));
        FunctionPropertyUtils.addToMaybePropertiesIfEligible(setterFunction, maybeProperties);

        assertThat(maybeProperties).containsKey(expectedProperty);
        var maybeProperty = maybeProperties.get(expectedProperty);
        assertThat(maybeProperty.getter).isNotNull();
        assertThat(maybeProperty.getter).isEqualTo(getterFunction);
        assertThat(maybeProperty.oldSchoolGetter).isNull();
        assertThat(maybeProperty.setters).isEmpty();
        assertThat(maybeProperty.oldSchoolSetters).hasSize(1);
        assertThat(maybeProperty.oldSchoolSetters).containsOnly(setterFunction);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "toString",
            "hashCode",
            "clone"
    })
    void testAddToMaybePropertiesIfEligible_NonGetterSpecificCases(String functionName) {
        final var maybeProperties = new HashMap<String, MaybeProperty>();
        final var function = new Function(VOID_KLASS, functionName, PUBLIC, false,
                false, false, STRING_KLASS, List.of());
        FunctionPropertyUtils.addToMaybePropertiesIfEligible(function, maybeProperties);
        assertThat(maybeProperties).isEmpty();
    }
}
