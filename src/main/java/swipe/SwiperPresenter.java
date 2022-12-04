package swipe;
//
/**
 * An interface for the presenter of the Swiper.
 */
public interface SwiperPresenter {
    /**
     * A method that concludes the swiping process and prepares the next UI for the next match.
     * @param s
     * @return SwiperResponseModel
     */
    SwiperResponseModel prepareNextView(String s);

}
