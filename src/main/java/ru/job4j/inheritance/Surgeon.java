package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private boolean avaliable;

    public Surgeon(String name, String surname, String education, String birthday, String major, boolean avaliable) {
        super(name, surname, education, birthday, major);
        this.avaliable = avaliable;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

}
