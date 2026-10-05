/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.*;

import static org.oolang.symbol.table.TypeResolver.OBJECT_KLASS;
import static org.oolang.symbol.table.Visibility.PUBLIC;

@SuppressWarnings("preview")
public final class OolangKlass extends BaseSymbol implements Klass {

    // the root of a symbol table is a virtual klass
    private static final @NonNull BaseSymbol VIRTUAL =
            new BaseSymbol("", PUBLIC, false /* whatever */, false /* whatever */, false /* whatever */);

    static @NonNull OolangKlass createRoot(final @NonNull String packageName, @NonNull Map<@NonNull String, @NonNull String> imports) {
        return new OolangKlass(VIRTUAL, false /* whatever */, false /* whatever */, packageName, imports);
    }

    private final boolean isInterface;
    private final @NonNull String packageName;
    private final @NonNull String fullName;

    final @NonNull Map<@NonNull String, @NonNull String> imports;

    // --------------------------------------------
    // Optional properties / functions / subclasses
    // --------------------------------------------

    private final @NonNull Map<@NonNull String, @NonNull Property> properties = new HashMap<>();
    public @NonNull List<@NonNull Function> functions = new ArrayList<>();
    public @Nullable Map<@NonNull String, @NonNull OolangKlass> klasses = null;

    OolangKlass(final @NonNull BaseSymbol baseSymbol,
                final boolean isInterface,
                final boolean isTopLevel,
                final @NonNull String prefix,
                final @NonNull Map<String, String> imports) {
        assert baseSymbol != null;
        assert prefix != null;
        assert imports != null;
        super(baseSymbol);

        this.isInterface = isInterface;
        if (name.isEmpty()) {
            // the root of a symbol table is a virtual klass, fullName = package
            this.packageName = prefix;
            this.fullName = prefix;
        } else if (isTopLevel) {
            this.packageName = prefix;
            this.fullName = prefix + '.' + baseSymbol.name;
        } else {
            final var endOfPackageName = prefix.lastIndexOf('.');
            this.packageName = prefix.substring(0, endOfPackageName);
            this.fullName = prefix + '$' + baseSymbol.name;
        }
        this.imports = imports;

        KLASSES_CACHE.get().put(fullName, this);
    }

    @NonNull OolangKlass addKlass(final @NonNull BaseSymbol baseSymbol, final boolean isInterface) {
        assert baseSymbol != null;

        if (klasses == null) {
            klasses = new HashMap<>();
        }
        final var childKlass = new OolangKlass(baseSymbol, isInterface, name.isEmpty(), fullName, imports);
        klasses.put(baseSymbol.name, childKlass);
        return childKlass;
    }

    private final @NonNull LazyConstant<@NonNull SortedSet<@NonNull BaseFunction>> searchableFunctions =
            LazyConstant.of(() -> new TreeSet<>(functions));

    @Override
    public boolean isInterface() {
        return isInterface;
    }

    @Override
    public @NonNull Map<@NonNull String, @NonNull Property> properties() {
        return properties;
    }

    @Override
    public @NonNull SortedSet<@NonNull BaseFunction> functions() {
        return searchableFunctions.get();
    }

    @Override
    public @NonNull String descriptorString() {
        final var name = fullName.replace('.', '/');
        return "L" + name + ";";
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public @NonNull Klass componentType() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public @NonNull Klass arrayType() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // todo implement methods below

    @Override
    public @NonNull String packageName() {
        return packageName;
    }

    @Override
    public @NonNull SequencedCollection<@NonNull Type> genericSuperKlasses() {
        return List.of(OBJECT_KLASS); // todo real implementation
    }

    @Override
    public @NonNull SequencedCollection<@NonNull Type> genericSuperInterfaces() {
        return List.of();
    }
}
