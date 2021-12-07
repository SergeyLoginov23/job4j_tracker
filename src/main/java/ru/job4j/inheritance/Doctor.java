package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String major;

    public Doctor(String name, String surname, String education, String birthday, String major) {
        super(name, surname, education, birthday);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }
}
