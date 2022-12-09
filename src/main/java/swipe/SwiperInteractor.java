package swipe;
//
import account_and_login.account_creation.Account;
import chat.entities.ChatRoomEnt;
import data.persistency.ChatDataAccessInterface;
import notification.Entities.MatchNotification;
import data.persistency.UserDatabase;


import java.time.LocalDateTime;



/**
 * An interactor class that implements interface SwiperInputBoundary
 */
public class SwiperInteractor implements SwiperInputBoundary{

    /**
     * A presenter
     */
    private final SwiperPresenter swiperPresenter;

    /**
     * a chatDataAccess interface attribute
     */
    private final ChatDataAccessInterface chatDataAccess;

    /**
     * A constructor that initializes attribute swiperPresenter and chatDataAccess
     * @param swiperPresenter
     * @param chatDataAccess
     */
    public SwiperInteractor(SwiperPresenter swiperPresenter, ChatDataAccessInterface chatDataAccess){
        this.swiperPresenter = swiperPresenter;
        this.chatDataAccess = chatDataAccess;
    }

    /**
     * Overridden create method from interface, returns/creates a SwiperResponseModel based on input SwiperRequestModel.
     * Adds a notification to accounts and creates a chat if both accepted each other.
     * @param requestModel
     * @return SwiperResponseModel
     */
    @Override
    public SwiperResponseModel create(SwiperRequestModel requestModel) {
        Account curr = UserDatabase.getUserDatabase().getCurrentUser();
        Account potential = requestModel.getPotential();
        curr.addSeen(potential);
        if (requestModel.getAccepted()) {

            curr.addMatch(potential);

            if (potential.getMatches().contains(curr)){
                LocalDateTime now = LocalDateTime.now();
                UserDatabase.getUserDatabase().getAccounts().get(potential.getUsername()).
                        addNotification(new MatchNotification("You matched with " +
                        curr.getProfile().getName() +"!", curr, now));
                UserDatabase.getUserDatabase().getAccounts().get(curr.getUsername()).
                        addNotification(new MatchNotification("You matched with " +
                        potential.getProfile().getName() + "!", potential, now));
                chatDataAccess.addChatRoom(new ChatRoomEnt(curr, potential));
                potential.addBuddy(curr);
                curr.addBuddy(potential);
                return swiperPresenter.prepareNextView("Y");
            }

            return swiperPresenter.prepareNextView("N");
        }
         return swiperPresenter.prepareNextView("N");

    }
}
