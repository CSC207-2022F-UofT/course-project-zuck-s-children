package swipe.screen;

import swipe.SwiperPresenter;
import swipe.SwiperResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * A class that formats the presenter interface
 */
public class SwiperPresenterFormatter implements SwiperPresenter {
    /**
     * Concludes the swiping process of one match by initiating the next view (i.e. UI of next potential match)
     * @param s indicating whether the user accepted his/her match or not.
     * @return a SwiperResponseModel, which the program will process as an output to decide on next actions.
     */
    @Override
    public SwiperResponseModel prepareNextView(String s){

        return new SwiperResponseModel(s);
    }
}
