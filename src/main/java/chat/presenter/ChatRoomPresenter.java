package chat.presenter;

import UI.ChatRoomUI;
import chat.control.*;
import chat.entities.ChatRoomEnt;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
     * @param responseModel
     */
    @Override
    public void update(MsgOutModel responseModel, String roomId) {
        chatRoom.setRoomId(roomId);
        chatRoom.build(panel, responseModel.getMsgList());
    }


}
