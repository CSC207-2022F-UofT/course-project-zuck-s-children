package Notification.ClearNotif;

import data.persistency.UserDatabase;

public class ClearNotifInteractor implements ClearNotifInputBoundary{

    private ClearNotifOutputBoundary clearNotifOutputBoundary;
    private UserDatabase userDatabase;

    public ClearNotifInteractor(UserDatabase userDatabase, ClearNotifOutputBoundary presenter){
        this.clearNotifOutputBoundary = presenter;
        //this.clearNotifGateway = gateway;
    }
    @Override
    public void clearNotif() {
        userDatabase.getCurrentUser().setNotifications();

        ClearNotifResponseModel responseModel = new ClearNotifResponseModel("No new notifications!");
        this.clearNotifOutputBoundary.prepareDisplayView(responseModel);

    }
}
