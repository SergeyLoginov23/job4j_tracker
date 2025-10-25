package ru.job4j.oop.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Начинаем движение!");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Максимальная вместимость автобуса " + count + " пассажиров");
    }

    @Override
    public int refuel(int fuel) {
        int price = 50;
        System.out.println("Заправлено  " + fuel + " литров топлива. Сумма заправки " + fuel * price);
        return fuel * price;
    }
}
