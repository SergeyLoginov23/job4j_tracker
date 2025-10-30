package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        Airbus airbusA320 = new Airbus("A320");
        airbusA320.setName("A320");
        System.out.println(airbusA320);
        airbusA320.printModel();
        airbusA320.printCountEngine();

        Airbus airbusA380 = new Airbus("A380");
        System.out.println(airbusA380);

        airbusA380.setName("A380");
        System.out.println(airbusA380);
        airbusA380.printCountEngine();
    }
}