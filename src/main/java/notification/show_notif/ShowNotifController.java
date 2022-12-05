package notification.show_notif;
public class ShowNotifController {
    private final ShowNotifInputBoundary interactor;

    /**
     * Create a constructor to show all notifications.
     * @param showInputBoundary input boundary interface for use case
     */
    public ShowNotifController(ShowNotifInputBoundary showInputBoundary){
        this.interactor = showInputBoundary;
    }
    /**
     * Show all notifications.
     */
    public void showNotif(){
        this.interactor.showNotif();
    }
}
