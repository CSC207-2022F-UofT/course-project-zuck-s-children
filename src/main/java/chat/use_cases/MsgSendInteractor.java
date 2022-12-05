package chat.use_cases;

import account_creation.Account;
import chat.control.MsgInModel;
import chat.presenter.MsgOutBoundary;
import chat.presenter.MsgOutModel;
import chat.entities.ChatRoomEnt;
import chat.entities.MessageEnt;
import chat.entities.MessageFactory;
import data.persistency.ChatDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class MsgSendInteractor implements MsgInBoundary {
    private static final MessageFactory msgFactory = new MessageFactory();
    private final ChatDataAccessInterface chatDataAccess;
    private final MsgOutBoundary msgPresenter;

    /**
     * Constract an interactor for sending a message
     * @param msgPresenter a presenter for a message
     * @param chatDataAccess a data access to the chat database
     */
    public MsgSendInteractor(MsgOutBoundary msgPresenter, ChatDataAccessInterface chatDataAccess){
        this.msgPresenter = msgPresenter;
        this.chatDataAccess = chatDataAccess;
    }

    /**
     * Send a message to the room and update the database
     * @param msgModel message input model
     */
    @Override
    public void sendMessage(MsgInModel msgModel) {
        MessageEnt newMessage = msgFactory.create(msgModel);
        ChatRoomEnt room = fetch(newMessage.getRoomId());


        // Add a new message to the data entity
        room.addMessage(newMessage);
        System.out.println(newMessage.getInfo()[0]+" sent from " + newMessage.getInfo()[1]);

        List<MessageEnt> chatList = room.getMessages();
        MsgOutModel responseModel = new MsgOutModel(chatList);
        msgPresenter.overwrite(responseModel, newMessage.getRoomId());
    }
    private ChatRoomEnt fetch(String rid) {
        ChatRoomEnt room;
        try {
            room = (ChatRoomEnt)chatDataAccess.loadRoomById(rid);
        } catch (Throwable NoRoomFound) {
            return null;
        }
        return room;
    }
}