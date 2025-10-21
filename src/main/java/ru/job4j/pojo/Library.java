package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book WarAndPeace = new Book("War and Pease", 10);
        Book CleanCode = new Book("Clean code", 4);
        Book Idiot = new Book("Idiot", 19);
        Book Ktm = new Book("Kill the mockingBird", 100);
        Book[] books = new Book[4];
        books[0] = WarAndPeace;
        books[1] = CleanCode;
        books[2] = Idiot;
        books[3] = Ktm;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPagesCount());
        }
        System.out.println("=Change 0 to 3=");
        books[0] = Ktm;
        books[3] = WarAndPeace;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPagesCount());
        }
        System.out.println("=Show Clean code=");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getPagesCount());
            }
        }
    }
}
