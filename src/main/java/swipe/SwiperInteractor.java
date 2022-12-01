package swipe;

import AccountCreation.Account;
import Notification.MatchNotification;
import data.persistency.UserDatabase;


import java.time.LocalDateTime;
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
        Account curr = UserDatabase.getCurrentUser();
        Account potential = requestModel.getPotential();
        if (requestModel.getAccepted()) {

            curr.addMatch(potential);

            if (potential.getMatches().contains(curr)){
                LocalDateTime now = LocalDateTime.now();
                potential.addNotification(new MatchNotification("You matched with " +
                        curr.getProfile().getName() +"!", curr, now));
                curr.addNotification(new MatchNotification("You matched with " +
                        potential.getProfile().getName() + "!", potential, now));

                return swiperPresenter.prepareNextView("Y");
            }

            return swiperPresenter.prepareNextView("N");
        }
         return swiperPresenter.prepareNextView("N");

    }
}