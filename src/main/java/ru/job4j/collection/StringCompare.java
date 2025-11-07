package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int minLength = left.length() <= right.length() ? left.length() : right.length();
        for (int index = 0; index < minLength; index++) {
            result =  Character.compare((char) left.charAt(index), (char) right.charAt(index));
            if (result != 0) {
                break;
            }
        }
        result = result == 0 ?  Integer.compare(left.length(), right.length()) : result;
        return result;
    }
}