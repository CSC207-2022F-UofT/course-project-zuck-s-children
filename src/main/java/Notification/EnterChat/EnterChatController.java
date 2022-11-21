package Notification.EnterChat;

public class EnterChatController {
    private EnterChatInputBoundary interactor;

    public EnterChatController(EnterChatInputBoundary enterChatIBr){
        this.interactor = enterChatIBr;
    }

    public void enterChat(){
        this.interactor.enterChat();
    }

}
