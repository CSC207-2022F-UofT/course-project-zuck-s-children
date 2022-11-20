package chat.useCases;

import chat.control.*;
import chat.entities.ChatRoomEnt;
import data.persistency.ChatDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomOpenInteractor implements OpenRoomBoundary {
    private ChatDataAccessInterface chatDataAccess;
    private RoomOutBoundary roomPresenter;

    /**
     * Construct the interactor for opening a chat room.
     * @param roomPresenter
     * @param chatDataAccess
     */
    public ChatRoomOpenInteractor (RoomOutBoundary roomPresenter, ChatDataAccessInterface chatDataAccess){
        this.roomPresenter = roomPresenter;
        this.chatDataAccess = chatDataAccess;
    }

    /**
     * Open a chatroom.
     * @param roomModel
     */
    @Override
    public void open(RoomInModel roomModel) {
        RoomOutModel responseModel = new RoomOutModel(fetch(roomModel));
        roomPresenter.update(responseModel);
    }

    private List<Object> fetch(RoomInModel roomModel) {
        List<Object> room;
        try {
            room = ((ChatRoomEnt)chatDataAccess.loadRoomById(roomModel.getId())).getMessages();
        } catch (Throwable NoRoomFound) {
            return new ArrayList<Object>();
        }

        return room;
    }
}
