package chat.entities;

import chat.control.MsgInModel;

public class MessageFactory {
    public MessageEnt create(MsgInModel msgModel) {
        return new MessageEnt(msgModel.getContent(), msgModel.getSender());
    }
}
