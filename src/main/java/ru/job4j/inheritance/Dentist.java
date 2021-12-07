package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private boolean doSurgery;

    public Dentist(String name, String surname, String education, String birthday, String major, boolean doSurgery) {
        super(name, surname, education, birthday, major);
        this.doSurgery = doSurgery;
    }

    public boolean isDoSurgery() {
        return doSurgery;
    }
}
