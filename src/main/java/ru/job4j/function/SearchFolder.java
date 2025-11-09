package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public boolean getSize(Folder folder) {
        return check((str -> folder.getSize() > 100), folder);
    }

    public boolean getName(Folder folder) {
        return check((str -> folder.getName().contains("bug")), folder);
    }

    public boolean check(Predicate<Folder> predicate, Folder folder) {
        return predicate.test(folder);
    }

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> predicate) {
        List<Folder> result = new ArrayList<>();
        for (Folder folder : list) {
            if (predicate.test(folder)) {
                result.add(folder);
            }
        }
        return result;
    }
}