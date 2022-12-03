package chat.useCases;

import chat.control.MsgInModel;
import chat.control.MsgOutBoundary;
import chat.control.MsgOutModel;
import chat.entities.ChatRoomEnt;
import chat.entities.MessageEnt;
import chat.entities.MessageFactory;
import data.persistency.ChatDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class MsgSendInteractor implements MsgInBoundary {
    private static final MessageFactory msgFactory = new MessageFactory();
    private ChatDataAccessInterface chatDataAccess;
    private MsgOutBoundary msgPresenter;

    /**
     * Constract an interactor for sending a message
     * @param msgPresenter
     * @param chatDataAccess
     */
    public MsgSendInteractor(MsgOutBoundary msgPresenter, ChatDataAccessInterface chatDataAccess){
        this.msgPresenter = msgPresenter;
        this.chatDataAccess = chatDataAccess;
    }

    /**
     * Send a message to the room and update the database
     * @param msgModel
     */
    @Override
    public void sendMessage(MsgInModel msgModel) {
        MessageEnt newMessage = msgFactory.create(msgModel);
        ChatRoomEnt room = fetch(newMessage.getRoomId());

        /**
         * Add a new message to the data entity
         */
        room.addMessage(newMessage);

        /**
         * Get
         */
        List<Object> chatList = room.getMessages();
        for(int i = 0; i < chatList.size(); i++){
            MessageEnt message = (MessageEnt)chatList.get(i);
            chatList.set(i, new String[]{message.getSender().getUsername(), message.getContent()});
        }
        chatList.add(newMessage.getInfo());
        MsgOutModel responseModel = new MsgOutModel(chatList);
        msgPresenter.update(responseModel, newMessage.getRoomId());
    }
    private ChatRoomEnt fetch(String rid) {
        Object room;
        try {
            room = chatDataAccess.loadRoomById(rid);
        } catch (Throwable NoRoomFound) {
            return null;
        }
        return (ChatRoomEnt) room;
    }
}
