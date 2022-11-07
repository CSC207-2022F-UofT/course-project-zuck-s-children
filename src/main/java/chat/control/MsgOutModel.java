package chat.control;

import chat.entities.MessageEnt;

import java.util.List;

public class MsgOutModel {
    List<MessageEnt> msgList;
    public MsgOutModel(List<MessageEnt> l){
        this.msgList = l;
    }
}
