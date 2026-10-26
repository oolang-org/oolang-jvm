/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.OolangPropCustomAttribute;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassFile.AttributeMapperOption;
import java.lang.classfile.ClassModel;
import java.lang.reflect.AccessFlag;
import java.util.*;

import static org.oolang.symbol.table.TypeResolver.*;
import static org.oolang.symbol.table.Visibility.PRIVATE;

final class FunctionPropertyUtils {
    // un-instantiable
    private FunctionPropertyUtils() {
    }

    private final static @NonNull Set<@NonNull String> NON_GETTER_FUNCTION_NAMES = Set.of(
            "toString",
            "hashCode",
            "getClass",
            "clone"
    );

    /// The Class-File API [AttributeMapperOption] that allows reading the
    /// [Oolang custom attribute][OolangPropCustomAttribute]
    private final static @NonNull AttributeMapperOption OOLANG_PROP_CUSTOM_ATTRIBUTE_OPTION =
            ClassFile.AttributeMapperOption.of(utf8Entry ->
                    utf8Entry.equalsString(OolangPropCustomAttribute.NAME)
                            ? new OolangPropCustomAttribute().attributeMapper()
                            : null
            );

    static void addToMaybePropertiesIfEligible(
            final @NonNull Function function,
            final @NonNull Map<@NonNull String, @NonNull MaybeProperty> maybeProperties
    ) {
        assert function != null;
        assert maybeProperties != null;

        if (function.isStatic) {
            return; // static functions cannot be properties
        }

        switch (function.parameters.size()) {
            // maybe a getter
            case 0 -> addGetterToMaybePropertiesIfEligible(function, maybeProperties);
            // maybe a setter
            case 1 -> {
                if (function.returnType() != VOID_KLASS) {
                    return; // a setter must be void
                }
                final MaybeProperty maybeProperty;
                if (maybeProperties.containsKey(function.name)) {
                    maybeProperty = maybeProperties.get(function.name);
                } else {
                    maybeProperty = new MaybeProperty();
                    maybeProperties.put(function.name, maybeProperty);
                }
                maybeProperty.setters.add(function);
            }
        }
    }

    private static void addGetterToMaybePropertiesIfEligible(
            final @NonNull Function function,
            final @NonNull Map<@NonNull String, @NonNull MaybeProperty> maybeProperties
    ) {
        assert function != null;
        assert maybeProperties != null;

        if (NON_GETTER_FUNCTION_NAMES.contains(function.name)) {
            return;
        }

        if (function.name.equals("name")) {
            System.out.println("Found getter for name");
        }

        final var returnType = function.returnType();
        if (returnType == VOID_KLASS) {
            return; // a getter cannot be void
        }

        var oldSchoolGetter = false;
        var functionName = function.name;
        if (functionName.startsWith("get")) {
            final var propertyName = oldSchoolGetterSetterPropertyNameOrNull(functionName);
            if (propertyName != null) {
                functionName = propertyName;
                oldSchoolGetter = true;
            }
        } else if ((returnType == BOOLEAN_PRIMITIVE_KLASS || returnType == BOOLEAN_WRAPPER_KLASS) &&
                functionName.startsWith("is")) {
            if (functionName.length() > 2 && Character.isUpperCase(functionName.charAt(2))) {
                oldSchoolGetter = true;
            }
        }

        final MaybeProperty maybeProperty;
        if (maybeProperties.containsKey(functionName)) {
            maybeProperty = maybeProperties.get(functionName);
        } else {
            maybeProperty = new MaybeProperty();
            maybeProperties.put(functionName, maybeProperty);
        }

        if (oldSchoolGetter) {
            maybeProperty.oldSchoolGetter = function;
        } else {
            maybeProperty.getter = function;
        }
    }

    private static @Nullable String oldSchoolGetterSetterPropertyNameOrNull(final @NonNull String functionName) {
        assert functionName != null;

        return switch (functionName.length()) {
            case 3 -> null; // the `get()` or `set()` function is not an old-school getter/setter
            case 4 -> {
                final var maybePropertyAsChar = functionName.charAt(3);
                if (maybePropertyAsChar >= 'A' && maybePropertyAsChar <= 'Z') { // [A-Z]
                    yield String.valueOf(Character.toLowerCase(maybePropertyAsChar));
                } else if (Character.isUpperCase(maybePropertyAsChar)) { // other uppercase, like `É`
                    yield String.valueOf(maybePropertyAsChar);
                }
                yield null; // e.g. `getr()` or `setr(value)`, not a getter/setter
            }
            default -> {
                final var maybePropertyFirstChar = functionName.charAt(3);
                if (maybePropertyFirstChar >= 'A' && maybePropertyFirstChar <= 'Z') { // [A-Z]
                    yield decapitalize(functionName);
                } else if (Character.isUpperCase(maybePropertyFirstChar)) { // other uppercase, like `É`
                    yield functionName.substring(3);
                }
                yield null; // e.g. `getter()` or `settle(value)`, not a getter/setter
            }
        };
    }

