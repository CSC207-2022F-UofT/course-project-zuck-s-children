package swipe.screen;

import account_and_login.account_creation.Account;
import data.persistency.ChatDataAccess;
import data.persistency.ChatDataAccessInterface;
import data.persistency.ChatDatabase;
import data.persistency.UserDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import swipe.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SwiperControllerTest {
    SwiperPresenter testPresenter;
    SwiperInputBoundary testInteractor;
    Account curr;
    Account potential;
    UserDatabase database;
    List<Object> chatRoomList;
    ChatDatabase chatDatabase;
    ChatDataAccess chatDataAccess;
    ChatDataAccessInterface chatDataAccessInterface;


    @BeforeEach
    void setUp() {
        chatRoomList = new ArrayList<>();
        chatDatabase = new ChatDatabase(chatRoomList);
        chatDataAccess = new ChatDataAccess();
        chatDataAccess.setChatdata(chatDatabase);
        chatDataAccessInterface = chatDataAccess;
        testPresenter = new SwiperPresenterFormatter();
        testInteractor = new SwiperInteractor(testPresenter, chatDataAccess);
        curr = new Account("Sanzhar", "password");
        potential = new Account("Potential", "pass");
        database = UserDatabase.getUserDatabase();
        UserDatabase.getUserDatabase().setCurrentUser(curr);
        UserDatabase.getUserDatabase().getAccounts().put("Sanzhar", curr);
        UserDatabase.getUserDatabase().getAccounts().put("Potential", potential);
        chatDataAccess = new ChatDataAccess();
    }

    @AfterEach
    void tearDown() {
        testPresenter = null;
        testInteractor = null;
        curr =null;
        potential = null;
        database = null;
        UserDatabase.getUserDatabase().setCurrentUser(null);
        UserDatabase.getUserDatabase().getAccounts().remove("Sanzhar");
        UserDatabase.getUserDatabase().getAccounts().remove("Potential");
        chatRoomList = null;
        chatDatabase = null;
        chatDataAccess.setChatdata(null);
        chatDataAccessInterface = null;
    }

    @Test
    void testCreate() {
        SwiperController testController = new SwiperController(testInteractor);
        SwiperResponseModel result = testController.create("T", potential);
        assertTrue(curr.getMatches().contains(potential));
        assertFalse(potential.getMatches().contains(curr));
        assertEquals("N", result.getAccepted());
        UserDatabase.getUserDatabase().setCurrentUser(potential);
        SwiperResponseModel result2 = testController.create("T", curr);
        assertEquals("Y", result2.getAccepted());
        assertTrue(curr.getMatches().contains(potential));
        assertTrue(potential.getMatches().contains(curr));
    }

    @Test
    void testCreate2(){
        SwiperController testController = new SwiperController(testInteractor);
        SwiperResponseModel result = testController.create("F", potential);
        assertFalse(curr.getMatches().contains(potential));
        assertFalse(potential.getMatches().contains(curr));
        assertEquals("N", result.getAccepted());

    }

}