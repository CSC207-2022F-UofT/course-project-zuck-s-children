package data.persistency;

import AccountCreation.Account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class UserDatabase implements Serializable {

    private static HashMap<String, Account> Accounts;

    public UserDatabase() {
        Accounts = new HashMap<String, Account>();
    }


    public static HashMap<String, Account> getAccounts() {
        return Accounts;
    }
}
