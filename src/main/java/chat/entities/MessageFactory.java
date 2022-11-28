package chat.entities;

import chat.control.MsgInModel;

public class MessageFactory {
    /**
     * Build a message entity represented by the model
     * @param msgModel
     * @return
     */
    public MessageEnt create(MsgInModel msgModel) {
        return new MessageEnt(msgModel.getContent(), msgModel.getSender(), msgModel.getRoomId());
    }
}
