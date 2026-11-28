/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.Identifier;
import org.oolang.ast.Identifier.SimpleIdentifier;
import org.oolang.ast.expression.Expression;
import org.oolang.ast.expression.RealExpression;
import org.oolang.ast.statement.RealStatement;

import java.util.Collection;
import java.util.List;

import static org.oolang.ast.expression.ExpressionUtils.addExpressionToChain;
import static org.oolang.ast.expression.RealExpression.ExpressionType.*;
import static org.oolang.ast.statement.RealStatement.StatementType.ASSIGNMENT;

public final class SemanticAnalysisUtils {
    // un-instantiable
    private SemanticAnalysisUtils() {
    }

    public static final @NonNull SimpleIdentifier THIS_IDENTIFIER = new Identifier.SimpleIdentifier("this");

    public static boolean compatibleParameters(final @NonNull Function candidateFunction,
                                               final @NonNull List<@NonNull ActualType> parameterTypes) {
        assert candidateFunction != null;
        assert parameterTypes != null;

        // fail-fast if candidate function has wrong number of parameters
        if (candidateFunction.parameters.size() != parameterTypes.size()) {
            return false;
        }

        for (var i = 0; i < candidateFunction.parameters.size(); i++) {
            if (!candidateFunction.parameters.get(i).type().isAssignableFrom(parameterTypes.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasAssignableParent(final @NonNull Collection<@NonNull ActualType> parents,
                                              final @NonNull Klass otherKlass) {
        assert parents != null;
        assert otherKlass != null;

        return parents.stream()
                .map(TypeResolver::getKlassFromType)
                .anyMatch(superType -> superType.descriptorString().equals(otherKlass.descriptorString()));
    }

    public static @NonNull RealStatement propAssignment(final @NonNull String name) {
        final var variableChainableExpression = new RealExpression(CHAINABLE);
        final var variableExpression = new RealExpression(VARIABLE_OR_PROP_ACCESS);
        variableExpression.identifiers.add(new Identifier.SimpleIdentifier(name));
        addExpressionToChain(variableChainableExpression, variableExpression);
        return propAssignment(name, variableChainableExpression);
    }

    public static @NonNull RealStatement propAssignment(final @NonNull String name,
                                                        final @NonNull Expression valueExpression) {
        assert name != null;

        final var assignmentChainableExpression = new RealExpression(CHAINABLE);
        final var assignmentExpression = new RealExpression(VARIABLE_OR_PROP_ASSIGNMENT);
        assignmentExpression.identifiers.add(THIS_IDENTIFIER);
        assignmentExpression.identifiers.add(new Identifier.SimpleIdentifier(name));
        addExpressionToChain(assignmentChainableExpression, assignmentExpression);

        assignmentExpression.children.add(valueExpression);

        final var assignment = new RealStatement(ASSIGNMENT);
        assignment.children.add(assignmentChainableExpression);
        return assignment;
    }
}
