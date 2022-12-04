package notification.show_notif;
import ui.NotificationUI;
import javax.swing.*;
import java.awt.*;

public class ShowNotifPresenter implements ShowNotifOutputBoundary {
    NotificationUI notifUI;

    /**
     * Creates a constructor for to call on UI builder.
     * @param notifUI Notification UI class that builds interface.
     */
    public ShowNotifPresenter(NotificationUI notifUI) {
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
}
