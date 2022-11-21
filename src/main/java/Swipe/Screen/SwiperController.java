package Swipe.Screen;

import AccountCreation.Account;
import Swipe.SwiperInputBoundary;
import Swipe.SwiperRequestModel;
import Swipe.SwiperResponseModel;

import java.util.Objects;

public class SwiperController {
    final SwiperInputBoundary swiperInput;

    public SwiperController(SwiperInputBoundary input){
        swiperInput = input;
    }

    public SwiperResponseModel create(String accept, Account account) {
        SwiperRequestModel requestModel;
        if (Objects.equals(accept.charAt(0), 'T')) {
            requestModel = new SwiperRequestModel(
                    true, account);
        } else{
            requestModel = new SwiperRequestModel(
                    false, account);
        }

        return swiperInput.create(requestModel);
    }
}