    /// Decapitalize behavior:
    /// - `Name` → `name`
    /// - `URL` → `url`
    /// - `NICEFunction` → `niceFunction`
    private static @NonNull String decapitalize(final @NonNull String functionName) {
        assert functionName != null;

        final var secondCharIndex = 4;
        final var secondChar = functionName.charAt(secondCharIndex);
        if (secondChar < 'A' || secondChar > 'Z') {
            return Character.toLowerCase(functionName.charAt(3)) + functionName.substring(secondCharIndex);
        }
        // second char is also in [A-Z]
        return decapitalizeUntilLastCapital(functionName);
    }

    /// `URL` → `url` or `NICEFunction` → `niceFunction`
    private static @NonNull String decapitalizeUntilLastCapital(final @NonNull String functionName) {
        assert functionName != null;

        final var limitIndex = functionName.length();
        var lastCapitalIndex = 5;
        while (lastCapitalIndex < limitIndex) {
            final var currentChar = functionName.charAt(lastCapitalIndex);
            if (currentChar < 'A' || currentChar > 'Z') {
                break;
            }
            lastCapitalIndex++;
        }
        return (lastCapitalIndex == functionName.length())
                // lowercase all the name after prefix
                ? functionName.substring(3).toLowerCase(Locale.US)
                // lowercase except the last capital, append the rest as-is
                : functionName.substring(3, --lastCapitalIndex).toLowerCase(Locale.US)
                + functionName.substring(lastCapitalIndex);
    }

    static void addFunctionProperties(final @NonNull PropertyCandidates propertyCandidates,
                                      final @NonNull Class<?> javaClass,
                                      final @NonNull Map<@NonNull String, @NonNull Property> properties) {
        assert propertyCandidates != null;
        assert javaClass != null;
        assert properties != null;

        // 1) If there are some Oolang compatible property candidates,
        // we must parse their Class using the Class-file API to look for `OolangPropCustomAttribute`
        if (!propertyCandidates.oolangPropertyCandidates.isEmpty()) {
            addOolangFunctionProperties(propertyCandidates.oolangPropertyCandidates, javaClass, properties);
        }
    }

    private static void addOolangFunctionProperties(
            final @NonNull Map<@NonNull String, @NonNull PropertyCandidate> oolangPropertyCandidates,
            final @NonNull Class<?> javaClass,
            final @NonNull Map<@NonNull String, @NonNull Property> properties) {
        assert oolangPropertyCandidates != null;
        assert javaClass != null;
        assert properties != null;

        final var classFile = parseClassFile(javaClass);
        if (classFile == null) {
            return;
        }

        // todo look for SourceDebugExtensionAttribute "compiler: Oolang version"

        final var oolangPropertyCandidatesByDescriptor = oolangPropertyCandidatesByDescriptor(oolangPropertyCandidates);
        for (final var classFileMethod : classFile.methods()) {
            final var flags = classFileMethod.flags();
            if (flags.has(AccessFlag.PRIVATE) || flags.has(AccessFlag.STATIC)) {
                continue;
            }
            final var matchingPropertyCandidate = oolangPropertyCandidatesByDescriptor
                    .get(classFileMethod.methodName().toString() + classFileMethod.methodType());
            if (matchingPropertyCandidate != null) {

                // todo look for OolangPropCustomAttribute to ensure this is an Oolang function property

                final var matchingGetterFunction = matchingPropertyCandidate.getter;
                assert matchingGetterFunction != null;
                final var newProperty = new Property(matchingGetterFunction.declaringKlass, matchingGetterFunction, matchingGetterFunction.returnType());
                newProperty.visibility = PRIVATE;
                newProperty.getter = matchingGetterFunction;
                properties.put(newProperty.name, newProperty);
            }
        }
    }

