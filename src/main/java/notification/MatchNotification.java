package notification;
import account_creation.Account;

import java.time.LocalDateTime;

public class MatchNotification extends Notification{
    /**
     * Child class of Notification - a Match Notification.
     */

    /**
     * Construct a Notification Object with attributes of content, sender, and time
     * @param content Content of the notification
     * @param sender Sender of the notification
     * @param time Time the notification was sent
     */
    public MatchNotification(String content, Account sender, LocalDateTime time) {
        super(content, sender, time);
    }
}
