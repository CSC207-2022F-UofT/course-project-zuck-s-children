package chat.useCases;

import chat.control.MsgInBoundary;
import chat.control.MsgInModel;
import chat.control.MsgOutBoundary;
import chat.control.MsgOutModel;
import chat.entities.MessageEnt;
import chat.entities.MessageFactory;
import data.persistency.ChatDataAccessInterface;

import java.util.List;

public class MsgSendInteractor implements MsgInBoundary {
    private static final MessageFactory msgFactory = new MessageFactory();
    private static ChatDataAccessInterface chatDataAccess;
    private MsgOutBoundary msgPresenter;
    private MsgInModel msgModel;

    public MsgSendInteractor(MsgInModel msgModel, MsgOutBoundary msgPresenter){
        this.msgPresenter = msgPresenter;
        this.msgModel = msgModel;
    }
    @Override
    public void sendMessage(MsgInModel msgModel) {
        MsgOutModel responseModel = new MsgOutModel(fetch());
        msgPresenter.update(responseModel);
    }
    private List<MessageEnt> fetch(){
        // TODO: fetch chatroom data using chatDataAccess
        return null;
    }
}
