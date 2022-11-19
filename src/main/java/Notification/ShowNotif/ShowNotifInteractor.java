package Notification.ShowNotif;
import Notification.Notification;

import java.util.ArrayList;
import java.util.List;

//use case layer

public class ShowNotifInteractor implements ShowNotifInputBoundary {
    private ShowNotifOutputBoundary showNotifOutputBoundary;

    public ShowNotifInteractor(ShowNotifOutputBoundary showNotifOutputBoundary){
        this.showNotifOutputBoundary = showNotifOutputBoundary;
    }
    @Override
    public void showNotif(){
        List<Notification> notifList = currentUser.getNotifications();
        ArrayList formattedList = formatNotif(notifList);

        NotifResponseModel notifResponseModel = new NotifResponseModel(formattedList);

        showNotifOutputBoundary.prepareDisplayView(notifResponseModel);
    }

    private ArrayList formatNotif(List<Notification> notifList){
        ArrayList formattedList = new ArrayList<List>();
        for (Notification i: notifList){
            ArrayList<String> innerList = new ArrayList<String>();
            innerList.add(i.getNotifSender().getUsername());
            innerList.add(i.getNotifContent());
            innerList.add(i.getDate().toString());

            formattedList.add(innerList);
        }
        return formattedList;
    }
}
