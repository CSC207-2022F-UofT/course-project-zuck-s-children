package chat.use_cases;

import account_creation.Account;
import chat.control.MsgInModel;
import chat.presenter.MsgOutBoundary;
import chat.presenter.MsgOutModel;
import chat.entities.ChatRoomEnt;
import chat.entities.MessageEnt;
import chat.entities.MessageFactory;
import data_persistency.ChatDataAccessInterface;
import data_persistency.UserDatabase;
import notification.Entities.ChatNotification;

import java.time.LocalDateTime;
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
        Account curr = UserDatabase.getUserDatabase().getCurrentUser();
        LocalDateTime now = LocalDateTime.now();
        // Add a new message to the data entity and send a notification
        room.addMessage(newMessage);
        room.getOtherUser().addNotification(
                new ChatNotification("New message has arrived!" ,curr, now, room.getId()));
        List<MessageEnt> chatList = room.getMessages();
        MsgOutModel responseModel = new MsgOutModel(chatList);
        msgPresenter.overwrite(responseModel);
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