package data.persistency;

import account_and_login.account_creation.Account;
import chat.entities.ChatRoomEnt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChatDatabase implements Serializable {
    private static List<Object> chatData;

    public ChatDatabase(List<Object> rooms){
        chatData = rooms;
    }
    public Object findById(String rid) {
        Object roomFound = null;
        for(Object room : chatData){
            if (((ChatRoomEnt)room).getId().equals(rid)){
                roomFound = room;
            }
        }
        return roomFound;
    }
    public List<Object> findByAccount(Account acc)  {
        List<Object> roomList = new ArrayList<>();
        if (chatData != null) {
            for (Object room : chatData) {
                if (((ChatRoomEnt) room).checkParticipant(acc)) {
                    roomList.add(room);
                }
            }
        }
        return roomList;
    }

    public List<Object> getChatList() {
        return this.chatData;
    }

    public void addChatRoom(ChatRoomEnt room) {
        chatData.add(room);
    }
}

