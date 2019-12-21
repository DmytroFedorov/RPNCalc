package com.test;

import java.util.Stack;


public class AppRunner {


    public static void main(String[] args) {
        System.out.println("RPN Calc is running. Waiting for input...");
        final Stack<Double> numbers = new Stack<>();
        final DataSource dataSource = new DataSource(System.in);

        while (true) {
            String input = dataSource.getInput();
            Double result;
            if (isEndSymbol(input)) {
                System.exit(0);
            }

            if (isDigit(input)) {
                result = Double.parseDouble(input);
            } else {
                try {
                    result = SupportedFunctionsUtil.parseAndApplyFunction(
                            numbers,
                            input
                    );
                } catch (UnsupportedOperationException | IllegalArgumentException | ArithmeticException e) {
                    System.out.println(e.getMessage());
                    continue;
                }

            }
            System.out.println(">" + numbers.push(result));
        }
    }


    private static boolean isDigit(String input) {
        return input.matches("^(-?)\\d+(\\.\\d+)?$");
    }

    private static boolean isEndSymbol(String input) {
        return input.equalsIgnoreCase("q");
    }

}
