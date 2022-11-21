package Notification.ShowNotif;

import Notification.ShowNotif.NotifResponseModel;
import Notification.ShowNotif.ShowNotifOutputBoundary;
import UI.NotificationUI;

public class ShowNotifPresenter implements ShowNotifOutputBoundary {
    NotificationUI notifUI;

    public ShowNotifPresenter(NotificationUI UI){
        this.notifUI = UI;
    }
    @Override
    public void prepareDisplayView(NotifResponseModel response) {
        this.notifUI.build(response.getResponseModel());
    }
}
