package chat.presenter;

import chat.control.MsgSendController;
import chat.use_cases.MsgInBoundary;
import chat.use_cases.MsgSendInteractor;
import data.persistency.ChatDataAccess;
import ui.ChatRoomUI;

import javax.swing.*;

public class ChatRoomPresenter implements MsgOutBoundary {

    MsgInBoundary msgInBoundary = new MsgSendInteractor(this, new ChatDataAccess());
    MsgSendController msgSendController = new MsgSendController(msgInBoundary);
    ChatRoomUI chatRoom = new ChatRoomUI(msgInBoundary, msgSendController);
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

    public void overwrite(MsgOutModel responseModel, String roomId){
        chatRoom.setRoomId(roomId);
        chatRoom.build(frame);
    }
}