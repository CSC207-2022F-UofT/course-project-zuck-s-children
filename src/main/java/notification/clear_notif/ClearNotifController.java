package notification.clear_notif;

public class ClearNotifController {

    private ClearNotifInputBoundary interactor;

    /**
     * Construct a controller to clear all notifications.
     * @param boundary input boundary interface for use case
     */
    public ClearNotifController(ClearNotifInputBoundary boundary){
        this.interactor = boundary;
    }

    /**
     * Clear all notifications stored in current user's notification attribute.
     */

    public void clearNotif(){
        this.interactor.clearNotif();
    }

}
