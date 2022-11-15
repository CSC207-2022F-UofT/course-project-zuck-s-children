package swipe_left_use_case.src.swipe_left;

public interface SwiperPresenter {
    SwiperResponseModel prepareNextView(SwiperResponseModel user);

    SwiperResponseModel prepareFailView(String error);
}
