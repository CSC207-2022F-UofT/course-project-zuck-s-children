package chat.entities;

import chat.control.AccountInModel;

public class ChatRoomFactory {
    public ChatRoomEnt create(AccountInModel user1, AccountInModel user2){
        return new ChatRoomEnt(user1.getAccount(), user2.getAccount());
    }
}