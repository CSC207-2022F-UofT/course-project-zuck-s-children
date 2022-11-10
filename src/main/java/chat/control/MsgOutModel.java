package chat.control;

import chat.entities.MessageEnt;

import java.util.List;

public class MsgOutModel {
    private List<MessageEnt> msgList;
    public MsgOutModel(List<MessageEnt> l, MessageEnt newMessage){
        l.add(newMessage);
        this.msgList = l;
    }
    public List<MessageEnt> getMsgList(){return this.msgList;}

}
