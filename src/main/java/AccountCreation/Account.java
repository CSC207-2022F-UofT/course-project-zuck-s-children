package AccountCreation;

import Notification.Notification;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

import profile.Profile;
public class Account implements Serializable, Comparable<Account> {
    private String username;
    private String password;
    private Profile profile;
    private ArrayList<Profile> matches;
    private ArrayList<Notification> notifications;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.profile = new Profile();
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

    public void clearNotifications() {this.notifications = new ArrayList<>();}


    public void addMatch(Profile profile) {
        this.matches.add(profile);
    }

    public void addNotification(Notification notification){
        notifications.add(notification);
    }

    public void clearNotifications(){
        this.notifications.clear();
    }

    @Override
    public int compareTo(Account other){
        return Integer.compare(this.getProfile().getScore(), other.getProfile().getScore());
    }


}
