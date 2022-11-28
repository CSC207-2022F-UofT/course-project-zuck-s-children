package chat.control;

import chat.useCases.OpenListBoundary;
import chat.useCases.OpenRoomBoundary;

public class ChatRoomOpenContoller {
    private OpenRoomBoundary chatRoomInteractor;

    /**
     * Construct a controller to open a chat room
     * @param chatRoomInterator
     */
    public ChatRoomOpenContoller(OpenRoomBoundary chatRoomInterator){
        this.chatRoomInteractor = chatRoomInteractor;
    }

    /**
     * Open a chat room represented by the model
     * @param roomModel
     */
    public void navigate(RoomInModel roomModel){
        chatRoomInteractor.open(roomModel);
    }
}
