package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return x / a;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        int resultSum = Calculator.sum(10);
        System.out.println("Результат суммирования равен " + resultSum);
        Calculator calculator = new Calculator();
        int rslMulti = calculator.multiply(5);
        System.out.println("Результат умножения равен " + rslMulti);
        int resultMinus = Calculator.minus(10);
        System.out.println("Результат вычитания равен " + resultMinus);
        int rslDiv = calculator.divide(5);
        System.out.println("Результат деления равен " + rslDiv);
        int rslTotal = calculator.sumAllOperation(5);
        System.out.println("Результат суммирования всех операций равен " + rslTotal);

    }
}