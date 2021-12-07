package ru.job4j.oop;

public class Error {

    private boolean active;

    private int status;

    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void printInfo() {
        System.out.println("Признак активности: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error errorTrue = new Error(true, 1, "Обнаружена ошибка!");
        Error errorFalse = new Error(false, 0, "Ошибки не обнаружено");
        Error errorDefault = new Error();
        errorTrue.printInfo();
        errorFalse.printInfo();
        errorDefault.printInfo();
    }
}
