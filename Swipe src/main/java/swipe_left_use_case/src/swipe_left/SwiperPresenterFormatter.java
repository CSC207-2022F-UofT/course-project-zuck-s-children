package swipe_left_use_case.src.swipe_left;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SwiperPresenterFormatter implements SwiperPresenter{
    @Override
    public SwiperResponseModel prepareNextview(String s){

        return new SwiperResponseModel(s);
    }
}
