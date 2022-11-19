package chat.control;

import chat.useCases.MsgInBoundary;

public class MsgSendController {
    private MsgInBoundary msgBoundary;

    public MsgSendController(MsgInBoundary msgInteractor){
        this.msgBoundary = msgInteractor;
    }

    public void sendMessage(MsgInModel msgModel){
        msgBoundary.sendMessage(msgModel);
    }
}
