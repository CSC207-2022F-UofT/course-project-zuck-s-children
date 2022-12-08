package chat.presenter;

import java.awt.GraphicsEnvironment;
import ui.ChatRoomUI;

public class ChatRoomPresenter implements MsgOutBoundary {

    ChatRoomUI chatRoom;

    public ChatRoomPresenter(ChatRoomUI chatroom){
        this.chatRoom = chatroom;
    }

    /**
     * Update the view of a room with a model that represents a list of messages
     * @param responseModel message output model
     * @param roomId room id
     */

    @Override
    public void open(MsgOutModel responseModel, String roomId) {
        if(!GraphicsEnvironment.isHeadless()) {
            chatRoom.setRoomId(roomId);
            chatRoom.setFrame();
            chatRoom.build();
            chatRoom.setListOfMessages(responseModel.getMsgList());
        }
    }

    public void overwrite(MsgOutModel responseModel){
        chatRoom.setListOfMessages(responseModel.getMsgList());
    }
}