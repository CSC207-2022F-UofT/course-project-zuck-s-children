package data.persistency;

import Notification.Notification;
import profile.ProfileEntity;
import AccountCreation.Account;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private String username;
    private String password;
    private Profile profile;
    private List<Profile> matches;
    private List<Notification> notifications;
    private static ArrayList<UserData> userDatabase;
    public UserData(Account userAccount) {
        this.username = userAccount.getUsername();
        this.password = userAccount.getPassword();
        this.profile = userAccount.getProfile();
        this.matches = userAccount.getMatches();
        this.notifications = userAccount.getNotifications();
        userDatabase.add(this);
    }
    //TODO: DO WE WANT TO USE USERDATA OR JUST ACCOUNT ENTITIES BECAUSE THEY ARE THE SAME THING ESSENTIALLY?
}
