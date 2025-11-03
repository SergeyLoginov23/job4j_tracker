package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String result = queue.poll().name();
        for (int index = 1; index < count; index++) {
            result = queue.poll().name();
        }
        return result;
    }

    public String getFirstUpsetCustomer() {
        String result = queue.poll().name();
        for (int index = 1; index <= count; index++) {
            result = queue.poll().name();
        }
        return result;
    }
}