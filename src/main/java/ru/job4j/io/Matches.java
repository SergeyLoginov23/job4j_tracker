package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            System.out.println("Осталось спичек " + count);
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches >= 1 && matches <= 3) {
                if (matches <= count) {
                    count = count - matches;
                } else {
                    System.out.println("Ошибочный ввод! Нельзя забирать больше спичек, чем осталось! " + player + " Повторите попытку");
                    turn = !turn;
                }
            } else {
                System.out.println("Ошибочный ввод! " + player + " введите число от 1 до 3:");
                turn = !turn;
            }
                turn = !turn;
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}