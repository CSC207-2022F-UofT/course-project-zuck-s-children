package notification;
import account_creation.Account;
import data.persistency.UserDatabase;
import notification.show_notif.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class showNotifTest {

    @Test
    void showNotif(){

        //creation of match and chat notifications stored in notifications attribute of current user
        ArrayList<Notification> notifications = new ArrayList<>();
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

        UserDatabase userDatabase = new UserDatabase();
        userDatabase.setCurrentUser(curr);
        ShowNotifOutputBoundary showNotifPresenter = new ShowNotifPresenter() {
            public void prepareDisplayView(NotifResponseModel responseModel){
                ArrayList<List> responseArray = responseModel.getResponseModel();
                assertEquals(responseArray.size(), 5);
                assertEquals(responseArray.get(3).get(0), "we've matched");
            }
        };
        ShowNotifInputBoundary showNotifInteractor = new ShowNotifInteractor(showNotifPresenter,userDatabase);

        showNotifInteractor.showNotif();
    }


}
