package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;

public class SupportedFunctionsUtil {

    private static final Map supportedFunctions = new HashMap() {{
        put("+", calcSum());
        put("-", calcDiff());
        put("*", calcMult());
        put("/", calcDiv());
        put("sqrt", calcSqrt());

    }};

    public static Double parseAndApplyFunction(Stack<Double> numbers, String userFunction) {
        Object function = supportedFunctions.get(userFunction);
        if (function == null) {
            throw new UnsupportedOperationException("This function is not supported yet. List of supported operations: +, -, *, /");
        }

        if (function instanceof BiFunction) {
            return applyBiFunction(numbers, (BiFunction<Double, Double, Double>) function);
        } else {
            return applyFunction(numbers, (Function<Double, Double>) function);
        }
    }

    private static Double applyFunction(Stack<Double> numbers, Function<Double, Double> function) {
        if (numbers.size() < 1) {
            throw new IllegalArgumentException("Not enough numbers to proceed");
        }
        return function.apply(numbers.pop());
    }

    private static Double applyBiFunction(Stack<Double> numbers, BiFunction<Double, Double, Double> function) {
        if (numbers.size() < 2) {
            throw new IllegalArgumentException("Not enough numbers to proceed");
        }
        return function.apply(numbers.pop(), numbers.pop());
    }

    private static BiFunction<Double, Double, Double> calcSum() {
        return (n1, n2) -> n2 + n1;
    }

    private static BiFunction<Double, Double, Double> calcDiff() {
        return (n1, n2) -> n2 - n1;
    }

    private static BiFunction<Double, Double, Double> calcMult() {
        return (n1, n2) -> n2 * n1;
    }

    private static BiFunction<Double, Double, Double> calcDiv() {
        return (n1, n2) -> {
            if (n1 == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return n2 / n1;
        };
    }

    private static Function<Double, Double> calcSqrt() {
        return Math::sqrt;
    }

}
