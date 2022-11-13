package chat.control;

public class RoomLeaveController {
    private LeaveInBoundary leaveBoundary;

    public RoomLeaveController(LeaveInBoundary leaveInteractor){
        this.leaveBoundary = leaveInteractor;
    }

    public void sendMessage(LeaveInModel leaveModel){
        leaveBoundary.leaveRoom(leaveModel);
    }
}
