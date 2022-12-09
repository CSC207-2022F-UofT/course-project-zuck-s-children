package chat.use_cases;

import chat.control.RoomInModel;
import chat.presenter.MsgOutModel;

public interface OpenRoomBoundary {
    MsgOutModel open(RoomInModel room);
}