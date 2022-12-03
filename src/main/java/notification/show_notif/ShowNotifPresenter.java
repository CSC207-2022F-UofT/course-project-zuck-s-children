package notification.show_notif;

import ui.NotificationUI;

public class ShowNotifPresenter implements ShowNotifOutputBoundary {
    NotificationUI notifUI;

    @Override
    public void prepareDisplayView(NotifResponseModel response) {
        this.notifUI.prepareView(response.getResponseModel());
    }
}
