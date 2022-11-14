package Notification;
import java.util.List;

//use case layer

public class ShowNotifInteractor implements ShowNotifInputBoundary{
    final ShowNotifGateway showNotifGateway;
    final ShowNotifOutputBoundary showNotifOutputBoundary;

    public ShowNotifInteractor(ShowNotifGateway showNotifGateway, ShowNotifOutputBoundary showNotifOutputBoundary){
        this.showNotifGateway = showNotifGateway;
        this.showNotifOutputBoundary = showNotifOutputBoundary;
    }
    @Override
    public void showNotif(){
        List notifList = showNotifGateway.getNotif();
        NotifResponseModel notifResponseModel = new NotifResponseModel(notifList);

        showNotifOutputBoundary.prepareDisplayView(notifResponseModel);



    }
}
