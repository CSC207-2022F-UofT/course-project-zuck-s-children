package swipe;
//
/**
 * A response model for the swiper
 */
public class SwiperResponseModel {
    /**
     * A string attribute labelled accepted, referring to whether the user accepted their match or not
     */
    private String accepted;

    /**
     * A contructor that initializes attribute accepted.
     * @param accepted
     */
    public SwiperResponseModel(String accepted) {
        this.accepted = accepted;
    }


    public String getAccepted() {return accepted;
    }
}
