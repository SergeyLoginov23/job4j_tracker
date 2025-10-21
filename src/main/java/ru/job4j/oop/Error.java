package ru.job4j.oop;

public class Error  {
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

     public static void main(String[] args) {
       Error error  = new Error();
       Error error2 = new Error(true, 1, "Синтаксическая ошибка");
       error.printInfo();
       error2.printInfo();
     }

    public void printInfo() {
        System.out.println("Активна ли ошибка: " + active);
        System.out.println("Статус " + status);
        System.out.println("Сообщение " + message);
    }
}
