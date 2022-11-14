package Notification;

import Notification.ShowNotifInputBoundary;

public class ShowNotifController {
    private final ShowNotifInputBoundary interactor;

    public ShowNotifController(ShowNotifInputBoundary userinput){
        this.interactor = userinput;
    }
    public void showNotif(){
        this.interactor.showNotif();
    }
}
