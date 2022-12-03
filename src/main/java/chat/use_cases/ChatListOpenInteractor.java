package chat.use_cases;

import chat.control.AccountInModel;
import chat.control.RoomOutBoundary;
import chat.control.RoomOutModel;
import chat.entities.ChatRoomEnt;
import data.persistency.ChatDataAccessInterface;

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
     * @param acc
     */
    @Override
    public void open(AccountInModel acc) {
        RoomOutModel responseModel = new RoomOutModel(fetch(acc));
        listPresenter.update(responseModel);
    }

    private List<Object> fetch(AccountInModel acc) {
        List<Object> room;
        try {
            room = chatDataAccess.loadRoomByAccount(acc.getAccount());
        } catch (Throwable NoRoomFound) {
            return new ArrayList<Object>();
        }

        List<Object> result = new ArrayList<Object> ();
        for (Object elem : room){
            result.add(((ChatRoomEnt)elem).toString(acc.getAccount().getUsername()));
        }
        return result;
    }
}
