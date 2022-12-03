package notification.clear_notif;

import ui.NotificationUI;

public class ClearNotifPresenter implements ClearNotifOutputBoundary{
    NotificationUI notifUI;


    @Override
    public void prepareDisplayView() {
        this.notifUI.showMessage();
    }
}
