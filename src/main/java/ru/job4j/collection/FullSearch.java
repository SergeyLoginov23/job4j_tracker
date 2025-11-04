package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {

    public Set<String> extractNumber(List<Task> tasks) {
        HashSet<String> tasksNoDouble = new HashSet<>();
        for (Task task : tasks) {
            tasksNoDouble.add(task.getNumber());
        }
        return tasksNoDouble;
    }
}