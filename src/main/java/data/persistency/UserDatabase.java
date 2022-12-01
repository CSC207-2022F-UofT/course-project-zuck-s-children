package data.persistency;

import AccountCreation.Account;

import java.io.Serializable;
import java.util.HashMap;

public class UserDatabase implements Serializable, UserDataAccessInterface {
    //TODO: implement UserDataAccessInterface
    private static HashMap<String, Account> accounts;
    private static Account currentUser;

    public UserDatabase() {
        accounts = new HashMap<String, Account>();
    }
    public static HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public static Account getCurrentUser() {
        return currentUser;
    }
    public static void setCurrentUser(Account currentUser) {
        UserDatabase.currentUser = currentUser;
    }

    public static void setAccounts(HashMap<String, Account> accounts) {
        UserDatabase.accounts = accounts;
    }
}
