/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.compiler;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.Import;
import org.oolang.ast.PackageHeader;
import org.oolang.ast.element.ClassBody;
import org.oolang.ast.element.ElementModifier;
import org.oolang.ast.element.RealElement;
import org.oolang.ast.expression.ConstantExpression;
import org.oolang.ast.expression.Expression;
import org.oolang.ast.expression.LoadExpression;
import org.oolang.ast.expression.RealExpression;
import org.oolang.ast.statement.CodeBlock;
import org.oolang.ast.statement.ConstructorCodeBlock;
import org.oolang.ast.statement.RealStatement;
import org.oolang.ast.statement.Statement;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.classfile.ClassBuilder;
import java.lang.classfile.ClassFile;
import java.lang.classfile.CodeBuilder;
import java.lang.classfile.attribute.ConstantValueAttribute;
import java.lang.constant.*;
import java.lang.reflect.AccessFlag;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static java.lang.System.Logger.Level.DEBUG;
import static org.oolang.ast.element.RealElement.ElementType.*;
import static org.oolang.ast.expression.JvmInvocationUtils.GET_STATIC;
import static org.oolang.ast.expression.JvmInvocationUtils.INVOKE_VIRTUAL;
import static org.oolang.ast.expression.RealExpression.ExpressionType.PROP_ACCESS;
import static org.oolang.compiler.Descriptors.*;
import static org.oolang.compiler.StringCompilationUtils.stringConcatenation;

public final class OolangCompiler {
    private static final String PUBLIC = "public";
    private static final String FINAL = "final";

    // un-instantiable
    private OolangCompiler() {
    }

    private static final System.Logger LOGGER = System.getLogger("oolang.compiler.OolangCompiler");

