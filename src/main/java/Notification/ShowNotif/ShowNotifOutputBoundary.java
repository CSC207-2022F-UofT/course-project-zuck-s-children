package Notification.ShowNotif;


//use case layer

import Notification.ShowNotif.NotifResponseModel;

public interface ShowNotifOutputBoundary {
    void prepareDisplayView(NotifResponseModel response);
}
