package notification.Entities;
// entity layer
import account_and_login.account_creation.Account;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Notification implements Serializable {
    /**
     * The parent Notification Object.
     */

    private String notifContent;
    private Account notifSender;
    private LocalDateTime notifTime;

    /**
     * Construct a Notification Object with attributes of content, sender, and time
     * @param content Content of the notification
     * @param sender Sender of the notification
     * @param time Time the notification was sent
     */
    public Notification(String content, Account sender, LocalDateTime time) {
        this.notifContent = content;
        this.notifSender = sender;
        this.notifTime = time;
    }

    /**
     * Set content of this Notification.
     * @param message Content of the Notification
     */
    public void setNotifContent(String message){
        this.notifContent = message;
    }

    /**
     * @return content of this Notification.
     */
    public String getNotifContent(){
        return this.notifContent;
    }

    /**
     * Set sender of this Notification.
     * @param person Sender of the Notification
     */
    public void setNotifSender(Account person){
        this.notifSender = person;
    }

    /**
     * @return sender of this Notification.
     */
    public Account getNotifSender(){
        return this.notifSender;
    }

    /**
     * Set time sent of this Notification.
     * @param dateSent Time the notification was sent
     */
    public void setDate(LocalDateTime dateSent){
        this.notifTime = dateSent;
    }

    /**
     * @return time sent of this Notification.
     */
    public LocalDateTime getDate(){
        return this.notifTime;
    }
}
