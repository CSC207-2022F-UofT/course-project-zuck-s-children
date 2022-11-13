package chat.useCases;

import chat.control.LeaveInBoundary;
import chat.control.LeaveInModel;
import chat.control.LeaveOutBoundary;
import chat.control.LeaveOutModel;
import data.persistency.ChatDataAccessInterface;

import java.util.List;

public class RoomLeaveInteractor implements LeaveInBoundary {
    private static ChatDataAccessInterface chatDataAccess;
    private LeaveOutBoundary leavePresenter;

    public RoomLeaveInteractor(LeaveOutBoundary leavePresenter){
        this.leavePresenter = leavePresenter;
    }
    @Override
    public void leaveRoom(LeaveInModel leaveModel) {
        LeaveOutModel responseModel = new LeaveOutModel(fetch(), leaveModel.getId());
        leavePresenter.update(responseModel);
    }

    private List<String> fetch(){
        // TODO: fetch chatroom data using chatDataAccess
        // TODO: clean the data into List<String>
        return null;
    }

}
