package com.test;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class SupportedFunctionsUtilTest {



    @Test(expected = UnsupportedOperationException.class)
    public void testUnsupportedFunctionFail() {
        Stack<Double> numbers = new Stack<>();
        numbers.push(2d);
        numbers.push(1d);

        SupportedFunctionsUtil.parseAndApplyFunction(numbers, "ln");
    }

    @Test(expected = ArithmeticException.class)
    public void testArithmeticExceptionFail() {
        Stack<Double> numbers = new Stack<>();
        numbers.push(2d);
        numbers.push(0d);

        SupportedFunctionsUtil.parseAndApplyFunction(numbers, "/");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotEnoughArgumentsFail() {
        Stack<Double> numbers = new Stack<>();
        numbers.push(2d);

        SupportedFunctionsUtil.parseAndApplyFunction(numbers, "+");
    }

    @Test
    public void testSumSuccess() {
        Stack<Double> numbers = new Stack<>();
        numbers.push(2d);
        numbers.push(2d);
        assertEquals(
                new Double(4),
                SupportedFunctionsUtil.parseAndApplyFunction(numbers, "+")
        );
    }

}
