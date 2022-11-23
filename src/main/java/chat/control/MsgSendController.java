package chat.control;

import chat.useCases.MsgInBoundary;

public class MsgSendController {
    private MsgInBoundary msgBoundary;

    /**
     * Construct a controller to send a message
     * @param msgInteractor
     */
    public MsgSendController(MsgInBoundary msgInteractor){
        this.msgBoundary = msgInteractor;
    }

    /**
     * Send message represented by the model
     * @param msgModel
     */
    public void sendMessage(MsgInModel msgModel){
        msgBoundary.sendMessage(msgModel);
    }
}
