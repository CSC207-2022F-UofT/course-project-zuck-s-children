package chat.control;

import chat.useCases.OpenListBoundary;

public class ChatListOpenController {
    private OpenListBoundary chatListInteractor;

    public ChatListOpenController(OpenListBoundary chatListInterator){
        this.chatListInteractor = chatListInteractor;
    }

    public void navigate(AccountInModel accModel){
        chatListInteractor.open(accModel);
    }
}
