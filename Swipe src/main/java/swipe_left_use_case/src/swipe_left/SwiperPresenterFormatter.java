package swipe_left_use_case.src.swipe_left;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SwiperPresenterFormatter implements SwiperPresenter{
    @Override
    public SwiperResponseModel prepareSuccessView(SwiperResponseModel response){
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    @Override
    public SwiperResponseModel prepareFailView(String error);
}
