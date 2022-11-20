package chat.control;

import chat.useCases.OpenListBoundary;
import chat.useCases.OpenRoomBoundary;

public class ChatRoomOpenContoller {
    private OpenRoomBoundary chatRoomInteractor;

    public ChatRoomOpenContoller(OpenRoomBoundary chatRoomInterator){
        this.chatRoomInteractor = chatRoomInteractor;
    }

    public void navigate(RoomInModel roomModel){
        chatRoomInteractor.open(roomModel);
    }
}
