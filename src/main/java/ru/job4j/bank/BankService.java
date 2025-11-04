package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> listAcc;
        if (user != null) {
            listAcc = users.get(user);
            if (!listAcc.contains(account)) {
                listAcc.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport() == passport) {
                result = user;
                break;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account result = null;
        List<Account> listAcc;
        if (user != null) {
            listAcc = users.get(user);
            for (Account acc : listAcc) {
                if (acc.getRequisite() == requisite) {
                    result = acc;
                    break;
                }
            }
        }
        return result;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAcc = findByRequisite(sourcePassport, sourceRequisite);
        Account destAcc = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAcc != null && destAcc != null && sourceAcc.getBalance() >= amount) {
            sourceAcc.setBalance(sourceAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}