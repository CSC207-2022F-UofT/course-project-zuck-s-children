package swipe_left_use_case.src.swipe_left;

public class SwiperController {
    final SwiperInputBoundary swiperInput;

    public SwiperController(SwiperInputBoundary accountGateway){
        swiperInput = accountGateway;
    }

    SwiperResponseModel create(String username, String password1, String password2) {
        SwiperRequestModel requestModel = new SwiperRequestModel(
                username, password1, password2);

        return userInput.create(requestModel);
    }
}
