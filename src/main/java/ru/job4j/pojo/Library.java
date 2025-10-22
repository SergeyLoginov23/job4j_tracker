package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book warAndPeace = new Book("War and Pease", 10);
        Book cleanCode = new Book("Clean code", 4);
        Book idiot = new Book("Idiot", 19);
        Book ktm = new Book("Kill the mockingBird", 100);
        Book[] books = new Book[4];
        books[0] = warAndPeace;
        books[1] = cleanCode;
        books[2] = idiot;
        books[3] = ktm;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPagesCount());
        }
        System.out.println("=Change 0 to 3=");
        books[0] = ktm;
        books[3] = warAndPeace;
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
