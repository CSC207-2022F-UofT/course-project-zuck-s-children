package chat.useCases;

import chat.control.MsgInModel;

public interface MsgInBoundary {
    void sendMessage(MsgInModel msgModel);
}
