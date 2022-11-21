package Notification.EnterChat;

public class EnterChatInteractor implements EnterChatInputBoundary {
    @Override
    public void enterChat() {
        //open chatroom
        chatRoomInteractor.open();

    }
}
