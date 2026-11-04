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
public final class OolangKlass extends Klass implements Symbol {
    // the root of a symbol table is a virtual klass
    private static final @NonNull BaseSymbol VIRTUAL =
            new BaseSymbol("", PUBLIC, false /* whatever */, false /* whatever */, false /* whatever */);

    static @NonNull OolangKlass createRoot(final @NonNull String packageName,
                                           final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert packageName != null;
        assert imports != null;

        return new OolangKlass(VIRTUAL, false /* whatever */, false /* whatever */, packageName, imports);
    }

    private final @NonNull String name;
    private final @NonNull Visibility visibility;
    private final boolean isStatic;
    private final boolean isAbstract;
    private final boolean isFinal;
    private final boolean isInterface;
    private final @NonNull String packageName;
    private final @NonNull String fullName;
    final @NonNull Map<@NonNull String, @NonNull String> imports;

    // ------------------------------------------------------------------------------
    // Optional superclass/interfaces | properties | functions | nested/inner classes
    // ------------------------------------------------------------------------------

    @NonNull List<Type.@NonNull Lazy> ancestors = new ArrayList<>();
    private final @NonNull Map<@NonNull String, @NonNull Property> properties = new HashMap<>();
    public @NonNull List<@NonNull Function> functions = new ArrayList<>();
    public @Nullable Map<@NonNull String, @NonNull OolangKlass> klasses = null;


    private final @NonNull LazyConstant<@NonNull SortedSet<@NonNull BaseFunction>> searchableFunctions =
            LazyConstant.of(() -> new TreeSet<>(functions));
    private final @NonNull LazyConstant<@NonNull Ancestors> resolvedAncestors =
            LazyConstant.of(this::buildAncestors);

    private @NonNull Ancestors buildAncestors() {
        final var ancestorsIterator = ancestors.iterator();
        ActualType superKlass = null;
        final var interfaces = new ArrayList<@NonNull ActualType>();
        if (ancestorsIterator.hasNext()) {
            // the first ancestor may be a class, if so it is our superclass
            final var firstAncestor = ancestorsIterator.next().type();
            if (TypeResolver.getKlassFromType(firstAncestor).isInterface()) {
                interfaces.add(firstAncestor);
            } else {
                superKlass = firstAncestor;
            }
        }
        // loop on remaining ancestors, they are all interfaces
        while (ancestorsIterator.hasNext()) {
            interfaces.add(ancestorsIterator.next().type());
        }

        // manually add Object as superclass if none is specified and current Klass is a class.
        if (superKlass == null && !isInterface) {
            superKlass = OBJECT_KLASS;
        }

        return new Ancestors(superKlass, interfaces);
    }


    OolangKlass(final @NonNull BaseSymbol baseSymbol,
                final boolean isInterface,
                final boolean isTopLevel,
                final @NonNull String prefix,
                final @NonNull Map<String, String> imports) {
        assert baseSymbol != null;
        assert prefix != null;
        assert imports != null;

        this.name = baseSymbol.name();
        this.visibility = baseSymbol.visibility();
        this.isStatic = baseSymbol.isStatic();
        this.isAbstract = baseSymbol.isAbstract();
        this.isFinal = baseSymbol.isFinal();

        this.isInterface = isInterface;
        if (name.isEmpty()) {
            // the root of a symbol table is a virtual klass, fullName = package
            this.packageName = prefix;
            this.fullName = prefix;
        } else if (isTopLevel) {
            this.packageName = prefix;
            this.fullName = prefix + '.' + baseSymbol.name();
        } else {
            final var endOfPackageName = prefix.lastIndexOf('.');
            this.packageName = prefix.substring(0, endOfPackageName);
            this.fullName = prefix + '$' + baseSymbol.name();
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
        klasses.put(baseSymbol.name(), childKlass);
        return childKlass;
    }

    @Override
    public boolean isInterface() {
        return isInterface;
    }

    @Override
    public @NonNull String packageName() {
        return packageName;
    }

    @Override
    public @NonNull String name() {
        return name;
    }

    @Override
    public @NonNull Visibility visibility() {
        return visibility;
    }

    @Override
    public boolean isStatic() {
        return isStatic;
    }

    @Override
    public boolean isAbstract() {
        return isAbstract;
    }

    @Override
    public boolean isFinal() {
        return isFinal;
    }

    @Override
    @Nullable ActualType superKlass() {
        return resolvedAncestors.get().superKlass;
    }

    @Override
    @NonNull List<@NonNull ActualType> interfaces() {
        return resolvedAncestors.get().interfaces;
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

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void resolveAncestors() {
        resolvedAncestors.get();
    }

    private record Ancestors(@Nullable ActualType superKlass, @NonNull List<@NonNull ActualType> interfaces) {
    }

    // todo implement methods below

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
}
