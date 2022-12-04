package notification.show_notif;
import account_creation.Account;
import notification.MatchNotification;
import notification.Notification;
import data.persistency.UserDatabase;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

//use case layer
public class ShowNotifInteractor implements ShowNotifInputBoundary {
    private ShowNotifOutputBoundary showNotifOutputBoundary;
    private Account user;

    /**
     * Create an interactor for showing all notifications.
     * @param showNotifOutputBoundary output boundary interface for the presenter
     */
    public ShowNotifInteractor(ShowNotifOutputBoundary showNotifOutputBoundary){
        this.showNotifOutputBoundary = showNotifOutputBoundary;
        this.user = UserDatabase.getCurrentUser();
    }

    /**
     * Show all notifications from current user's notifications attribute.
     */
    @Override
    public void showNotif(){
      //  ArrayList<Notification> notifList = this.user.getNotifications();
        Account acc1 = new Account("nina", "1234");
        MatchNotification match1 = new MatchNotification("we've matched", acc1,LocalDateTime.now());
        ArrayList<Notification> notifList = new ArrayList<Notification>();
        notifList.add(match1);


        ArrayList formattedList = formatNotif(notifList);

        NotifResponseModel notifResponseModel = new NotifResponseModel(formattedList);
        showNotifOutputBoundary.prepareDisplayView(notifResponseModel);
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
