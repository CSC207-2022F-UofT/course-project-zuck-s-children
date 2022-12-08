package chat.use_cases;

import chat.control.*;
import chat.entities.ChatRoomEnt;
import chat.entities.MessageEnt;
import chat.presenter.MsgOutBoundary;
import chat.presenter.MsgOutModel;
import data.persistency.ChatDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomOpenInteractor implements OpenRoomBoundary {
    private final ChatDataAccessInterface chatDataAccess;
    private final MsgOutBoundary roomPresenter;

    /**
     * Construct the interactor for opening a chat room.
     * @param roomPresenter a presenter to open a chat room
     * @param chatDataAccess data access to chat database
     */
    public ChatRoomOpenInteractor (MsgOutBoundary roomPresenter, ChatDataAccessInterface chatDataAccess){
        this.roomPresenter = roomPresenter;
        this.chatDataAccess = chatDataAccess;
    }

    /**
     * Open a chatroom.
     * @param roomModel a chat room model
     */
    @Override
    public MsgOutModel open(RoomInModel roomModel) {
        MsgOutModel responseModel = new MsgOutModel(fetch(roomModel));
        roomPresenter.open(responseModel, roomModel.getId());
        return responseModel;
    }

    private List<MessageEnt> fetch(RoomInModel roomModel) {
        try {
            return ((ChatRoomEnt) chatDataAccess.loadRoomById(roomModel.getId())).getMessages();
        }catch(Throwable NoRoomFound){
            return new ArrayList<>();
        }
    }
}