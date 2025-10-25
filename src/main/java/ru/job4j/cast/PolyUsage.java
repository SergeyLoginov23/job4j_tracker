package ru.job4j.cast;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle boing = new Plane();
        Vehicle sukhoy = new Plane();
        Vehicle piko = new Train();
        Vehicle roco = new Train();
        Vehicle mersedes = new Bus();
        Vehicle man = new Bus();

        Vehicle[] vechicles = new Vehicle[]{boing, sukhoy, piko, roco, mersedes, man};
        for (Vehicle object : vechicles) {
            object.move();
            object.fuel();
        }
    }
}