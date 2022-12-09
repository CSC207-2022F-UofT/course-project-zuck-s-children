package notification.Entities;
//entity layer
import account_and_login.account_creation.Account;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MatchNotification extends Notification implements Serializable {
    /**
     * Child class of Notification - a Match Notification.
     */

    /**
     * Construct a Match Notification Object with attributes of content, sender, time, and chatID
     * @param content Content of the notification
     * @param sender Sender of the notification
     * @param time Time the notification was sent
     */
    public MatchNotification(String content, Account sender, LocalDateTime time) {
        super(content, sender, time);
    }
}
