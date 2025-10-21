package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String extraCheese = " extra cheese";
    @Override
    public String name() {
        return  super.name() + extraCheese;
    }
}
