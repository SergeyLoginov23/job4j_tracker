package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    private int compareString(String longer, String shorter) {
        int result = 0;
        for (int index = 0; index < shorter.length(); index++) {
            result =  Character.compare((char) longer.charAt(index), (char) shorter.charAt(index));
            if (result != 0) {
                break;
            }
        }
        return result;
    }

    @Override
    public int compare(String left, String right) {
        int result = 0;
        if (left.length() >= right.length()) {
            result = compareString(left, right);
            result = result == 0 ? right.length() - left.length() : result;
        } else {
            result = compareString(right, left) * (-1);
            result = result == 0 ? left.length() - right.length() : result;

        }
        return result;
    }
}