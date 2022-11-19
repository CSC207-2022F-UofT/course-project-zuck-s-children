package Notification;

import AccountCreation.Account;

import java.time.LocalDateTime;

public abstract class Notification {

    private String notifContent;
    private Account notifSender;
    private LocalDateTime notifTime;

    public Notification(String content, Account sender, LocalDateTime time) {
        this.notifContent = content;
        this.notifSender = sender;
        this.notifTime = time;
    }

    public void setNotifContent(String message){
        this.notifContent = message;
    }

    public String getNotifContent(){
        return this.notifContent;
    }

    public void setNotifSender(Account person){
        this.notifSender = person;
    }

    public Account getNotifSender(){
        return this.notifSender;
    }

    public void setDate(LocalDateTime dateSent){
        this.notifTime = dateSent;
    }

    public LocalDateTime getDate(){
        return this.notifTime;
    }
}
