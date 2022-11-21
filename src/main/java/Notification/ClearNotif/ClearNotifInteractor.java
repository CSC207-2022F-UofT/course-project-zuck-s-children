package Notification.ClearNotif;

public class ClearNotifInteractor implements ClearNotifInputBoundary{

    private ClearNotifOutputBoundary clearNotifOutputBoundary;
    //private ClearNotifGateway clearNotifGateway;


    public ClearNotifInteractor(ClearNotifOutputBoundary presenter){
        this.clearNotifOutputBoundary = presenter;
        //this.clearNotifGateway = gateway;
    }
    @Override
    public void clearNotif() {
        userDatabase.getAccount().setNotifications();
        //this.clearNotifGateway.erase();

        ClearNotifResponseModel responseModel = new ClearNotifResponseModel("No new notifications!");
        this.clearNotifOutputBoundary.prepareDisplayView(responseModel);

    }
}
