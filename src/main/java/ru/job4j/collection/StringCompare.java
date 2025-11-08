package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int minLength = Math.min(left.length(), right.length());
        for (int index = 0; index < minLength; index++) {
            result =  Character.compare(left.charAt(index), right.charAt(index));
            if (result != 0) {
                break;
            }
        }
        result = result == 0 ?  Integer.compare(left.length(), right.length()) : result;
        return result;
    }
}