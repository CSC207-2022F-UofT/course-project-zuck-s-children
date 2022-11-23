package chat.control;

import AccountCreation.Account;

public class MsgInModel {
    private String content;
    private Account sender;
    private String roomId;

    /**
     * Construct a message model
     * @param s
     * @param sender
     * @param roomId
     */
    public MsgInModel(String s, Account sender, String roomId){
        this.content = s;
        this.sender = sender;
        this.roomId = roomId;
    }

    /**
     * Get the content of this message model
     * @return
     */
    public String getContent(){
        return this.content;
    }

    /**
     * Get the sender of this message model
     * @return
     */
    public Account getSender(){
        return this.sender;
    }

    /**
     * Get the id of the room of this message model
     * @return
     */
    public String getRoomId() { return this.roomId; }
}
