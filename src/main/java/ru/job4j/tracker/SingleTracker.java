package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {

    private static SingleTracker instance = null;

    private SingleTracker() {
    }

    private MemTracker memTracker = new MemTracker();

    public Item add(Item item) {
        return memTracker.add(item);
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public void delete(int id) {
        memTracker.delete(id);
    }

    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    public List<Item> findAll() {
        return memTracker.findAll();
    }

    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

   }