package chat;

import account_creation.Account;
import chat.control.MsgInModel;
import chat.entities.ChatRoomEnt;
import chat.presenter.ChatRoomPresenter;
import chat.presenter.MsgOutBoundary;
import chat.presenter.MsgOutModel;
import chat.use_cases.MsgSendInteractor;
import data.persistency.ChatDataAccess;
import data.persistency.ChatDataAccessInterface;
import data.persistency.ChatDatabase;
import data.persistency.UserDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.ChatRoomUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing on MsgSendInteractor
 */
public class MessageSendingTest {
    ChatDataAccessInterface chatDataAccessInterface;
    UserDatabase USERDATABASE = UserDatabase.getUserDatabase();
    MsgSendInteractor interactor;
    String room1_id;
    @BeforeEach
    void setUp() {
        List<Object> chatRoomList = new ArrayList<>();
        ChatDatabase chatDatabase = new ChatDatabase(chatRoomList);
        ChatDataAccess chatDataAccess = new ChatDataAccess();
        chatDataAccess.setChatdata(chatDatabase);
        chatDataAccessInterface = chatDataAccess;
        HashMap<String, Account> listOfAccount = new HashMap<>();
        Account user1 = new Account("user1", "user1");
        Account user2 = new Account("user2", "user2");
        listOfAccount.put("user1", user1);
        listOfAccount.put("user2", user2);
        USERDATABASE.setAccounts(listOfAccount);
        USERDATABASE.setCurrentUser(user1);
        ChatRoomEnt room1 = new ChatRoomEnt(user1, user2);
        room1_id = room1.getId();
        ChatRoomUI chatRoomUI = new ChatRoomUI();
        chatRoomUI.setFrame();
        chatRoomUI.build();
        chatRoomUI.setRoomId(room1_id);
        MsgOutBoundary chatRoomPresenter = new ChatRoomPresenter(chatRoomUI);
        chatDataAccessInterface.addChatRoom(room1);
        interactor = new MsgSendInteractor(chatRoomPresenter, chatDataAccessInterface);
    }


    @AfterEach
    void tearDown() {
    }

    /**
     * Test on sending a new message to a particular chat room
     */
    @Test
    void sendMessageTest() {
        MsgInModel model = new MsgInModel("message", USERDATABASE.getCurrentUser(), room1_id);
        MsgOutModel response = interactor.sendMessage(model);
        assertEquals(1, response.getMsgList().size());
        response = interactor.sendMessage(model);
        assertEquals(2, response.getMsgList().size());
    }
}
