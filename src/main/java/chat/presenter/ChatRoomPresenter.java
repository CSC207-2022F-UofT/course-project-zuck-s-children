package chat.presenter;

import UI.ChatRoomUI;
import chat.control.MsgOutBoundary;
import chat.control.MsgOutModel;

public class ChatRoomPresenter implements MsgOutBoundary {
    ChatRoomUI chatRoom;

    public ChatRoomPresenter(ChatRoomUI UI){
        this.chatRoom = UI;
    }
    @Override
    public void update(MsgOutModel responseModel) {
        chatRoom.build(responseModel.getMsgList());
    }
}
