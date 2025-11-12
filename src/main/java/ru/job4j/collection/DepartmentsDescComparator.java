package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int counter = 0;
        int result = 0;
        String[] rightAr = right.split("/");
        for (String element : left.split("/")) {
            if (counter == 0) {
                result = rightAr[counter].compareTo(element);
            } else {
                if (result == 0 && counter >= rightAr.length) {
                    result = 1;
                } else {
                    result = element.compareTo(rightAr[counter]);
                }
            }
            if (result != 0) {
                break;
            }
            counter++;
        }
        if (result == 0 && counter < rightAr.length) {
            result = -1;
        }
        return  result;
    }
}