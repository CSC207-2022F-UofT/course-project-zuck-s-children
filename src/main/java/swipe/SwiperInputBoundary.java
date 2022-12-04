package swipe;
//
/**
 * An interface for the input boundary.
 */
public interface SwiperInputBoundary {
    /**
     * creates a SwiperResponseModel based on input SwiperRequestModel
     * @param swiperRequestModel
     * @return SwiperResponseModel
     */
    SwiperResponseModel create(SwiperRequestModel swiperRequestModel);
}