    private static @Nullable ClassModel parseClassFile(final @NonNull Class<?> javaClass) {
        assert javaClass != null;

        // 1) convert the class name to its expected resource path format
        final var resourceName = javaClass.getSimpleName() + ".class";

        // 2) read the raw bytecode bytes using the class loader
        final byte[] classBytes;
        try (final var is = javaClass.getResourceAsStream(resourceName)) {
            if (is == null) {
                return null;
            }
            classBytes = is.readAllBytes();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        // // 3) add the option that allows reading the Oolang custom attribute, then parse the bytes into a ClassModel
        return ClassFile.of(OOLANG_PROP_CUSTOM_ATTRIBUTE_OPTION).parse(classBytes);
    }

    private static @NonNull Map<@NonNull String, @NonNull PropertyCandidate> oolangPropertyCandidatesByDescriptor(
            final @NonNull Map<@NonNull String, @NonNull PropertyCandidate> oolangPropertyCandidates
    ) {
        assert oolangPropertyCandidates != null;

        final var oolangPropertyCandidatesByDescriptor = new HashMap<@NonNull String, @NonNull PropertyCandidate>();
        for (final var oolangPropertyCandidateEntry : oolangPropertyCandidates.entrySet()) {
            final var oolangPropertyCandidate = oolangPropertyCandidateEntry.getValue();
            assert oolangPropertyCandidate.getter != null;
            // key = name + getter type descriptor string
            oolangPropertyCandidatesByDescriptor.put(
                    oolangPropertyCandidateEntry.getKey() + oolangPropertyCandidate.getter.typeDescriptorString(),
                    oolangPropertyCandidate);
        }
        return oolangPropertyCandidatesByDescriptor;
    }

    static @NonNull PropertyCandidates propertyCandidatesFromMaybeProperties(
            final @NonNull Map<@NonNull String, @NonNull MaybeProperty> maybeProperties
    ) {
        assert maybeProperties != null;

        final var oolangPropertyCandidates = new HashMap<@NonNull String, @NonNull PropertyCandidate>();
        final var oldSchoolPropertyCandidates = new HashMap<@NonNull String, @NonNull PropertyCandidate>();
        for (final var maybePropertyEntry : maybeProperties.entrySet()) {
            final var maybeProperty = maybePropertyEntry.getValue();
            if (maybeProperty.getter == null && maybeProperty.oldSchoolGetter == null) {
                continue; // not a valid property candidate
            }

            final Optional<@NonNull Function> setter;
            if (maybeProperty.getter != null) {
                setter = maybeProperty.setters.stream()
                        // setter unique param type must match getter return type.
                        .filter(maybeSetter -> {
                            final var maybeSetterParamType = maybeSetter.parameters.getFirst().type();
                            return maybeSetterParamType.equals(maybeProperty.getter.returnType());
                        })
                        .findFirst();
            } else {
                setter = Optional.empty();
            }

            final Optional<@NonNull Function> oldSchoolSetter;
            if (maybeProperty.oldSchoolGetter != null) {
                oldSchoolSetter = maybeProperty.oldSchoolSetters.stream()
                        // setter unique param type must match getter return type.
                        .filter(maybeSetter -> {
                            final var maybeSetterParamType = maybeSetter.parameters.getFirst().type();
                            return maybeSetterParamType.equals(maybeProperty.oldSchoolGetter.returnType());
                        })
                        .findFirst();
            } else {
                oldSchoolSetter = Optional.empty();
            }

            final var propertyCandidate = new PropertyCandidate(
                    maybeProperty.getter,
                    maybeProperty.oldSchoolGetter,
                    setter,
                    oldSchoolSetter);

            if (maybeProperty.getter != null) {
                oolangPropertyCandidates.put(maybePropertyEntry.getKey(), propertyCandidate);
            } else {
                oldSchoolPropertyCandidates.put(maybePropertyEntry.getKey(), propertyCandidate);
            }
        }

        return new PropertyCandidates(oolangPropertyCandidates, oldSchoolPropertyCandidates);
    }

    /// Note: an old-school getter or setter is starting with `get` / `is` or `set` followed by a capital letter.
    static final class MaybeProperty {
        @Nullable Function getter = null;
        @Nullable Function oldSchoolGetter = null;
        final @NonNull List<@NonNull Function> setters = new ArrayList<>();
        final @NonNull List<@NonNull Function> oldSchoolSetters = new ArrayList<>();
    }

    /// A candidate for a Oolang property, associated with a getter function and an optional setter function.
    ///
    /// The current existing class will be parsed once using the [ClassFile] API to search for a
    /// [OolangPropCustomAttribute] on the getter and setter function (if present) for each property candidate.
    record PropertyCandidate(@Nullable Function getter,
                             @Nullable Function oldSchoolGetter,
                             @NonNull Optional<@NonNull Function> setter,
                             @NonNull Optional<@NonNull Function> oldSchoolSetter) {
    }

    record PropertyCandidates(@NonNull Map<@NonNull String, @NonNull PropertyCandidate> oolangPropertyCandidates,
                              @NonNull Map<@NonNull String, @NonNull PropertyCandidate> oldSchoolPropertyCandidates) {
    }
}
