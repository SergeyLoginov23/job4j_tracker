package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (int index = 0; index < users.length; index++) {
            User user = users[index];
            if (user.getUsername().equals(login)) {
                result = user;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("UserNotFound");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean result = true;
        if (user == null || user.getUsername().length() < 3) {
            throw new UserInvalidException("UserIsInvalid");
        }
        return result;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ea) {
            System.out.println("UserIsInvalid");
        } catch (UserNotFoundException en) {
            System.out.println("UserNotFound");
        }
    }
    }