package Notification.ClearNotif;

public class ClearNotifInteractor implements ClearNotifInputBoundary{

    private ClearNotifOutputBoundary clearNotifOutputBoundary;
    private ClearNotifGateway clearNotifGateway;


    public ClearNotifInteractor(ClearNotifOutputBoundary presenter, ClearNotifGateway gateway){
        this.clearNotifOutputBoundary = presenter;
        this.clearNotifGateway = gateway;
    }
    @Override
    public void clearNotif() {
        currentuser.notifications.clear();
        this.clearNotifGateway.erase();

        ClearNotifResponseModel responseModel = new ClearNotifResponseModel("No new notifications!");
        this.clearNotifOutputBoundary.prepareDisplayView(responseModel);

    }
}
