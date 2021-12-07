package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Логинов Сергей Анатольевич");
        student.setGroup("ММ - 101");
        student.setEnterDate(new Date());
        System.out.println(student.getFullName() + " учится в группе - "
                + student.getGroup() + ", начиная с " + student.getEnterDate());
    }
}
