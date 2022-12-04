package chat.presenter;

import ui.ChatRoomUI;

import javax.swing.*;

public class ChatRoomPresenter implements MsgOutBoundary {
    ChatRoomUI chatRoom;
    JPanel panel;

    /**
     * Construct a presenter for a chat room
     */
    public ChatRoomPresenter(){
        this.panel = new JPanel();
        this.chatRoom = new ChatRoomUI();
    }

    /**
     * Update the view of a room with a model that represents a list of messages
     * @param responseModel message output model
     * @param roomId room id
     */
    @Override
    public void update(MsgOutModel responseModel, String roomId) {
        chatRoom.setRoomId(roomId);
        chatRoom.build(panel);
    }


}