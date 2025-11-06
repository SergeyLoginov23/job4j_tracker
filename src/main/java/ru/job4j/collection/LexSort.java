package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftAr = left.split("\\.");
        String[] rightAr = right.split("\\.");
        Integer leftNum = Integer.parseInt(leftAr[0]);
        Integer rightNum = Integer.parseInt(rightAr[0]);
        return Integer.compare(leftNum, rightNum);
    }
}