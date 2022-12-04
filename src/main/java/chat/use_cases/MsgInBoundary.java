package chat.use_cases;

import chat.control.MsgInModel;

public interface MsgInBoundary {
    void sendMessage(MsgInModel msgModel);
}