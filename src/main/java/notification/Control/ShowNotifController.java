package notification.Control;

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
    /**
     * Refresh all notifications.
     */
    public void refresh(){
        this.interactor.refresh();
    }
}
