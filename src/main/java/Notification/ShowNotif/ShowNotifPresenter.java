package Notification.ShowNotif;

import Notification.ShowNotif.NotifResponseModel;
import Notification.ShowNotif.ShowNotifOutputBoundary;
import UI.NotificationUI;

public class ShowNotifPresenter implements ShowNotifOutputBoundary {
    NotificationUI notifUI;

    @Override
    public void prepareDisplayView(NotifResponseModel response) {
        this.notifUI.prepareView(response.getResponseModel());
    }
}
