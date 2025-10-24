package com.finnote.engine.math.rule.engine.AutoCompletion;


import com.finnote.engine.parser.antlr.ExpLexer;
import com.finnote.engine.parser.antlr.ExpParser;
import com.finnote.engine.parser.antlr.ExpParserBaseVisitor;
import com.finnote.engine.parser.antlr.basic.Antlr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ScanLabel extends ExpParserBaseVisitor<Object> {

    private ScanLabel() {
    }

    private Map<String, String> map;

    @Override
    public ArrayList<String> visitProg(ExpParser.ProgContext ctx) {
        map = new HashMap<>();
        super.visitProg(ctx);
        ArrayList<String> list = new ArrayList<>();
        map.forEach((s, s2) -> {
            if (s2 == null)
                list.add(s);
        });
        return list;
    }

    @Override
    public Object visitSave_var(ExpParser.Save_varContext ctx) {
        String label = ctx.LABEL().getText();
        if (ctx.expersion() != null) {
            map.put(label, label);
            return visitExpersion(ctx.expersion());
        }
        if (ctx.call_Method() != null) {
            map.put(label, label);
            return visitCall_Method(ctx.call_Method());
        }
        return null;
    }


    @Override
    public Object visitExpersion(ExpParser.ExpersionContext ctx) {


        if (ctx.call_Method() != null) {
            return visitCall_Method(ctx.call_Method());
        }

        if (ctx.LABEL() != null) {
            String label = ctx.LABEL().getText();
            if (ctx.getParent().getClass() == ExpParser.LineContext.class)
                return null;
            if (!map.containsKey(label)) {
                map.put(label, null);
                return null;
            }
        }
        if (ctx.expersion() != null) {
            for (ExpParser.ExpersionContext expersion : ctx.expersion()) {
                visitExpersion(expersion);
            }
        }
        return null;
    }

    public static ArrayList<String> getVars(String text) {
        ScanLabel scan = new ScanLabel();
        ExpParser parser = Antlr.parser(ExpParser.class, ExpLexer.class, text);
//        System.out.println(parser.prog().toStringTree());
        return scan.visitProg(parser.prog());
    }
}