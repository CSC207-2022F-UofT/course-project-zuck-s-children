package Swipe;

import Notification.ShowNotif.*;
import UI.ChatRoomUI;
import UI.ViewModel;
import chat.control.MsgInBoundary;
import chat.control.MsgOutBoundary;
import chat.control.MsgSendController;
import chat.presenter.ChatRoomPresenter;
import chat.useCases.MsgSendInteractor;
import data.persistency.UserDatabase;
import entities.SwiperFactory;
import entities.theSwiper;

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
            LocalDateTime now = LocalDateTime.now();

            requestModel.getPotential().addNotification();
            if (UserDatabase.getCurrentUser().getMatches().contains(requestModel.getPotential())){
                return swiperPresenter.prepareNextView("Y");
            }
            return swiperPresenter.prepareNextView("N");
        }
        else{
            /* need to send information to chat data access*/
            return swiperPresenter.prepareNextView("N");
        }

    }
}
