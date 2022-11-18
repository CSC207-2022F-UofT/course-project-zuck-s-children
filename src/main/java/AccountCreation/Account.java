package AccountCreation;

import Notification.Notification;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String username;
    private String password;
    private Profile profile;
    private List<Profile> matches;
    private List<Notification> notifications;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.profile = new Profile;
        this.matches = new ArrayList<Profile>();
        this.notifications = new ArrayList<Notification>();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    public Profile getProfile() {
        return this.profile;
    }
    public List<Profile> getMatches() {
        return this.matches;
    }

    public List<Notification> getNotifications() {return this.notifications;}

    public void addMatch() {
        this.matches.add(Profile);
    }
}
