package chat;

import account_and_login.account_creation.Account;
import chat.control.MsgSendController;
import chat.control.RoomInModel;
import chat.entities.ChatRoomEnt;
import chat.entities.MessageEnt;
import chat.presenter.ChatRoomPresenter;
import chat.presenter.MsgOutBoundary;
import chat.presenter.MsgOutModel;
import chat.use_cases.ChatRoomOpenInteractor;
import chat.use_cases.MsgInBoundary;
import chat.use_cases.MsgSendInteractor;
import chat.use_cases.OpenRoomBoundary;
import data_persistency.ChatDataAccess;
import data_persistency.ChatDataAccessInterface;
import data_persistency.ChatDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing on ChatRoomOpenInteractor
 */
public class ChatRoomTesting {
    ChatDataAccessInterface chatDataAccessInterface;
    MsgOutBoundary presenter;
    OpenRoomBoundary interactor;
    String room1_id;
    String room2_id;
    @BeforeEach
    void setUp() {
        List<Object> chatRoomList = new ArrayList<>();
        ChatDatabase chatDatabase = new ChatDatabase(chatRoomList);
        ChatDataAccess chatDataAccess = new ChatDataAccess();
        chatDataAccess.setChatdata(chatDatabase);
        chatDataAccessInterface = chatDataAccess;

        ChatRoomUI chatRoomUI = new ChatRoomUI();
        presenter = new ChatRoomPresenter(chatRoomUI);
        interactor = new ChatRoomOpenInteractor(presenter, chatDataAccessInterface);
        MsgOutBoundary chatRoomPresenter = new ChatRoomPresenter(chatRoomUI);
        MsgInBoundary msgInteractor = new MsgSendInteractor(chatRoomPresenter, chatDataAccess);
        MsgSendController msgController = new MsgSendController(msgInteractor);
        chatRoomUI.setCA(msgController);

        Account user1 = new Account("user1", "user1");
        Account user2 = new Account("user2", "user2");
        ChatRoomEnt room1 = new ChatRoomEnt(user1, user2);
        room1_id = room1.getId();
        room1.addMessage(new MessageEnt("room1", user1, room1_id));
        room1.addMessage(new MessageEnt("hello", user2, room1_id));
        ChatRoomEnt room2 = new ChatRoomEnt(user1, user2);
        room2_id = room2.getId();
        room2.addMessage(new MessageEnt("room2", user2, room2_id));
        room2.addMessage(new MessageEnt("hi", user1, room2_id));
        room2.addMessage(new MessageEnt("Hello world", user1, room2_id));
        chatDataAccess.addChatRoom(room1);
        chatDataAccess.addChatRoom(room2);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Test on opening a correct chat room
     */
    @Test
    void chatRoomOpenTesting() {
        MsgOutModel model1 = interactor.open(new RoomInModel(room1_id));
        MsgOutModel model2 = interactor.open(new RoomInModel(room2_id));

        assertEquals(2, model1.getMsgList().size());
        assertEquals(3, model2.getMsgList().size());
    }
}