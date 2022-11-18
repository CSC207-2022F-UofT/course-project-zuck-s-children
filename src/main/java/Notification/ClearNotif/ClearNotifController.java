package Notification.ClearNotif;

public class ClearNotifController {

    private ClearNotifInputBoundary interactor;

    public ClearNotifController(ClearNotifInputBoundary boundary){
        this.interactor = boundary;
    }

    public void clearNotif(){
        this.interactor.clearNotif();
    }

}
