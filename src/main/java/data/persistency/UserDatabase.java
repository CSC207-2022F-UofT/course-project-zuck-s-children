package data.persistency;

import AccountCreation.Account;

import java.io.Serializable;
import java.util.ArrayList;

public class UserDatabase implements Serializable {

    private ArrayList<Account> listOfAccounts;

    public UserDatabase() {
        listOfAccounts = new ArrayList<Account>();
    }


}
