package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String extra_chesee = " extra cheese";

    @Override
    public String name() {
        return  super.name() + extra_chesee;
    }
}
