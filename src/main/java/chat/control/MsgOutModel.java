package chat.control;

import chat.entities.MessageEnt;

import java.util.List;

public class MsgOutModel {
    private List<Object> msgList;

    /**
     * Construct an output model for a list of messages
     * @param msg
     */
    public MsgOutModel(List<Object> msg){
        this.msgList = msg;
    }

    /**
     * Return the list of messages represented by this model
     * @return
     */
    public List<Object> getMsgList(){return this.msgList;}

}
