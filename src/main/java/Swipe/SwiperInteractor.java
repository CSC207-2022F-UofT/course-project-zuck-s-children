package Swipe;

import Notification.MatchNotification;
import data.persistency.UserDatabase;


import java.time.LocalDateTime;

public class SwiperInteractor implements SwiperInputBoundary{

    final SwiperPresenter swiperPresenter;


    public SwiperInteractor(SwiperPresenter swiperPresenter){
        this.swiperPresenter = swiperPresenter;
    }

    @Override
    public SwiperResponseModel create(SwiperRequestModel requestModel) {

        if (requestModel.getAccepted()) {
            /* need to send information to chat data access*/

            if (UserDatabase.getCurrentUser().getMatches().contains(requestModel.getPotential())){
                LocalDateTime now = LocalDateTime.now();
                requestModel.getPotential().addMatch(UserDatabase.getCurrentUser());
                UserDatabase.getCurrentUser().addMatch(requestModel.getPotential());
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
