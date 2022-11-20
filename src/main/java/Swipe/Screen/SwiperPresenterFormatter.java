package Swipe.Screen;

import Swipe.SwiperPresenter;
import Swipe.SwiperResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SwiperPresenterFormatter implements SwiperPresenter {
    @Override
    public SwiperResponseModel prepareNextView(String s){

        return new SwiperResponseModel(s);
    }
}
