package chat.presenter;

import ui.ChatRoomUI;
import chat.control.MsgOutBoundary;
import chat.control.MsgOutModel;

import javax.swing.*;

public class ChatRoomPresenter implements MsgOutBoundary {
    ChatRoomUI chatRoom;
    JPanel panel;

    /**
     * Construct a presenter for a chat room
     * @param panel
     * @param UI
     */
    public ChatRoomPresenter(JPanel panel, ChatRoomUI UI){
        this.panel = panel;
        this.chatRoom = UI;
    }

    /**
     * Update the view of a room with a model that represents a list of messages
     * @param responseModel
     */
    @Override
    public void update(MsgOutModel responseModel) {
        chatRoom.build(panel, responseModel.getMsgList());
    }
}
