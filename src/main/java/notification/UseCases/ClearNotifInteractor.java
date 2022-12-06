package notification.UseCases;
import account_creation.Account;
import data.persistency.UserDatabase;
import notification.Control.ClearNotifInputBoundary;
import notification.Present.ClearNotifOutputBoundary;

//use case layer
public class ClearNotifInteractor implements ClearNotifInputBoundary {

    private ClearNotifOutputBoundary clearNotifOutputBoundary;
    private Account user;

    /**
     * Construct an interactor for clearing all notifications.
     * @param presenter output boundary interface for the presenter
     */
    public ClearNotifInteractor(ClearNotifOutputBoundary presenter){
        this.clearNotifOutputBoundary = presenter;
        this.user = UserDatabase.getUserDatabase().getCurrentUser();
    }
    /**
     * Clear all notifications stored in current user's notifications attribute.
     */
    @Override
    public void clearNotif() {
        this.user.clearNotifications();
        this.clearNotifOutputBoundary.prepareDisplayView();

    }
}
