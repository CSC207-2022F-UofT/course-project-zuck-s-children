package UI;


import Notification.ClearNotif.ClearNotifResponseModel;
import Notification.ShowNotif.NotifResponseModel;
import UI.components.NotifTable;
import java.util.ArrayList;

public class NotificationUI{
    ArrayList notifications;

    public NotificationUI(ArrayList response){
        this.notifications = response;
    }

    public void build(ArrayList notifications) {
        NotifTable notifTable = new NotifTable(notifications);
    }

    public void showMessage(ClearNotifResponseModel responseModel){
        //add label
    }



}
