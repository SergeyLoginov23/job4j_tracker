package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private static final String extra_tomato = " extra tomato";

    @Override
    public String name() {
        return super.name() + extra_tomato;
    }
}
