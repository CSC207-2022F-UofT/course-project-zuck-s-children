package notification.Entities;

import account_and_login.account_creation.Account;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ChatNotification extends Notification implements Serializable {
    /**
     * Child class of Notification - a Chat Notification.
     */

    private String id;

    /**
     * Construct a Chat Notification Object with attributes of content, sender, time, and chatID
     * @param content Content of the notification
     * @param sender Sender of the notification
     * @param time Time the notification was sent
     * @param chatID The chatID of current user
     */
    public ChatNotification(String content, Account sender, LocalDateTime time, String chatID) {
        super(content, sender, time);
        this.id = chatID;
    }

    /**
     * Return the room id
     * @return the room id
     */
    public String getId(){
        return this.id;
    }
}
