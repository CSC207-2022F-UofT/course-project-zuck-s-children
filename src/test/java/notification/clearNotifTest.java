package notification;
import account_creation.Account;
import data.persistency.UserDatabase;
import notification.Entities.ChatNotification;
import notification.Entities.MatchNotification;
import notification.UseCases.ClearNotifInteractor;
import notification.Present.ClearNotifOutputBoundary;
import notification.Present.ClearNotifPresenter;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class clearNotifTest {

    /**
     * Test - general case with multiple notification objects
     */
    @Test
    void clearNotifGeneral() {

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
        Account curr = new Account("andrew", "4402");
        curr.addNotification(match1);
        curr.addNotification(chat1);
        curr.addNotification(match2);
        curr.addNotification(chat2);
        curr.addNotification(match3);

        UserDatabase.setCurrentUser(curr);
        ClearNotifOutputBoundary clearNotifPresenter = new ClearNotifPresenter() {
            @Override
            public void prepareDisplayView(){
                ArrayList<List> arrResponse = new ArrayList<List>();
                assertTrue(curr.getNotifications().isEmpty());
            }
        };

        ClearNotifInteractor clearNotifInteractor = new ClearNotifInteractor(clearNotifPresenter);

        clearNotifInteractor.clearNotif();
    }

    /**
     * Boundary case - test with no notifications
     */
    @Test
    void ClearNotifNone(){
        Account curr = new Account("andrew", "4402");
        UserDatabase.setCurrentUser(curr);
        ClearNotifOutputBoundary clearNotifPresenter = new ClearNotifPresenter() {
            @Override
            public void prepareDisplayView(){
                ArrayList<List> arrResponse = new ArrayList<List>();
                assertTrue(curr.getNotifications().isEmpty());
            }
        };

        ClearNotifInteractor clearNotifInteractor = new ClearNotifInteractor(clearNotifPresenter);
        clearNotifInteractor.clearNotif();
    }

    /**
     * Boundary case - test with one notification
     */
    @Test
    void ClearNotifOne(){
        Account curr = new Account("andrew", "4402");
        Account acc1 = new Account("huan22", "1234");
        MatchNotification match1 = new MatchNotification("nice to meet you!", acc1, LocalDateTime.now());
        curr.addNotification(match1);

        UserDatabase.setCurrentUser(curr);
        ClearNotifOutputBoundary clearNotifPresenter = new ClearNotifPresenter() {
            @Override
            public void prepareDisplayView(){
                ArrayList<List> arrResponse = new ArrayList<List>();
                assertTrue(curr.getNotifications().isEmpty());
            }
        };

        ClearNotifInteractor clearNotifInteractor = new ClearNotifInteractor(clearNotifPresenter);
        clearNotifInteractor.clearNotif();
    }

}
