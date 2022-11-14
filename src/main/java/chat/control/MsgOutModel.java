package chat.control;

import chat.entities.MessageEnt;

import java.util.List;

public class MsgOutModel {
    private List<String[]> msgList;
    public MsgOutModel(List<String[]> msg, String[] info){
        msg.add(info);
        this.msgList = msg;
    }
    public List<String[]> getMsgList(){return this.msgList;}

}
