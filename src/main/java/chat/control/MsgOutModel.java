package chat.control;

import chat.entities.MessageEnt;

import java.util.List;

public class MsgOutModel {
    private List<Object> msgList;
    public MsgOutModel(List<Object> msg){
        this.msgList = msg;
    }
    public List<Object> getMsgList(){return this.msgList;}

}
