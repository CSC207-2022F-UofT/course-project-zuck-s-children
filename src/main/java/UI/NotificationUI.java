package UI;


import Notification.ShowNotif.NotifResponseModel;
import UI.components.NotifTable;
import java.util.ArrayList;

public class NotificationUI implements ViewModel{
    ArrayList notifications;

    public NotificationUI(ArrayList response){
        this.notifications = response;
    }
    @Override
    public void build(ArrayList notifications) {
        NotifTable notifTable = new NotifTable(notifications);
    }

    public void showMessage(NotifResponseModel responseModel){
        //add label
    }



}
