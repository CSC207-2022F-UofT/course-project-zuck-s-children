package chat.presenter;

import UI.ViewModel;
import chat.control.MsgOutBoundary;
import chat.control.MsgOutModel;

public class ChatRoomPresenter implements MsgOutBoundary {
    ViewModel chatRoom;

    public ChatRoomPresenter(ViewModel UI){
        this.chatRoom = UI;
    }
    @Override
    public MsgOutModel update(MsgOutModel responseModel) {
        // TODO: update UI using responseModel
        return null;
    }
}
