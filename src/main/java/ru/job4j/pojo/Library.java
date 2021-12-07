package ru.job4j.pojo;

public class Library {
    public static void printAllLib(Book[] lib) {
        for (int index = 0; index < lib.length; index++) {
            Book bk = lib[index];
            System.out.println(bk.getName() + " - " + bk.getPagesNumber());
        }
    }

    public static void printBookNamed(Book[] lib, String name) {
        for (int index = 0; index < lib.length; index++) {
            if (lib[index].getName().equals(name)) {
                Book bk = lib[index];
                System.out.println(bk.getName() + " - " + bk.getPagesNumber());
            }
        }
    }

    public static void main(String[] args) {
        Book wap = new Book("War and Peace", 1000);
        Book cap = new Book("Crime and Punishment", 400);
        Book c22 = new Book("Catch 22", 190);
        Book cc = new Book("Clean code", 55);
        Book[] lib = new Book[4];
        lib[0] = wap;
        lib[1] = cap;
        lib[2] = c22;
        lib[3] = cc;
        printAllLib(lib);
        Book temp = lib[0];
        lib[0] = lib[3];
        lib[3] = temp;
        printAllLib(lib);
        printBookNamed(lib, "Clean code");
    }
}
