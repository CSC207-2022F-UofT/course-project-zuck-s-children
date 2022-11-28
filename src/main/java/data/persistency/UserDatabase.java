package data.persistency;

import AccountCreation.Account;

import java.io.Serializable;
import java.util.HashMap;

public class UserDatabase implements Serializable {

    private static HashMap<String, Account> Accounts;
    private static Account currentUser;

    public UserDatabase() {
        Accounts = new HashMap<String, Account>();
    }
    public static HashMap<String, Account> getAccounts() {
        return Accounts;
    }

    public static Account getCurrentUser() {
        return currentUser;
    }
    public static void setCurrentUser(Account currentUser) {
        UserDatabase.currentUser = currentUser;
    }
}
