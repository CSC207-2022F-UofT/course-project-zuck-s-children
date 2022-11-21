package Notification.ClearNotif;

import data.persistency.UserDatabase;

public class ClearNotifInteractor implements ClearNotifInputBoundary{

    private ClearNotifOutputBoundary clearNotifOutputBoundary;
    private UserDatabase userData;
    //private ClearNotifGateway clearNotifGateway;


    public ClearNotifInteractor(ClearNotifOutputBoundary presenter, UserDatabase data){
        this.clearNotifOutputBoundary = presenter;
        this.userData = data;
        //this.clearNotifGateway = gateway;
    }
    @Override
    public void clearNotif() {
        this.userData.getCurrentUser().clearNotifications();
        //this.clearNotifGateway.erase();

        ClearNotifResponseModel responseModel = new ClearNotifResponseModel("No new notifications!");
        this.clearNotifOutputBoundary.prepareDisplayView(responseModel);

    }
}
