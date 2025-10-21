package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Wolf grey = new Wolf();
        Ball kolob = new Ball();
        Hare coward = new Hare();
        Fox sneaky = new Fox();
        grey.tryEat(kolob);
        coward.tryEat(kolob);
        sneaky.tryEat(kolob);
    }
}
