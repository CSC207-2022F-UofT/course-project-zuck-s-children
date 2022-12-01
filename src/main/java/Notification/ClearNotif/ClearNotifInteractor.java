package Notification.ClearNotif;

import data.persistency.UserDatabase;

public class ClearNotifInteractor implements ClearNotifInputBoundary{

    private ClearNotifOutputBoundary clearNotifOutputBoundary;
    private UserDatabase userData;


    public ClearNotifInteractor(ClearNotifOutputBoundary presenter, UserDatabase data){
        this.clearNotifOutputBoundary = presenter;
        this.userData = data;
    }
    @Override
    public void clearNotif() {
        this.userData.getCurrentUser().clearNotifications();
        this.clearNotifOutputBoundary.prepareDisplayView();

    }
}
