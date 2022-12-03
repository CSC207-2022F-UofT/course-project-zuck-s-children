package chat.use_cases;

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
        List<Object> list = fetch(leaveModel, accModel);
        RoomOutModel responseModel = new RoomOutModel(list);
        leavePresenter.update(responseModel);
    }

    private List<Object> fetch(RoomInModel leave, AccountInModel acc){
        chatDataAccess.getChatData().removeRoom(leave.getId());
        List<Object> room;
        try {
            room = chatDataAccess.loadRoomByAccount(acc.getAccount());
        } catch (Throwable NoRoomFound) {
            return new ArrayList<Object>();
        }

        List<Object> result = new ArrayList<Object> ();
        for (Object elem : room){
            result.add(((ChatRoomEnt)elem).toString(acc.getAccount().getUsername()));
        }
        return result;
    }

}
