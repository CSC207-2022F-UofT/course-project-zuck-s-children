package swipe;
//
import account_creation.Account;
import chat.entities.ChatRoomEnt;
import notification.Entities.MatchNotification;
import data.persistency.UserDatabase;


import java.time.LocalDateTime;

import static main_app.StudyBuddyApp.chatDataAccess;

/**
 * An interactor class that implements interface SwiperInputBoundary
 */
public class SwiperInteractor implements SwiperInputBoundary{

    /**
     * A presenter
     */
    final SwiperPresenter swiperPresenter;

    /**
     * A constructor that initializes attribute swiperPresenter
     * @param swiperPresenter
     */
    public SwiperInteractor(SwiperPresenter swiperPresenter){
        this.swiperPresenter = swiperPresenter;
    }

    /**
     * Overridden create method from interface, returns/creates a SwiperResponseModel based on input SwiperRequestModel.
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
