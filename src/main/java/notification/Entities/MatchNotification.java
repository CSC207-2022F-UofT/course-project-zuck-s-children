package notification.Entities;
//entity layer
import account_creation.Account;

import java.io.Serializable;
import java.time.LocalDateTime;
//implemented serializable
public class MatchNotification extends Notification implements Serializable {
    /**
     * Child class of Notification - a Match Notification.
     */

    public MatchNotification(String content, Account sender, LocalDateTime time) {
        super(content, sender, time);
    }
}
