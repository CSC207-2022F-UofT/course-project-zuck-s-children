package chat.presenter;

import UI.ChatListUI;
import chat.control.RoomOutBoundary;
import chat.control.RoomOutModel;

import javax.swing.*;

public class ChatListPresenter implements RoomOutBoundary {
    ChatListUI chatList;
    JPanel panel;
    public ChatListPresenter(JPanel panel, ChatListUI UI){
        this.chatList = UI;
        this.panel = panel;
    }

    @Override
    public void update(RoomOutModel responseModel) {
        chatList.build(panel, responseModel.getRoomList());
    }
}
