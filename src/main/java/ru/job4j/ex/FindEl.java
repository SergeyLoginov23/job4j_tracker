package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int index = 0; index < value.length; index++) {
            String element = value[index];
            if (element.equals(key)) {
                result = index;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("ElementNotFound");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] value = {"Name1", "Name2"};
        String key = "Name3";
        try {
            indexOf(value, key);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}