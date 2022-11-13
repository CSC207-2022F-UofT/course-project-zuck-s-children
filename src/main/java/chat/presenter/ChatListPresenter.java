package chat.presenter;

import UI.ViewModel;
import chat.control.LeaveOutBoundary;
import chat.control.LeaveOutModel;

public class ChatListPresenter implements LeaveOutBoundary {
    ViewModel chatList;

    public ChatListPresenter(ViewModel UI){
        this.chatList = UI;
    }

    @Override
    public void update(LeaveOutModel responseModel) {
        // TODO: update UI using a responseModel
    }
}
