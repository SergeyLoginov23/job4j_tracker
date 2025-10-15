package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        Calculator calc = new Calculator();
        return  calc.multiply(a) + calc.divide(a) + sum(a) + minus(a);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        result = calculator.multiply(5);
        System.out.println(result);
        result = calculator.divide(5);
        System.out.println(result);
        result = minus(10);
        System.out.println(result);
        result =  calculator.sumAllOperation(10);
        System.out.println(result);

    }
}