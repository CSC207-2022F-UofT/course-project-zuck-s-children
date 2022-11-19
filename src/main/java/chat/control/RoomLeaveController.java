package chat.control;

import AccountCreation.Account;
import chat.useCases.RoomInBoundary;

public class RoomLeaveController {
    private RoomInBoundary leaveBoundary;

    public RoomLeaveController(RoomInBoundary leaveInteractor){
        this.leaveBoundary = leaveInteractor;
    }

    public void leaveRoom(RoomInModel leaveModel, AccountInModel accModel){
        leaveBoundary.leaveRoom(leaveModel, accModel);
    }
}
