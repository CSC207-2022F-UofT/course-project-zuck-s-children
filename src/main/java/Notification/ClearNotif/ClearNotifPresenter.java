package Notification.ClearNotif;

import UI.NotificationUI;

public class ClearNotifPresenter implements ClearNotifOutputBoundary{
    NotificationUI notifUI;

    public ClearNotifPresenter(NotificationUI UI){
        this.notifUI =UI;
    }
    @Override
    public void prepareDisplayView(ClearNotifResponseModel responseModel) {
        this.notifUI.showMessage(responseModel);
    }
}
