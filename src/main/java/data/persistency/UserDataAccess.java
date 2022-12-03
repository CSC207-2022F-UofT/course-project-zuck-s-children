package data.persistency;

import AccountCreation.Account;
import Notification.ClearNotif.ClearNotifGateway;

import java.util.ArrayList;

public class UserDataAccess implements UserDataAccessInterface, ClearNotifGateway {

    public void save() {

    }

    public ArrayList<Account> load() {
        return null;
    }

    public void erase() { //erases all notifications - called by ClearNotifGateway through clearNotif usecase
        // do we want to re-write data?
    }
}
