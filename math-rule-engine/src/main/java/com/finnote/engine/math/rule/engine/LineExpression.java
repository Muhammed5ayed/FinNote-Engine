package com.finnote.engine.math.rule.engine;

import org.jetbrains.annotations.NotNull;

public record LineExpression(int indexLine, String expression, Object value) {

    @Override
    public @NotNull String toString() {
        return "index='" + indexLine + '\'' +
                ", expression='" + expression + '\'' +
                ", value=" + value;
    }
}
