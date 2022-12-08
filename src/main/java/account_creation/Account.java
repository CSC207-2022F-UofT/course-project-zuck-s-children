package account_creation;

import notification.Entities.Notification;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.io.Serializable;
import java.util.Set;

import profile.Profile;
public class Account implements Serializable, Comparable<Account>{
    private String username;
    private String password;
    private Profile profile;
    private ArrayList<Account> matches;
    private ArrayList<Notification> notifications;
    private Set<Account> seen;


    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.profile = new Profile();
        this.matches = new ArrayList<Account>();
        this.notifications = new ArrayList<Notification>();
        this.seen = new HashSet<>();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public List<Account> getMatches() {
        return this.matches;
    }

    public List<Notification> getNotifications() {
        return this.notifications;
    }

    public void addMatch(Account match) {
        this.matches.add(match);
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void clearNotifications() {
        this.notifications.clear();
    }

    public Set<Account> getSeen(){
        return this.seen;
    }

    public void addSeen(Account seenAccount){
        this.seen.add(seenAccount);
    }

    @Override
    public int compareTo(Account other) {
        return Integer.compare(other.getProfile().getScore(), this.getProfile().getScore());
    }
}