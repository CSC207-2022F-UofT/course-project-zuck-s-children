package chat.control;

import chat.use_cases.RoomInBoundary;

public class RoomLeaveController {
    private RoomInBoundary leaveBoundary;

    /**
     * Construct a controller to leave a chat room
     * @param leaveInteractor
     */
    public RoomLeaveController(RoomInBoundary leaveInteractor){
        this.leaveBoundary = leaveInteractor;
    }

    /**
     * Leave room represented by the room model and the account model
     * @param leaveModel
     * @param accModel
     */
    public void leaveRoom(RoomInModel leaveModel, AccountInModel accModel){
        leaveBoundary.leaveRoom(leaveModel, accModel);
    }
}
