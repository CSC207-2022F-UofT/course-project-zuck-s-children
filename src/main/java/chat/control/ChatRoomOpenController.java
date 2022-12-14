package chat.control;

import chat.use_cases.OpenRoomBoundary;

public class ChatRoomOpenController {
    private final OpenRoomBoundary chatRoomInteractor;

    /**
     * Construct a controller to open a chat room
     * @param chatRoomInteractor
     */
    public ChatRoomOpenController(OpenRoomBoundary chatRoomInteractor){
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