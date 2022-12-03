package chat.useCases;

import chat.control.AccountInModel;
import chat.control.RoomInModel;
import chat.control.RoomOutBoundary;
import chat.control.RoomOutModel;
import chat.entities.ChatRoomEnt;
import data.persistency.ChatDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class RoomLeaveInteractor implements RoomInBoundary {
    private static ChatDataAccessInterface chatDataAccess;
    private RoomOutBoundary leavePresenter;

    /**
     * Construct an interactor to leave a room
     * @param leavePresenter
     */
    public RoomLeaveInteractor(RoomOutBoundary leavePresenter){
        this.leavePresenter = leavePresenter;
    }

    /**
     * Leave the room represented by the models
     * @param leaveModel
     * @param accModel
     */
    @Override
    public void leaveRoom(RoomInModel leaveModel, AccountInModel accModel) {
        List<Object> list = fetch(leaveModel);
        RoomOutModel responseModel = new RoomOutModel(list);
        leavePresenter.update();
    }

    private List<Object> fetch(RoomInModel leave){
        chatDataAccess.getChatData().removeRoom(leave.getId());
        List<Object> room = chatDataAccess.loadRoomByAccount();
        return room;
    }

}
