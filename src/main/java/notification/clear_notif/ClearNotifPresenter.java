package notification.clear_notif;

import ui.NotificationUI;

public class ClearNotifPresenter implements ClearNotifOutputBoundary{
    NotificationUI notifUI;

    public ClearNotifPresenter(){}

    /**
     * Creates a constructor for to call on UI builder.
     * @param notifUI Notification UI class that builds interface.
     */
    public ClearNotifPresenter(NotificationUI notifUI){
        this.notifUI = notifUI;
    }

    /**
     * Signals UI to update change.
     */
    @Override
    public void prepareDisplayView() {
        this.notifUI.update();
    }
}
