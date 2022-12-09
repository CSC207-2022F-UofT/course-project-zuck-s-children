package notification.UseCases;
import notification.Entities.Notification;
import data.persistency.UserDatabase;
import notification.Present.NotifResponseModel;
import notification.Control.ShowNotifInputBoundary;
import notification.Present.ShowNotifOutputBoundary;

import java.util.ArrayList;
import java.util.List;

//use case layer

public class ShowNotifInteractor implements ShowNotifInputBoundary {
    private ShowNotifOutputBoundary showNotifOutputBoundary;

    /**
     * Create an interactor for showing all notifications.
     * @param showNotifOutputBoundary output boundary interface for the presenter
     */
    public ShowNotifInteractor(ShowNotifOutputBoundary showNotifOutputBoundary){
        this.showNotifOutputBoundary = showNotifOutputBoundary;
    }


    private NotifResponseModel createModel(){
        List<Notification> notifList = UserDatabase.getUserDatabase().getCurrentUser().getNotifications();
        ArrayList formattedList = formatNotif(notifList);
        NotifResponseModel notifResponseModel = new NotifResponseModel(formattedList);
        return notifResponseModel;
    }
    /**
     * Show all notifications from current user's notifications attribute.
     */
    @Override
    public void showNotif(){
        showNotifOutputBoundary.prepareDisplayView(createModel());
    }

    @Override
    public void refresh() {
        showNotifOutputBoundary.refresh(createModel());
    }

    /**
     * Formats list of notification objects to a nested list of strings.
     * @param notifList list of all notifications from user's notifications attribute
     */
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
