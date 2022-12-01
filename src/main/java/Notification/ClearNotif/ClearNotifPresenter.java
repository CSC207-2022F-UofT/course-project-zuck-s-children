package Notification.ClearNotif;

import UI.NotificationUI;

public class ClearNotifPresenter implements ClearNotifOutputBoundary{
    NotificationUI notifUI;


    @Override
    public void prepareDisplayView() {
        this.notifUI.showMessage();
    }
}
