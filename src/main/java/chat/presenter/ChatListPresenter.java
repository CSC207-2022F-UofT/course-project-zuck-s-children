package chat.presenter;

import UI.ChatListUI;
import chat.control.RoomOutBoundary;
import chat.control.RoomOutModel;

public class ChatListPresenter implements RoomOutBoundary {
    ChatListUI chatList;

    public ChatListPresenter(ChatListUI UI){
        this.chatList = UI;
    }

    @Override
    public void update(RoomOutModel responseModel) {
        chatList.build(responseModel.getRoomList());
    }
}
