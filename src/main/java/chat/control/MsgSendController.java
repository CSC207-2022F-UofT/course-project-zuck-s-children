package chat.control;

import chat.use_cases.MsgInBoundary;

public class MsgSendController {
    private final MsgInBoundary msgBoundary;

    /**
     * Construct a controller to send a message
     * @param msgInteractor interactor for senting a message
     */
    public MsgSendController(MsgInBoundary msgInteractor){
        this.msgBoundary = msgInteractor;
    }

    /**
     * Send message represented by the model
     * @param msgModel a message model
     */
    public void sendMessage(MsgInModel msgModel){
        msgBoundary.sendMessage(msgModel);
    }
}