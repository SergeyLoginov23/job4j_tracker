package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String song = "Песня не найдена";
        if (position == 1) {
            song = "Пусть бегут неуклюже";
        } else if (position == 2) {
            song = "Спокойной ночи";
        }
        System.out.println(song);
    }

    public static void main(String[] args) {
        Jukebox songs = new Jukebox();
        songs.music(1);
        songs.music(2);
        songs.music(10);
    }
}
