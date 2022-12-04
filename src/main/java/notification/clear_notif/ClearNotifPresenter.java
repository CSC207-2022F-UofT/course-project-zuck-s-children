package notification.clear_notif;

import ui.NotificationUI;

public class ClearNotifPresenter implements ClearNotifOutputBoundary{
    NotificationUI notifUI;

    /**
     * Creates a constructor for to call on UI builder.
     * @param notifUI Notification UI class that builds interface.
     */
    public ClearNotifPresenter(NotificationUI notifUI) {
        this.notifUI = notifUI;
    }

    @Override
    public void prepareDisplayView() {
        this.notifUI.showMessage();
    }
}
