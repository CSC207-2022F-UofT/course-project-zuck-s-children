package notification;
import account_creation.Account;
import data.persistency.UserDatabase;
import notification.clear_notif.ClearNotifInteractor;
import notification.clear_notif.ClearNotifOutputBoundary;
import notification.clear_notif.ClearNotifPresenter;
import notification.show_notif.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class showNotifTest {

    /**
     * Test - general case with multiple notification objects
     */
    @Test
    void showNotifGeneral(){

        //creation of match and chat notifications stored in notifications attribute of current user
        Account acc1 = new Account("huan22", "1234");
        Account acc2 = new Account("lance33", "2231");
        Account acc3 = new Account("kenji44", "9920");
        MatchNotification match1 = new MatchNotification("nice to meet you!", acc1, LocalDateTime.now());
        ChatNotification chat1 = new ChatNotification("hello", acc1, LocalDateTime.now(), "3");
        MatchNotification match2 = new MatchNotification("we've matched", acc2, LocalDateTime.now());
        ChatNotification chat2 = new ChatNotification("wanna study?", acc2, LocalDateTime.now(), "2");
        MatchNotification match3 = new MatchNotification("I prefer Robarts", acc3, LocalDateTime.now());

        //assign notifications to current user
        Account currUser = new Account("andrew", "4402");
        currUser.addNotification(match1);
        currUser.addNotification(chat1);
        currUser.addNotification(match2);
        currUser.addNotification(chat2);
        currUser.addNotification(match3);

        UserDatabase.setCurrentUser(currUser);
        ShowNotifOutputBoundary showNotifPresenter = new ShowNotifPresenter() {
            public void prepareDisplayView(NotifResponseModel responseModel){
                ArrayList<List> responseArray = responseModel.getResponseModel();
                assertEquals(responseArray.size(), 5);
                assertEquals(responseArray.get(3).get(0), "we've matched");
            }
        };
        ShowNotifInputBoundary showNotifInteractor = new ShowNotifInteractor(showNotifPresenter);

        showNotifInteractor.showNotif();
    }

    /**
     * Boundary case - test with no notifications
     */
    @Test
    void showNotifEmpty(){
        Account currUser = new Account("andrew", "4402");
        UserDatabase.setCurrentUser(currUser);
        ShowNotifOutputBoundary showNotifPresenter = new ShowNotifPresenter() {
            public void prepareDisplayView(NotifResponseModel responseModel){
                ArrayList<List> responseArray = responseModel.getResponseModel();
                assertEquals(responseArray.size(), 0);
            }
        };
        ShowNotifInputBoundary showNotifInteractor = new ShowNotifInteractor(showNotifPresenter);
        showNotifInteractor.showNotif();

    }

    /**
     * Boundary case - test with one notification
     */
    @Test
    void showNotifOne(){
        Account currUser = new Account("andrew", "4402");
        Account acc1 = new Account("huan22", "1234");
        MatchNotification match1 = new MatchNotification("nice to meet you!", acc1, LocalDateTime.now());
        currUser.addNotification(match1);

        UserDatabase.setCurrentUser(currUser);
        ShowNotifOutputBoundary showNotifPresenter = new ShowNotifPresenter() {
            public void prepareDisplayView(NotifResponseModel responseModel){
                ArrayList<List> responseArray = responseModel.getResponseModel();
                assertEquals(responseArray.size(), 1);
            }
        };
        ShowNotifInputBoundary showNotifInteractor = new ShowNotifInteractor(showNotifPresenter);
        showNotifInteractor.showNotif();
    }



}
