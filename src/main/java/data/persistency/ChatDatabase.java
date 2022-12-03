package data.persistency;

import AccountCreation.Account;
import chat.entities.ChatRoomEnt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatDatabase implements Serializable {
    private static List<Object> chatData;

    public ChatDatabase(List<Object> rooms){
        this.chatData = rooms;
    }
    public Object findById(String rid) {
        Object roomFound = null;
        for(Object room : chatData){
            if (((ChatRoomEnt)room).getId() == rid){
                roomFound = room;
            }
        }
        return roomFound;
    }
    public List<Object> findByAccount(Account acc)  {
        List<Object> roomList = new ArrayList<Object>();
        for(Object room : chatData){
            if (((ChatRoomEnt)room).getParticipants().checkParticipant(acc)){
                roomList.add(room);
            }
        }
        return roomList;
    }

    public void removeRoom(String rid){
        int index = -1;
        for (int i = 0 ; i < this.chatData.size(); i++){
            if (((ChatRoomEnt)this.chatData.get(i)).getId() == rid){
                index = i;
            }
        }
        if(index != -1){
            this.chatData.remove(index);
        }
    }
    
}
