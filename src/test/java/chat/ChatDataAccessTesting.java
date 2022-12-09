package chat;

import account_and_login.account_creation.Account;
import chat.entities.ChatRoomEnt;
import data.persistency.ChatDataAccess;
import data.persistency.ChatDataAccessInterface;
import data.persistency.ChatDatabase;
import data.persistency.UserDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing on various methods of chatDataAccessInterface
 */
public class ChatDataAccessTesting {
    ChatDataAccessInterface chatDataAccessInterface;
    UserDatabase USERDATABASE = UserDatabase.getUserDatabase();
    @BeforeEach
    void setUp() {
        List<Object> chatRoomList = new ArrayList<>();
        ChatDatabase chatDatabase = new ChatDatabase(chatRoomList);
        ChatDataAccess chatDataAccess = new ChatDataAccess();
        chatDataAccess.setChatdata(chatDatabase);
        chatDataAccessInterface = chatDataAccess;
        USERDATABASE.setAccounts(new HashMap<>());
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Test on adding a new chat room
     */
    @Test
    void chatDataAccessInterface_add() {
        assertEquals(0, chatDataAccessInterface.getChatData().getChatList().size());
        ChatRoomEnt chatRoomEnt = new ChatRoomEnt(new Account("user1","pass1"),
                new Account("user2","pass2"));
        chatDataAccessInterface.addChatRoom(chatRoomEnt);
        assertEquals(1, chatDataAccessInterface.getChatData().getChatList().size());
    }

    /**
     * Test on loading a room by id
     */
    @Test
    void chatDataAccessInterface_loadById() {
        assertEquals(0, chatDataAccessInterface.getChatData().getChatList().size());
        ChatRoomEnt chatRoomEnt = new ChatRoomEnt(new Account("user1","pass1"),
                new Account("user2","pass2"));
        String id = chatRoomEnt.getId();
        chatDataAccessInterface.addChatRoom(chatRoomEnt);
        ChatRoomEnt loadRoom = (ChatRoomEnt) chatDataAccessInterface.loadRoomById(id);
        assertEquals(chatRoomEnt, loadRoom);
        ChatRoomEnt nullRoom = (ChatRoomEnt) chatDataAccessInterface.loadRoomById("");
        assertEquals(null, nullRoom);
    }

    /**
     * Test on loading a room by an account
     */
    @Test
    void chatDataAccessInterface_loadByAccount() {
        assertEquals(0, chatDataAccessInterface.getChatData().getChatList().size());
        Account user = new Account("user1","pass1");
        USERDATABASE.setCurrentUser(user);

        ChatRoomEnt chatRoom1 = new ChatRoomEnt(user, new Account("user2","pass2"));
        ChatRoomEnt chatRoom2 = new ChatRoomEnt(user, new Account("user3","pass3"));
        ChatRoomEnt chatRoom3 = new ChatRoomEnt(user, new Account("user4","pass4"));
        ChatRoomEnt chatRoom4 = new ChatRoomEnt(new Account("user5", "pass5"),
                new Account("user6","pass6"));

        chatDataAccessInterface.addChatRoom(chatRoom1);
        chatDataAccessInterface.addChatRoom(chatRoom2);
        chatDataAccessInterface.addChatRoom(chatRoom3);
        chatDataAccessInterface.addChatRoom(chatRoom4);

        List<Object> loadRoom = chatDataAccessInterface.loadRoomByAccount();
        assertEquals(3, loadRoom.size());
    }
}