package chat.useCases;

import chat.control.*;
import chat.entities.ChatRoomEnt;
import data.persistency.ChatDataAccess;
import data.persistency.ChatDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomOpenInteractor implements OpenRoomBoundary {
    private ChatDataAccessInterface chatDataAccess;
    private MsgOutBoundary roomPresenter;

    /**
     * Construct the interactor for opening a chat room.
     * @param roomPresenter
     * @param chatDataAccess
     */
    public ChatRoomOpenInteractor (MsgOutBoundary roomPresenter, ChatDataAccessInterface chatDataAccess){
        this.roomPresenter = roomPresenter;
        this.chatDataAccess = chatDataAccess;
    }

    /**
     * Open a chatroom.
     * @param roomModel
     */
    @Override
    public void open(RoomInModel roomModel) {
        MsgOutModel responseModel = new MsgOutModel(fetch(roomModel));
        roomPresenter.update(responseModel, roomModel.getId());
    }

    private List<Object> fetch(RoomInModel roomModel) {
        try {
            return ((ChatRoomEnt) chatDataAccess.loadRoomById(roomModel.getId())).getMessages();
        }catch(Throwable NoRoomFound){
            return new ArrayList<>();
        }
    }
}
