package AccountCreation;

import Notification.Notification;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

import profile.Profile;
import profile.ProfileEntity;

public class Account implements Serializable {
    private String username;
    private String password;
    private ProfileEntity profile;
    private ArrayList<Profile> matches;
    private ArrayList<Notification> notifications;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.profile = new ProfileEntity();
        this.matches = new ArrayList<Account>();
        this.notifications = new ArrayList<Notification>();
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public ProfileEntity getProfile() {
        return this.profile;
    }
    public List<Account> getMatches() {
        return this.matches;
    }
    public List<Notification> getNotifications() {return this.notifications;}

    public void addNotification(Notification notification){
        notifications.add(notification);
    }

    public void addMatch(Profile profile) {
        this.matches.add(profile);
    }
}
