package chat.presenter;

import UI.ChatListUI;
import chat.control.RoomOutBoundary;
import chat.control.RoomOutModel;

import javax.swing.*;

public class ChatListPresenter implements RoomOutBoundary {
    ChatListUI chatList;
    JPanel panel;

    /**
     * Construct a presenter for a chat list
     * @param panel
     * @param UI
     */
    public ChatListPresenter(JPanel panel, ChatListUI UI){
        this.chatList = UI;
        this.panel = panel;
    }

    /**
     * Update the view of a room list with a model that represents a list of rooms
     */
    @Override
    public void update() {
        chatList.build();
    }
}
