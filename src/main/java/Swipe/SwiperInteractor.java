package Swipe;

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

        if (requestModel.getAccepted()) {

            if (UserDatabase.getCurrentUser().getMatches().contains(requestModel.getPotential())){
                LocalDateTime now = LocalDateTime.now();
                requestModel.getPotential().addMatch(UserDatabase.getCurrentUser().getProfile());
                UserDatabase.getCurrentUser().addMatch(requestModel.getPotential().getProfile());
                requestModel.getPotential().addNotification(new MatchNotification("You matched with" +
                        UserDatabase.getCurrentUser().getProfile().getName(), UserDatabase.getCurrentUser(), now));

                UserDatabase.getCurrentUser().addNotification(new MatchNotification("You matched with" +
                        requestModel.getPotential().getProfile().getName(), requestModel.getPotential(),
                        now));

                return swiperPresenter.prepareNextView("Y");
            }
            return swiperPresenter.prepareNextView("N");
        }
         return swiperPresenter.prepareNextView("N");

    }
}
