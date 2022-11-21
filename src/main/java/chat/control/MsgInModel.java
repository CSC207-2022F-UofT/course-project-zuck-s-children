package chat.control;

import AccountCreation.Account;

public class MsgInModel {
    private String content;
    private Account sender;
    private String roomId;

    public MsgInModel(String s, Account sender, String roomId){
        this.content = s;
        this.sender = sender;
        this.roomId = roomId;
    }

    public String getContent(){
        return this.content;
    }

    public Account getSender(){
        return this.sender;
    }
    public String getRoomId() { return this.roomId; }
}
