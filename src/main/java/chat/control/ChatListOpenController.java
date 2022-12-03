package chat.control;

import chat.useCases.OpenListBoundary;

public class ChatListOpenController {
    private OpenListBoundary chatListInteractor;

    /**
     * Construct a controller to open a chat list
     * @param chatListInterator
     */
    public ChatListOpenController(OpenListBoundary chatListInterator){
        this.chatListInteractor = chatListInteractor;
    }

    /**
     * Open the chat list corresponding to the account
     * @param accModel
     */
    public void navigate(AccountInModel accModel){
        chatListInteractor.open();
    }
}
