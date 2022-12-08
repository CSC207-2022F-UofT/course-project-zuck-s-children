package data_persistency;

import account_creation.Account;

import java.io.Serializable;
import java.util.HashMap;

public class UserDatabase implements Serializable {
    private static UserDatabase USERDATABASE;
    public HashMap<String, Account> accounts = new HashMap<>();
    public Account currentUser;

    public static UserDatabase getUserDatabase() {
        if (USERDATABASE == null) {
            USERDATABASE = new UserDatabase();
        }
        return USERDATABASE;
    }
    public static HashMap<String, Account> getAccounts() {
        return USERDATABASE.accounts;
    }

    public Account getCurrentUser() {
        return USERDATABASE.currentUser;
    }
    public static void setCurrentUser(Account currentUser) {
        USERDATABASE.currentUser = currentUser;
    }

    public void setAccounts(HashMap<String, Account> accounts) {
        USERDATABASE.accounts = accounts;
    }
}
