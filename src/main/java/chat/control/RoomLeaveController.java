package chat.control;

public class RoomLeaveController {
    private LeaveInBoundary leaveBoundary;

    public RoomLeaveController(LeaveInBoundary leaveInteractor){
        this.leaveBoundary = leaveInteractor;
    }

    public void leaveRoom(LeaveInModel leaveModel){
        leaveBoundary.leaveRoom(leaveModel);
    }
}
