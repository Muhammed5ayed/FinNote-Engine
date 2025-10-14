package app.MathRuleEngine;

import antlr.ExpLexer;
import antlr.ExpParser;
import antlr.ExpParserBaseVisitor;
import antlr.basic.Antlr;
import app.functions.mathMethod.MathFunctions;
import app.smart.rule.engine.rule.RuleFlowException;
import app.smart.rule.engine.graph.RuleTask;
import app.functions.mathMethod.MathEngineMethod;
import app.functions.mathMethod.MathMethod;
import app.MathRuleEngine.rule.RuleFlowMathEngineMethod;
import app.smart.rule.engine.rule.Rules;
import app.spring.utility.SpringUtilities;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.convert.ConversionService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class MathRuleEngine implements BeanNameAware {

    private final MathParser mathParser = new MathParser();
    private String name;

    public void reset() {
        memory.clear();
        steps.clear();
    }

    public List<LineExpression> processAll(String text) {
        Iterator<LineExpression> process = process(text);
        ArrayList<LineExpression> expressions = new ArrayList<>();
        while (process.hasNext()) {
            try {
                expressions.add(process.next());
            } catch (Exception ignored) {
            }
        }
        return expressions;
    }

    public List<LineExpression> processAllAndForget(String text) {
        Iterator<LineExpression> process = processAndForget(text);
        ArrayList<LineExpression> expressions = new ArrayList<>();
        while (process.hasNext()) {
            try {
                expressions.add(process.next());
            } catch (Exception ignored) {
            }
        }
        return expressions;
    }

    public Iterator<LineExpression> processAndForget(String text) {
        ExpParser parser = Antlr.parser(ExpParser.class, ExpLexer.class, text);
        return mathParser.processAndForget(parser.prog());
    }

    public Iterator<LineExpression> process(String text) {
        ExpParser parser = Antlr.parser(ExpParser.class, ExpLexer.class, text);
        return mathParser.process(parser.prog());
    }

    @Override
    public void setBeanName(@NotNull String name) {
        if (this.name == null)
            this.name = name;
    }


    public MathRuleEngine(ConversionService conversionService) {
        this.conversionService = conversionService;
        this.memory = new HashMap<>();
        this.mathEngineMethod = new MathEngineMethod();
        this.ruleFlowMathEngineMethod = new RuleFlowMathEngineMethod(conversionService, this);
    }

    public MathRuleEngine(ConversionService conversionService, Map<Object, Object> memory, MathEngineMethod mathEngineMethod, RuleFlowMathEngineMethod ruleFlowMathEngineMethod) {
        this.conversionService = conversionService;
        this.memory = Objects.requireNonNullElseGet(memory, ConcurrentHashMap::new);
        this.mathEngineMethod = mathEngineMethod;
        this.ruleFlowMathEngineMethod = ruleFlowMathEngineMethod;
    }

    private final RuleFlowMathEngineMethod ruleFlowMathEngineMethod;

    public RuleFlowMathEngineMethod getRuleFlowMathEngineMethod() {
        return ruleFlowMathEngineMethod;
    }

    private final Map<Object, RuleTask> steps = new ConcurrentHashMap<>();

    public Map<Object, RuleTask> getSteps() {
        return steps;
    }

    private final ConversionService conversionService;

    private final Map<Object, Object> memory;

    public Map<Object, Object> getMemory() {
        return memory;
    }

    private final MathEngineMethod mathEngineMethod;

    public MathEngineMethod getMathEngineMethod() {
        return mathEngineMethod;
    }

    public ConversionService getConversionService() {
        return conversionService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private class MathParser extends ExpParserBaseVisitor<Object> {
        private boolean trace = true;

        private ParserRuleContext parserRuleContext;

        public Iterator<LineExpression> processAndForget(ExpParser.ProgContext ctx) {
            return new Iterator<>() {
                int index = 0;

                Map<Object, Object> cloneMemory = new HashMap<>(getMemory());
                Map<Object, RuleTask> cloneSteps = new HashMap<>(getSteps());
                final List<ExpParser.LineContext> lines = ctx.line();

                @Override
                public boolean hasNext() {
                    if (index < lines.size()) {
                        return true;
                    } else {
                        if (cloneMemory != null) {
                            getMemory().clear();
                            getMemory().putAll(cloneMemory);
                            cloneMemory = null;
                        }
                        if (cloneSteps != null) {
                            getSteps().clear();
                            getSteps().putAll(cloneSteps);
                            cloneSteps = null;
                        }
                        return false;
                    }
                }

                @Override
                public LineExpression next() {
                    ExpParser.LineContext lineContext = lines.get(index++);
                    Object value = visitLine(lineContext);
                    LineExpression lineExpression = new LineExpression(index - 1, lineContext.getText(), value);
                    if (!hasNext()) {
                        return null;
                    }
                    return lineExpression;
                }
            };
        }

        public Iterator<LineExpression> process(ExpParser.ProgContext ctx) {
            return new Iterator<>() {
                int index = 0;
                final List<ExpParser.LineContext> lines = ctx.line();

                @Override
                public boolean hasNext() {
                    return index < lines.size();
                }

                @Override
                public LineExpression next() {
                    ExpParser.LineContext lineContext = lines.get(index++);
                    Object value = visitLine(lineContext);
                    return new LineExpression(index - 1, lineContext.getText(), value);
                }
            };
        }

        @Override
        public Iterator<LineExpression> visitProg(ExpParser.ProgContext ctx) {
            return process(ctx);
        }

        @Override
        public Object visitLine(ExpParser.LineContext ctx) {
            setTextCatch(ctx);
            return super.visitLine(ctx);
        }

        @Override
        public Object visitSave_var(ExpParser.Save_varContext ctx) {
            setTextCatch(ctx);
            String name = ctx.LABEL().getText();
            if (ctx.FIND() != null) {
                getMemory().remove(name);
                saveVar(name, getLabel(name));
                return getMemory().get(name);
            }
            if (ctx.expersion() != null) {
                return saveVar(name, visitExpersion(ctx.expersion()));
            }
            if (ctx.call_Method() != null) {
                return saveVar(name, visitCall_Method(ctx.call_Method()));
            }
            return super.visitSave_var(ctx);
        }

        @Override
        public Object visitCall_Method(ExpParser.Call_MethodContext ctx) {
            setTextCatch(ctx);
            String name = ctx.LABEL().getText();
            List<ExpParser.ExpersionContext> expersion = ctx.expersion();
            ArrayList<Object> list = new ArrayList<>(expersion.size());
            for (ExpParser.ExpersionContext expersionContext : expersion) {
                list.add(visitExpersion(expersionContext));
            }
            return callMethod(name, list);
        }

        @Override
        public Object visitExpersion(ExpParser.ExpersionContext ctx) {
            setTextCatch(ctx);

            if (ctx.VALUE_VAR() != null) {
                Object valueVar = getValueVar(ctx.VALUE_VAR().getText());
                if (ctx.MINUS() != null) {
                    if (isNumber(valueVar.toString())) {
                        return convert(valueVar, BigDecimal.class).negate();
                    } else {
                        // Todo
                        // قيمة المتغير لا يمكن تحويلها الى رقم لإتمام عملية التحويل الى سالب
                        throw new RuntimeException();
                    }
                }
                return valueVar;
            }
            if (ctx.NUMBER() != null) {
                BigDecimal bigDecimal = new BigDecimal(ctx.NUMBER().getText());
                if (ctx.MINUS() != null) bigDecimal = bigDecimal.negate();
                return bigDecimal;
            }
            if (ctx.LABEL() != null) {
                Object label = getLabel(ctx.getText());
                if (ctx.MINUS() != null) {
                    if (isNumber(label.toString())) {
                        return convert(label, BigDecimal.class).negate();
                    } else {
                        // Todo
                        // قيمة المتغير لا يمكن تحويلها الى رقم لإتمام عملية التحويل الى سالب
                        throw new RuntimeException();
                    }
                }
                return label;
            }
            if (ctx.STRING() != null) {
                String text = ctx.STRING().getText();
                return text.substring(1, text.length() - 1);
            }

            if (ctx.left != null && ctx.right != null && ctx.op != null) {
                Object a = visitExpersion(ctx.left);
                if (a == null) {
                    // TODO
                    throw new RuntimeException();
                }
                Object b = visitExpersion(ctx.right);
                if (b == null) {
                    // TODO
                    throw new RuntimeException();
                }
                switch (ctx.op.getText()) {
                    case "+":
                        return add(a, b);
                    case "-":
                        return minus(a, b);
                    case "*":
                        return multiply(a, b);
                    case "/":
                        return divide(a, b);
                    case "^":
                        return pow(a, b);
                }
            }

            if (ctx.BEGINGROUB() != null && ctx.ENDGROUB() != null) {
                return visitExpersion(ctx.expersion(0));
            }

            if (ctx.call_Method() != null) {
                return visitCall_Method(ctx.call_Method());
            }
            return super.visitExpersion(ctx);
        }

        protected @Unmodifiable Object add(Object a, Object b) {
            if (a instanceof String && b instanceof String)
                return a.toString() + b;
            BigDecimal number1 = convert(a, BigDecimal.class);
            BigDecimal number2 = convert(b, BigDecimal.class);
            return number1.add(number2);
        }

        protected @Unmodifiable Object minus(Object a, Object b) {
            BigDecimal number1 = convert(a, BigDecimal.class);
            BigDecimal number2 = convert(b, BigDecimal.class);
            return number1.add(number2.negate());
        }

        protected @Unmodifiable Object multiply(Object a, Object b) {
            BigDecimal number1 = convert(a, BigDecimal.class);
            BigDecimal number2 = convert(b, BigDecimal.class);
            return number1.multiply(number2, MathContext.DECIMAL32);
        }

        protected @Unmodifiable Object divide(Object a, Object b) {
            BigDecimal number1 = convert(a, BigDecimal.class);
            BigDecimal number2 = convert(b, BigDecimal.class);
            return number1.divide(number2, MathContext.DECIMAL32);
        }

        protected Object pow(Object a, Object b) {
            double number1 = convert(a, Double.class);
            double number2 = convert(b, Double.class);
            return Math.pow(number1, number2);
        }

        private Object getValueVar(String name) {
            return memory.get(name);
        }

        protected Object getLabel(String name) {
            if (!getMemory().containsKey(name)) {
                try {
                    return ruleFlowMathEngineMethod.call(getMemory(), name);
                } catch (RuleFlowException e) {
                    throw new RuntimeException(e);
                }
            }
            return memory.get(name);
        }

        protected <E> E convert(Object value, Class<E> type) {
            if (value == null || type == null) {
                // Todo مشكلة فى التحويل
                throw new RuntimeException();
            }

            if (!conversionService.canConvert(value.getClass(), type)) {
                throw new RuntimeException();
            }
            return conversionService.convert(value, type);
        }

        protected Object callMethod(String name, @NotNull List<Object> list) {
            Object[] parameters = list.toArray(new Object[0]);
            MathMethod mathMethod = mathEngineMethod.get(name, parameters, conversionService);
            if (mathMethod == null) {
                throw new RuntimeException();
            }
            Object invoke = mathMethod.invoke(parameters, conversionService);
            if (mathMethod.getMethod().getReturnType() == void.class)
                return Solver.Void;
            return invoke;
        }

        protected Solver saveVar(String name, Object value) {
            memory.put(name, value);
            return Solver.Save;
        }

        public String getTextCatch() {
            return parserRuleContext.getText();
        }

        public ParserRuleContext getParserRuleContext() {
            return parserRuleContext;
        }

        void setTextCatch(ParserRuleContext parserRuleContext) {
            this.parserRuleContext = parserRuleContext;
            if (trace) {
                // Todo
            }
        }


        public int getStartTextCatch() {
            return parserRuleContext.getStart().getStartIndex();
        }

        public int getEndTextCatch() {
            return parserRuleContext.getStop().getStartIndex();
        }

        public boolean isNumber(String text) {
            return Pattern.matches("-?\\d+([.]\\d*)?", text);
        }
    }

    public enum Solver {
        Save, Void
    }

    public void init(ConfigurableListableBeanFactory context, String name) {
        try {
            if (context.getBean(name) == this) {
                String packagePath = SpringUtilities.getPackage(name, context);
                getMathEngineMethod().init(context, name, SpringUtilities.getAnnotation(MathFunctions.class, this, context.getBeanDefinition(name)) == null ? null : packagePath);
                getRuleFlowMathEngineMethod().init(context, name, SpringUtilities.getAnnotation(Rules.class, this, context.getBeanDefinition(name)) == null ? null : packagePath);
            }else {
                getMathEngineMethod().init(context, name, null);
                getRuleFlowMathEngineMethod().init(context, name, null);
            }
        } catch (Exception e) {
            getMathEngineMethod().init(context, name, null);
            getRuleFlowMathEngineMethod().init(context, name, null);
        }
    }
}
