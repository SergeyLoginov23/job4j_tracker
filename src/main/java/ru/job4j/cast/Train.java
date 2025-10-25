package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по рельсам");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " тип топлива: уголь");
    }
}
