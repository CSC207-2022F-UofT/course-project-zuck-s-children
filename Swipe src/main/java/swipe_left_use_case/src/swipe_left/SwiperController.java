package swipe_left_use_case.src.swipe_left;

public class SwiperController {
    final SwiperInputBoundary swiperInput;

    public SwiperController(SwiperInputBoundary input){
        swiperInput = input;
    }

    public SwiperResponseModel create(boolean accept, Account account) {
        SwiperRequestModel requestModel = new SwiperRequestModel(
                accept, account);

        return swiperInput.create(requestModel);
    }
}
