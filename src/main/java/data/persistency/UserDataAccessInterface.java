package data.persistency;

import AccountCreation.Account;

import java.util.ArrayList;

public interface UserDataAccessInterface {
    void save();
    ArrayList<Account> load();
}
