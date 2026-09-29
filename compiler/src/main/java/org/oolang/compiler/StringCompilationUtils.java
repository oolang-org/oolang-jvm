/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.compiler;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.expression.ConstantExpression;
import org.oolang.ast.expression.Expression;
import org.oolang.ast.expression.RealExpression;

import java.lang.classfile.CodeBuilder;
import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDescs;
import java.lang.constant.DirectMethodHandleDesc;
import java.lang.invoke.StringConcatFactory;
import java.util.List;
import java.util.StringJoiner;

import static org.oolang.ast.Identifier.SimpleIdentifier;
import static org.oolang.ast.expression.RealExpression.ExpressionType.FUN_CALL_PARAMETER;
import static org.oolang.compiler.Descriptors.STRING;

final class StringCompilationUtils {
    // un-instantiable
    private StringCompilationUtils() {
    }

    private static final @NonNull String STRING_CONCAT_INVOCATION_NAME = "jvmDynamicStringConcat";
    private static final @NonNull String CONCAT_RECIPE_PLACEHOLDER = "\u0001";
    private static final @NonNull DirectMethodHandleDesc STRING_CONCAT_BOOTSTRAP_METHOD =
            ConstantDescs.ofCallsiteBootstrap(
                    ClassDesc.of(StringConcatFactory.class.getName()),
                    "makeConcatWithConstants",
                    ClassDesc.of("java.lang.invoke.CallSite"),
                    ConstantDescs.CD_String,
                    ConstantDescs.CD_Object.arrayType()
            );

    /**
     * Transform a string concatenation of several expressions into a dynamic function call of
     * {@link StringConcatFactory#makeConcatWithConstants}.
     *
     * @see <a href="https://www.baeldung.com/java-string-concatenation-invoke-dynamic">string-concatenation</a>
     */
    static void stringConcatenation(final @NonNull List<@NonNull Expression> children,
                                    final @NonNull CodeBuilder codeBuilder) {
        assert children != null;
        assert codeBuilder != null;

        // the concatenation becomes an invokedynamic function call
        final var dynamicFunctionCall = new InvokeDynamicExpression(STRING_CONCAT_BOOTSTRAP_METHOD);

        // loop on children
        // - constant strings are included in the recipe string
        // - other concat arguments are transformed into function call parameters
        final var recipeString = new StringBuilder();
        final var typeDescriptorBuilder = new StringJoiner(
                /*delimiter*/ "",
                /*prefix*/ "(",
                /*suffix*/ ")" + STRING);

        for (final var child : children) {
            if (child instanceof ConstantExpression constant) {
                recipeString.append(constant.value);
            } else {
                // current child expression is nested in a function call parameter expression
                final var funCallParameter = new RealExpression(FUN_CALL_PARAMETER);
                funCallParameter.children.add(child);
                dynamicFunctionCall.children.add(funCallParameter);
                typeDescriptorBuilder.add(child.descriptorString());
                recipeString.append(CONCAT_RECIPE_PLACEHOLDER);
            }
        }

        dynamicFunctionCall.setDescriptorString(STRING);
        dynamicFunctionCall.identifiers.add(new SimpleIdentifier(STRING_CONCAT_INVOCATION_NAME));
        dynamicFunctionCall.typeDescriptorString = typeDescriptorBuilder.toString();
        dynamicFunctionCall.bootstrapArgs.add(recipeString.toString());

        OolangCompiler.visitFunCallExpression(dynamicFunctionCall, codeBuilder);
    }
}
