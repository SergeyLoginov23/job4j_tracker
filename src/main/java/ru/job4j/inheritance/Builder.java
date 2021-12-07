package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String archStyle;

    public Builder(String name, String surname, String education, String birthday, String speciality, String archStyle) {
        super(name, surname, education, birthday, speciality);
        this.archStyle = archStyle;
    }

    public String getAchStyle() {
        return archStyle;
    }
}
