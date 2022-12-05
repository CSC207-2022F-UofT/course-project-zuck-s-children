package notification;
//entity layer
import account_creation.Account;

import java.time.LocalDateTime;

public class MatchNotification extends Notification{
    /**
     * Child class of Notification - a Match Notification.
     */

    public MatchNotification(String content, Account sender, LocalDateTime time) {
        super(content, sender, time);
    }
}
