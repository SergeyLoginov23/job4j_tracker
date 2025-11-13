package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] rightAr = right.split("/");
        String[] leftAr = left.split("/");
        return rightAr[0].compareTo(leftAr[0]) == 0 ? left.compareTo(right) : rightAr[0].compareTo(leftAr[0]);
    }
}