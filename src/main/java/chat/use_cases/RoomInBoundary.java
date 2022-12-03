package chat.use_cases;

import chat.control.AccountInModel;
import chat.control.RoomInModel;

/**
 * A public interface of InputBoundary for leaving a chat room
 */
public interface RoomInBoundary {
    void leaveRoom(RoomInModel leaveModel, AccountInModel accModel);
}
