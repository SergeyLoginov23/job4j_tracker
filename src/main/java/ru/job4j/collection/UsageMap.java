package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("lsa@yandex.ru", "Seregey Loginov");
        map.put("lsa@yandex.ru", "Seregey Loginov");
        map.put("lsa@mail.ru", "Seregey Loginov");
        map.put("lsa@mail.ru", "Seregey Loginov");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
