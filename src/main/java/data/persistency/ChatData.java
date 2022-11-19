package data.persistency;

import chat.entities.ChatRoomEnt;

import java.util.List;

public class ChatData {
    private List<Object> chatData;

    public ChatData(List<Object> rooms){
        this.chatData = rooms;
    }
    public Object find(String rid) throws Throwable {
        for(Object room : chatData){
            if (((ChatRoomEnt)room).getId() == rid){
                return room;
            }
        }
        throw new NoRoomFound();
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

    public List<Object> getAllRooms(){
        return this.chatData;
    }
    public
    class NoRoomFound extends Exception{

    }
}