    public static @NonNull Path compile(final @NonNull PackageHeader packageHeader,
                                        final @NonNull List<@NonNull Import> imports,
                                        final @NonNull RealElement element,
                                        final @NonNull Path rootPath) {
        Objects.requireNonNull(packageHeader);
        Objects.requireNonNull(imports);
        Objects.requireNonNull(element);
        Objects.requireNonNull(rootPath);

        final var classFile = ClassFile.of();
        try {
            final var package_ = packageHeader.raw().replace('.', '/');
            final var packagePath = rootPath.resolve(package_);
            Files.createDirectories(packagePath);

            assert element.identifier != null;
            final var className = element.identifier.identifier;
            final var classPath = packagePath.resolve(className + ".class");
            classFile.buildTo(classPath, ClassDesc.ofInternalName(package_ + "/" + className), classBuilder -> {
                switch (element.elementType) {
                    case CLASS -> visitClass(element, classBuilder);
                    case INTERFACE -> throw new UnsupportedOperationException("interface");
                }
            });
            if (LOGGER.isLoggable(DEBUG)) {
                LOGGER.log(DEBUG, "Compiled {0} {1} to {2}",
                        element.elementType.name().toLowerCase(Locale.US), className, classPath);
            }
            return classPath;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static void visitClass(final @NonNull RealElement classElement, final @NonNull ClassBuilder classBuilder) {
        assert classElement != null;
        assert classBuilder != null;

        classBuilder.withFlags(computeModifiers(classElement.modifiers));

        for (final var child : classElement.children) {
            if (child instanceof ClassBody classBody) {
                visitClassBody(classBody, classBuilder);
            }
        }
    }

    private static void visitClassBody(final @NonNull ClassBody classBody, final @NonNull ClassBuilder classBuilder) {
        assert classBody != null;
        assert classBuilder != null;

        var hasConstructor = false;
        for (final var child : classBody.children) {
            switch (child.elementType) {
                case CONSTRUCTOR -> {
                    hasConstructor = true;
                    visitConstructor(child, classBuilder);
                }
                case VAR, VAL -> visitProperty(child, classBuilder);
                case FUN -> visitFun(child, classBuilder);
                case CLASS -> visitClass(child, classBuilder);
                case INTERFACE -> throw new UnsupportedOperationException();
                default -> throw new IllegalStateException("Unknown element type: " + child.elementType);
            }
        }

        // if no explicit constructor was found, add a public empty default constructor
        if (!hasConstructor) {
            final var defaultConstructor = new RealElement(CONSTRUCTOR);
            defaultConstructor.modifiers.addAll(
                    List.of(new ElementModifier(ElementModifier.ModifierType.VISIBILITY, PUBLIC),
                            new ElementModifier(ElementModifier.ModifierType.INHERITANCE, FINAL)));
            defaultConstructor.children.add(new ConstructorCodeBlock());
            visitConstructor(defaultConstructor, classBuilder);
        }
    }

    private static void visitConstructor(final @NonNull RealElement constructorElement,
                                         final @NonNull ClassBuilder classBuilder) {
        assert constructorElement != null;
        assert classBuilder != null;

        classBuilder.withMethodBody(
                ConstantDescs.INIT_NAME,
                MethodTypeDesc.of(ConstantDescs.CD_void),
                computeModifiers(constructorElement.modifiers),
                codeBuilder ->
                        // constructor code block is the last child
                        visitConstructorCodeBlock((ConstructorCodeBlock) constructorElement.children.getLast(),
                                codeBuilder)
        );
    }

    private static void visitConstructorCodeBlock(final @NonNull ConstructorCodeBlock constructorCodeBlock,
                                                  final @NonNull CodeBuilder codeBuilder) {
        assert constructorCodeBlock != null;
        assert codeBuilder != null;

        // 1) execute early-larval statements
        for (final var earlyStatement : constructorCodeBlock.earlyLarvalStatements) {
            visitStatement(earlyStatement, codeBuilder);
        }

        // 2) call another constructor in the current class or a super constructor.
        codeBuilder.aload(0); // = this
        if (constructorCodeBlock.initCall != null) {
            visitRealExpression(constructorCodeBlock.initCall, codeBuilder);
        } else {
            // implicit call to no-arg super constructor
            codeBuilder.invokespecial(
                    ClassDesc.ofDescriptor(OBJECT),
                    ConstantDescs.INIT_NAME,
                    MethodTypeDesc.of(ConstantDescs.CD_void));
        }

        // 3) execute late-larval statements
        for (final var lateStatement : constructorCodeBlock.lateLarvalStatements) {
            visitStatement(lateStatement, codeBuilder);
        }

        codeBuilder.return_(); // 4) return
    }

    private static void visitProperty(final @NonNull RealElement propertyElement,
                                      final @NonNull ClassBuilder classBuilder) {
        assert propertyElement != null;
        assert classBuilder != null;

        final var modifiers = computeModifiers(propertyElement.modifiers);
        final var type = computeType(propertyElement);
        assert propertyElement.identifier != null;
        classBuilder.withField(propertyElement.identifier.identifier, type, fieldBuilder -> {
            fieldBuilder.withFlags(modifiers);
            // if an initializer is present and constant, set it here. Else it is set in init or clinit.
            for (final var propChild : propertyElement.children) {
                if (propChild instanceof RealElement propChildElement
                        && propChildElement.elementType == PROPERTY_INITIALIZER
                        && propChildElement.children.getFirst() instanceof ConstantExpression initializerConstExpr) {
                    fieldBuilder.with(ConstantValueAttribute.of(initializerConstExpr.value));
                    break;
                }
            }
        });
    }

    private static void visitFun(final @NonNull RealElement funElement, final @NonNull ClassBuilder classBuilder) {
        assert funElement != null;
        assert classBuilder != null;

        final var paramDescs = new ArrayList<ClassDesc>();
        for (final var funChild : funElement.children) {
            if (funChild instanceof RealElement funChildElement && funChildElement.elementType == PARAMETER) {
                paramDescs.add(computeType(funChildElement));
            }
        }

        final var modifiers = computeModifiers(funElement.modifiers);
        assert funElement.identifier != null;
        classBuilder.withMethodBody(
                funElement.identifier.identifier,
                MethodTypeDesc.of(/* returnDesc */ computeType(funElement), paramDescs),
                modifiers,
                codeBuilder -> {
                    if (!Modifier.isAbstract(modifiers)) {
                        // code block is the last child of a non-abstract function
                        visitCodeBlock((CodeBlock) funElement.children.getLast(), codeBuilder);
                    }
                });
    }

    private static void visitCodeBlock(final @NonNull CodeBlock codeBlock, final @NonNull CodeBuilder codeBuilder) {
        assert codeBlock != null;
        assert codeBuilder != null;

        for (final var statement : codeBlock.statements) {
            visitStatement(statement, codeBuilder);
        }
        // add implicit return unless a previous explicit one was declared (todo).
        codeBuilder.return_();
    }

    private static void visitStatement(final @NonNull Statement statement, final @NonNull CodeBuilder codeBuilder) {
        assert statement != null;
        assert codeBuilder != null;

        switch (statement) {
            case RealStatement realStatement -> visitRealStatement(realStatement, codeBuilder);
            default -> throw new UnsupportedOperationException("Unsupported statement: " + statement);
        }
    }

    private static void visitRealStatement(final @NonNull RealStatement realStatement,
                                           final @NonNull CodeBuilder codeBuilder) {
        assert realStatement != null;
        assert codeBuilder != null;

        for (final var child : realStatement.children) {
            switch (child) {
                case Expression expression -> visitExpression(expression, codeBuilder);
                default -> throw new UnsupportedOperationException("Unsupported realStatement child: " + child);
            }
        }
    }

    private static void visitExpression(final @NonNull Expression expression, final @NonNull CodeBuilder codeBuilder) {
        assert expression != null;
        assert codeBuilder != null;

        switch (expression) {
            case ConstantExpression constantExpression -> visitConstantExpression(constantExpression, codeBuilder);
            case LoadExpression loadExpression -> visitLoadExpression(loadExpression, codeBuilder);
            case RealExpression realExpression -> visitRealExpression(realExpression, codeBuilder);
        }
    }

    private static void visitConstantExpression(final @NonNull ConstantExpression constantExpression,
                                                final @NonNull CodeBuilder codeBuilder) {
        assert constantExpression != null;
        assert codeBuilder != null;

        codeBuilder.loadConstant(constantExpression.value);
    }

    private static void visitLoadExpression(final @NonNull LoadExpression loadExpression,
                                            final @NonNull CodeBuilder codeBuilder) {
        assert loadExpression != null;
        assert codeBuilder != null;

        switch (loadExpression.descriptorString()) {
            case INTEGER -> codeBuilder.iload(loadExpression.slot());
            case LONG -> codeBuilder.lload(loadExpression.slot());
            case FLOAT -> codeBuilder.fload(loadExpression.slot());
            case DOUBLE -> codeBuilder.dload(loadExpression.slot());
            default -> codeBuilder.aload(loadExpression.slot());
        }
    }

    private static void visitRealExpression(final @NonNull RealExpression realExpression,
                                            final @NonNull CodeBuilder codeBuilder) {
        assert realExpression != null;
        assert codeBuilder != null;

        switch (realExpression.type) {
            case ADD -> visitAdditiveExpression(realExpression, codeBuilder);
            case INDEXING -> visitIndexingExpression(realExpression, codeBuilder);
            case VARIABLE_OR_PROP_ACCESS -> visitVariableOrPropAccessExpression(realExpression, codeBuilder);
            case FUN_CALL -> visitFunCallExpression(realExpression, codeBuilder);
            default -> throw new UnsupportedOperationException("Unsupported expression type: " + realExpression.type);
        }
    }

    private static void visitAdditiveExpression(final @NonNull RealExpression additiveExpression,
                                                final @NonNull CodeBuilder codeBuilder) {
        assert additiveExpression != null;
        assert codeBuilder != null;

        final var descriptorString = additiveExpression.descriptorString();
        assert descriptorString != null;

        switch (descriptorString) {
            case STRING -> stringConcatenation(additiveExpression.children, codeBuilder);
            default -> throw new UnsupportedOperationException("Unsupported additive expression for type : " +
                    descriptorString);
        }
    }

    private static void visitIndexingExpression(final @NonNull RealExpression indexingExpression,
                                                final @NonNull CodeBuilder codeBuilder) {
        assert indexingExpression != null;
        assert codeBuilder != null;

        // loop on fun call children: preliminary expressions and index
        for (final var child : indexingExpression.children) {
            switch (child) {
                case LoadExpression loadExpression -> visitLoadExpression(loadExpression, codeBuilder);
                case RealExpression realExpression -> {
                    assert realExpression.type == PROP_ACCESS;
                    visitPropAccess(realExpression, codeBuilder);
                }
                case ConstantExpression constantExpression -> visitConstantExpression(constantExpression, codeBuilder);
                default -> throw new IllegalStateException("Unexpected expression type: " + child.getClass());
            }
        }

        // then load the array
        codeBuilder.aaload();
    }

    private static void visitVariableOrPropAccessExpression(
            final @NonNull RealExpression variableOrPropAccessExpression,
            final @NonNull CodeBuilder codeBuilder
    ) {
        assert variableOrPropAccessExpression != null;
        assert codeBuilder != null;

        // loop on variable or prop access children = one or several chained accesses
        for (final var child : variableOrPropAccessExpression.children) {
            switch (child) {
                case LoadExpression loadExpression -> visitLoadExpression(loadExpression, codeBuilder);
                case RealExpression realExpression -> {
                    assert realExpression.type == PROP_ACCESS;
                    visitPropAccess(realExpression, codeBuilder);
                }
                default -> throw new IllegalStateException("Unexpected expression type: " + child.getClass());
            }
        }
    }

    private static void visitPropAccess(final @NonNull RealExpression propAccessExpression,
                                        final @NonNull CodeBuilder codeBuilder) {
        assert propAccessExpression != null;
        assert codeBuilder != null;

        final var propDescriptorString = propAccessExpression.descriptorString();
        assert propAccessExpression.ownerDescriptorString != null;
        assert propDescriptorString != null;
        assert propAccessExpression.invocation != null;
        assert propAccessExpression.identifiers.size() == 1;

        final var owner = ClassDesc.ofDescriptor(propAccessExpression.ownerDescriptorString);
        final var name = propAccessExpression.identifiers.getFirst().identifier; // a property has a simple identifier
        final var type = ClassDesc.ofDescriptor(propDescriptorString);

        switch (propAccessExpression.invocation) {
            case GET_STATIC -> codeBuilder.getstatic(owner, name, type);
            default -> throw new UnsupportedOperationException(propAccessExpression.invocation +
                    " invocation is not supported yet");
        }
    }

    static void visitFunCallExpression(final @NonNull RealExpression funCallExpression,
                                       final @NonNull CodeBuilder codeBuilder) {
        assert funCallExpression != null;
        assert codeBuilder != null;

        // loop on fun call children: preliminary expressions and parameters, if any
        for (final var childRaw : funCallExpression.children) {
            if (!(childRaw instanceof RealExpression child)) {
                throw new IllegalStateException("Fun call children should be RealExpression, was: " +
                        childRaw.getClass());
            }
            switch (child.type) {
                case PROP_ACCESS -> visitPropAccess(child, codeBuilder);
                case FUN_CALL_PARAMETER -> {
                    assert child.children.size() == 1;
                    visitExpression(child.children.getFirst(), codeBuilder);
                }
                default -> throw new UnsupportedOperationException("Unsupported expression type: " + child.type);
            }
        }

        if (funCallExpression instanceof InvokeDynamicExpression invokeDynamicExpression) {
            invokeDynamic(invokeDynamicExpression, codeBuilder);
        } else {
            invokeNonDynamic(funCallExpression, codeBuilder);
        }
    }

    private static void invokeNonDynamic(final @NonNull RealExpression invokeExpression,
                                         final @NonNull CodeBuilder codeBuilder) {
        assert codeBuilder != null;
        assert invokeExpression != null;
        assert invokeExpression.ownerDescriptorString != null;
        assert invokeExpression.identifiers.size() == 1;
        assert invokeExpression.typeDescriptorString != null;
        assert invokeExpression.invocation != null;

        final var owner = ClassDesc.ofDescriptor(invokeExpression.ownerDescriptorString);
        final var name = invokeExpression.identifiers.getFirst().identifier; // a function has a simple identifier
        final var type = MethodTypeDesc.ofDescriptor(invokeExpression.typeDescriptorString);

        switch (invokeExpression.invocation) {
            case INVOKE_VIRTUAL -> codeBuilder.invokevirtual(owner, name, type);
            default -> throw new UnsupportedOperationException(invokeExpression.invocation +
                    " invocation is not supported yet");
        }
    }

    private static void invokeDynamic(final @NonNull InvokeDynamicExpression invokeDynamicExpression,
                                      final @NonNull CodeBuilder codeBuilder) {
        assert codeBuilder != null;
        assert invokeDynamicExpression != null;
        assert invokeDynamicExpression.identifiers.size() == 1;
        assert invokeDynamicExpression.typeDescriptorString != null;

        // a function has a simple identifier
        final var invocationName = invokeDynamicExpression.identifiers.getFirst().identifier;
        final var invocationType = MethodTypeDesc.ofDescriptor(invokeDynamicExpression.typeDescriptorString);

        // Create the invokedynamic call site descriptor
        final var callSite = DynamicCallSiteDesc.of(
                invokeDynamicExpression.bootstrapMethod,
                invocationName,
                invocationType,
                invokeDynamicExpression.bootstrapArgs.toArray(new ConstantDesc[0])
        );

        codeBuilder.invokedynamic(callSite);
    }

    private static @NonNull ClassDesc computeType(final @NonNull RealElement element) {
        assert element != null;

        final var descriptorString = element.descriptorString();
        return (descriptorString != null) ? ClassDesc.ofDescriptor(descriptorString) : ConstantDescs.CD_void;
    }

    private static int computeModifiers(final @NonNull List<@NonNull ElementModifier> modifiers) {
        assert modifiers != null;

        var visibility = PUBLIC;
        var inheritance = FINAL;
        var isStatic = false;
        for (final var modifier : modifiers) {
            switch (modifier.type) {
                case VISIBILITY -> visibility = modifier.modifier;
                case INHERITANCE -> inheritance = modifier.modifier;
                case MEMBER -> {
                    if (modifier.modifier.equals("static")) {
                        isStatic = true;
                    }
                }
                default -> throw new IllegalStateException("Unknown modifier type: " + modifier.type);
            }
        }

        return modifiers(visibility, inheritance, isStatic);
    }

    private static int modifiers(final @NonNull String visibility,
                                 final @NonNull String inheritance,
                                 final boolean isStatic) {
        assert visibility != null;
        assert inheritance != null;

        final var visibilityFlag = switch (visibility) {
            case "public" -> AccessFlag.PUBLIC;
            case "private" -> AccessFlag.PRIVATE;
            case "protected" -> AccessFlag.PROTECTED;
            default -> throw new IllegalStateException("Unknown visibility: " + visibility);
        };

        final var inheritanceFlag = switch (inheritance) {
            case "final" -> AccessFlag.FINAL;
            case "abstract" -> AccessFlag.ABSTRACT;
            case "open" -> AccessFlag.SUPER;
            default -> throw new IllegalStateException("Unknown inheritance: " + inheritance);
        };

        var modifiers = visibilityFlag.mask() | inheritanceFlag.mask();
        if (isStatic) {
            modifiers |= AccessFlag.STATIC.mask();
        }
        return modifiers;
    }
}
