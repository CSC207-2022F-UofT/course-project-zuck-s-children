package chat.entities;

import chat.control.AccountInModel;
import chat.control.MsgInModel;
import chat.control.RoomInModel;

public class ChatRoomFactory {
    public ChatRoomEnt create(AccountInModel user1, AccountInModel user2){
        return new ChatRoomEnt(user1.getAccount(), user2.getAccount());
    }
}
