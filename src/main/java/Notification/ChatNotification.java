package Notification;

import AccountCreation.Account;

import java.time.LocalDateTime;

public class ChatNotification extends Notification{

    private String id;

    public ChatNotification(String content, Account sender, LocalDateTime time, String chatid) {
        super(content, sender, time);
        this.id = chatid;
    }
}
