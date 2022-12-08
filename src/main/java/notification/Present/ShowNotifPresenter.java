package notification.Present;

import ui.NotificationUI;

public class ShowNotifPresenter implements ShowNotifOutputBoundary {
    NotificationUI notifUI;

    public ShowNotifPresenter(){
    }
    /**
     * Creates a constructor for to call on UI builder.
     * @param notifUI Notification UI class that builds interface.
     */
    public ShowNotifPresenter(NotificationUI notifUI){
        this.notifUI = notifUI;
    }

    /**
     * Signals the UI to display the list of notifications.
     * @param response a notifResponseModel
     */
    @Override
    public void prepareDisplayView(NotifResponseModel response) {
        this.notifUI.prepareView(response.getResponseModel());
    }

    @Override
    public void refresh(NotifResponseModel response) {
        this.notifUI.refresh(response.getResponseModel());
    }
}
