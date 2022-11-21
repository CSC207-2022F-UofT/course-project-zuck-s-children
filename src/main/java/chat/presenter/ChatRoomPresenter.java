package chat.presenter;

import UI.ChatRoomUI;
import chat.control.MsgOutBoundary;
import chat.control.MsgOutModel;

import javax.swing.*;

public class ChatRoomPresenter implements MsgOutBoundary {
    ChatRoomUI chatRoom;
    JPanel panel;
    public ChatRoomPresenter(JPanel panel, ChatRoomUI UI){
        this.panel = panel;
        this.chatRoom = UI;
    }
    @Override
    public void update(MsgOutModel responseModel) {
        chatRoom.build(panel, responseModel.getMsgList());
    }
}
