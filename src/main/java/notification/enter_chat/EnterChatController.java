package notification.enter_chat;

import account_creation.Account;
import chat.control.AccountInModel;
import chat.control.ChatListOpenController;
import notification.clear_notif.*;
import notification.show_notif.*;
public class EnterChatController {
    public ChatListOpenController chatOpenController; //passes in ChatListOpenController initialized in main
    private Account account;

    /**
     * Create a constructor to enter the chatroom.
     * @param chatOpen a ChatListOpenController to call on chatList use case
     * @param acc the current user's account
     */
    public EnterChatController(ChatListOpenController chatOpen, Account acc){
        this.chatOpenController = chatOpen;
        this.account = acc;
    }

    /**
     * Enter the chatroom.
     */
    public void enterChatRoom(){
        AccountInModel accountModel = new AccountInModel(this.account);
        this.chatOpenController.navigate(accountModel);
    }

}
