package chat.presenter;

import chat.entities.MessageEnt;

import java.util.List;

public class MsgOutModel {
    private final List<MessageEnt> msgList;

    /**
     * Construct an output model for a list of messages
     * @param msg a list of message entities
     */
    public MsgOutModel(List<MessageEnt> msg){
        this.msgList = msg;
    }

    /**
     * Return the list of messages represented by this model
     * @return the list of messages
     */
    public List<MessageEnt> getMsgList(){return this.msgList;}

}