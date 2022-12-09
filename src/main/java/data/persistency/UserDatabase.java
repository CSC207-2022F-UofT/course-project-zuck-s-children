package data.persistency;

import account_creation.Account;

import java.io.Serializable;
import java.util.HashMap;

public class UserDatabase implements Serializable {
    private static UserDatabase USERDATABASE;
    public HashMap<String, Account> accounts = new HashMap<>();
    public Account currentUser;

    /**
     * Get the singleton instance of the UserDatabase class. If there is none, create one.
     *
     */
    public static UserDatabase getUserDatabase() {
        if (USERDATABASE == null) {
            USERDATABASE = new UserDatabase();
        }
        return USERDATABASE;
    }

    /**
     * Return the accounts attribute of USERDATABASE.
     *
     */
    public HashMap<String, Account> getAccounts() {
        return USERDATABASE.accounts;
    }

    /**
     * Return the current user attribute of USERDATABASE.
     *
     */
    public Account getCurrentUser() {
        return USERDATABASE.currentUser;
    }

    /**
     * Set the current user attribute.
     *
     * @param currentUser the Account entity to be set as the current user.
     */
    public void setCurrentUser(Account currentUser) {
        USERDATABASE.currentUser = currentUser;
    }

    /**
     * Set the accounts attribute.
     *
     * @param accounts the hashmap of Username and Account value for every account in the user database.
     */
    public void setAccounts(HashMap<String, Account> accounts) {
        USERDATABASE.accounts = accounts;
    }
}
