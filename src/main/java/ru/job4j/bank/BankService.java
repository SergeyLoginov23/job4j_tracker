package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.*;

/**
 * Класс описывает простую модель банковского сервиса, которая умеет регистрировать клиентов,
 * открывать им счета и переводить деньги, а также осуществлять поиск счетов и клиентов в своей системе
 * @author Sergey Loginov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в систему, если такого пользователя еще нет.
     * @param user пользователь, который будет добавлен
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход паспортные данные пользователя и
     * удаляет его из системы, если он там есть
     * @param passport паспортные данные, по которым происходит поиск
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает на вход паспортные данные пользователя и счет и добавляет счет для пользователя,
     * найденного по указанным паспортным данным.
     * @param passport паспортные данные, по которым происходит поиск
     * @param account счет, который необходимо добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> listAcc = users.get(user);
            if (!listAcc.contains(account)) {
                listAcc.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход паспортные данные пользователя и осуществляет поиск его в системе.
     * @param passport паспортные данные, по которым происходит поиск
     * @return user возвращает пользователя, если таковой найден
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод принимает на вход паспортные данные пользователя и реквизиты счета и осуществляет поиск счета
     * для клиента, найденного по паспортным данным.
     * @param passport  паспортные данные, по которым происходит поиск
     * @param requisite реквизиты счета, по которым происходит поиск
     * @return Account возвращает счет, если таковой найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account result = null;
        if (user != null) {
            List<Account> listAcc = users.get(user);
            for (Account acc : listAcc) {
                if (acc.getRequisite().equals(requisite)) {
                    result = acc;
                    break;
                }
            }
        }
        return result;
    }

    /** Метод принимает на вход 2 набора паспортных данных и реквизтов счетов (по счету для списания и получения
     * денежных средств), а также сумму перевода. Осуществляет поиск обоих счетов и если таковые найдены, а также баланс
     * на счете списания больше, чем сумма перевода, осуществляет перевод денежных средств.
     * @param sourcePassport паспортные данные, по которым происходит поиск плательщика
     * @param sourceRequisite реквизиты счета, по которым происходит поиск счета для списания
     * @param destinationPassport паспортные данные, по которым происходит поиск получателя
     * @param destinationRequisite реквизиты счета, по которым происходит поиск счета для получения
     * @param amount сумма перевода
     * @return если перевод успешен, возвращает true, иначе false
     */
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