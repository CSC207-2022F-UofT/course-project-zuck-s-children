package chat.presenter;

import java.util.List;

public class MsgOutModel {
    private final List<Object> msgList;

    /**
     * Construct an output model for a list of messages
     * @param msg a list of message entities
     */
    public MsgOutModel(List<Object> msg){
        this.msgList = msg;
    }

    /**
     * Return the list of messages represented by this model
     * @return the list of messages
     */
    public List<Object> getMsgList(){return this.msgList;}

}