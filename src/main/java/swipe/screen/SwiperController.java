package swipe.screen;

import account_and_login.account_creation.Account;
import swipe.SwiperInputBoundary;
import swipe.SwiperRequestModel;
import swipe.SwiperResponseModel;

import java.util.Objects;
//
/**
 * A controller class for the swiper.
 */
public class SwiperController {

    /**
     * An input boundary passed in
     */
    private final SwiperInputBoundary swiperInput;

    /**
     * Constructor that adds the input boundary
     * @param input
     */
    public SwiperController(SwiperInputBoundary input){
        swiperInput = input;
    }

    /**
     * A method that returns a response model indicating if there has been a successful match or not.
     * @param accept (if the user accepted their potential match), account (the potential match)
     * @return a SwiperResponseModel as an output
     */
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
