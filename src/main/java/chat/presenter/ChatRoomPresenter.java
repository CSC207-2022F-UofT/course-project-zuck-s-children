package chat.presenter;

import ui.ChatRoomUI;

import javax.swing.*;

public class ChatRoomPresenter implements MsgOutBoundary {
    static ChatRoomUI chatRoom = new ChatRoomUI();
    JFrame frame;


    /**
     * Update the view of a room with a model that represents a list of messages
     * @param responseModel message output model
     * @param roomId room id
     */
    @Override
    public void update(MsgOutModel responseModel, String roomId) {
        this.frame = new JFrame(roomId);
        chatRoom.setRoomId(roomId);
        chatRoom.build(frame);
    }
}