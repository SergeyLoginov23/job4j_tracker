package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String programLanguage;

    public Programmer(String name, String surname, String education, String birthday, String speciality, String programLanguage) {
        super(name, surname, education, birthday, speciality);
        this.programLanguage = programLanguage;
    }

    public String getProgramLanguage() {
        return programLanguage;
    }
}
