package account_creation;

import notification.Entities.Notification;

import java.util.*;

import java.io.Serializable;

import profile.Profile;

/**
 * Construct an Account Entity.
 *
 */
public class Account implements Serializable, Comparable<Account> {
    private String username;
    private String password;
    private Profile profile;
    private ArrayList<Account> matches;
    private ArrayList<Account> buddies;
    private ArrayList<Notification> notifications;
    private Set<Account> seen;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.profile = new Profile();
        this.matches = new ArrayList<Account>();
        this.buddies = new ArrayList<Account>();
        this.notifications = new ArrayList<Notification>();
        this.seen = new HashSet<>();
    }

    /**
     * Return username of this account.
     *
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Return password of this account.
     *
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Set profile of this account.
     *
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * Get the profile of this account.
     *
     */
    public Profile getProfile() {
        return this.profile;
    }

    /**
     * Get the matches of this account.
     *
     */
    public List<Account> getMatches() {
        return this.matches;
    }

    /**
     * Get the buddies of this account.
     *
     */
    public List<Account> getBuddies() { return this.buddies; }

    /**
     * Get the notifications of this account.
     *
     */
    public List<Notification> getNotifications() {
        return this.notifications;
    }

    /**
     * Add match to this account.
     *
     */
    public void addMatch(Account match) {
        this.matches.add(match);
    }

    /**
     * Add buddy to this account.
     *
     */
    public void addBuddy(Account buddy) {this.buddies.add(buddy);}

    /**
     * Add notification to this account.
     *
     */
    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    /**
     * Clear notifications of this account.
     *
     */
    public void clearNotifications() {
        this.notifications.clear();
    }

    /**
     * Compare accounts by score.
     *
     */
    @Override
    public int compareTo(Account other) {
        return Integer.compare(other.getProfile().getScore(), this.getProfile().getScore());
    }

    /**
     * Add seen users to this account.
     *
     */
    public void addSeen(Account user){
        this.seen.add(user);
    }

    /**
     * Get seen users of this account.
     *
     */
    public Set<Account> getSeen() {
        return this.seen;
    }
}