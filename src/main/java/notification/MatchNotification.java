package notification;

import account_creation.Account;

import java.time.LocalDateTime;

public class MatchNotification extends Notification{
    public MatchNotification(String content, Account sender, LocalDateTime time) {
        super(content, sender, time);
    }
}
