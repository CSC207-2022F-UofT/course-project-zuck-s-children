package Notification.EnterChat;

import AccountCreation.Account;
import chat.control.AccountInModel;
import chat.control.ChatListOpenController;
public class EnterChatController {
    public ChatListOpenController chatOpenController; //passes in ChatListOpenController initialized in main
    private Account account;

    public EnterChatController(ChatListOpenController chatOpen, Account acc){
        this.chatOpenController = chatOpen;
        this.account = acc;

    }
    public void enterChatRoom(){
        AccountInModel accountModel = new AccountInModel(this.account);
        this.chatOpenController.navigate(accountModel);
    }

}
