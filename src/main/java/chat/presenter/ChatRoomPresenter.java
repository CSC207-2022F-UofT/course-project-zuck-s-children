package chat.presenter;

import chat.control.MsgSendController;
import chat.use_cases.MsgInBoundary;
import chat.use_cases.MsgSendInteractor;
import data_persistency.ChatDataAccess;
import ui.ChatRoomUI;

import javax.swing.*;

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
        chatRoom.setRoomId(roomId);
        chatRoom.setFrame();
        chatRoom.build();
        chatRoom.setListOfMessages(responseModel.getMsgList());
    }

    public void overwrite(MsgOutModel responseModel){
        chatRoom.setListOfMessages(responseModel.getMsgList());
    }
}