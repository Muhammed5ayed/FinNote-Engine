package com.finnote.engine.parser.antlr.basic;

import org.antlr.v4.runtime.*;

import java.lang.reflect.InvocationTargetException;

public class Antlr {

    public static <E extends Parser> E parser(Class<E> parser, Class<? extends Lexer> lexer, String text) {
        try {
            Lexer l = lexer.getConstructor(CharStream.class).newInstance(CharStreams.fromString(text));
            return parser.getConstructor(TokenStream.class).newInstance(new CommonTokenStream(l));
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
