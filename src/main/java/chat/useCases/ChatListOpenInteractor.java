package chat.useCases;

import chat.control.AccountInModel;
import chat.control.RoomOutBoundary;
import chat.control.RoomOutModel;
import chat.entities.ChatRoomEnt;
import data.persistency.ChatDataAccessInterface;
import data.persistency.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class ChatListOpenInteractor implements OpenListBoundary {
    private ChatDataAccessInterface chatDataAccess;
    private RoomOutBoundary listPresenter;

    /**
     * Construct the interactor for opening a chat list.
     * @param listPresenter
     * @param chatDataAccess
     */
    public ChatListOpenInteractor (RoomOutBoundary listPresenter, ChatDataAccessInterface chatDataAccess){
        this.listPresenter = listPresenter;
        this.chatDataAccess = chatDataAccess;
    }

    /**
     * Open the list of chatrooms that the user has joined.
     */
    @Override
    public void open() {
        listPresenter.update();
    }

}
