package ru.job4j.polymorphism;

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
        System.out.println("Заправлено  " + fuel + " литров топлива");
        return fuel;
    }
}
