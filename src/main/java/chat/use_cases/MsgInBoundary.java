package chat.use_cases;

import chat.control.MsgInModel;
import chat.presenter.MsgOutModel;

public interface MsgInBoundary {
    MsgOutModel sendMessage(MsgInModel msgModel);
}