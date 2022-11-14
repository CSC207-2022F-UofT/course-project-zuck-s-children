package swipe_left_use_case.src.swipe_left;

import entities.SwiperFactory;
import entities.theSwiper;

public class SwiperInteractor implements SwiperInputBoundary{

    final SwiperPresenter swiperPresenter;
    final SwiperDsGateway swiperDsGateway; /* comes from main database*/
    final SwiperFactory swiperFactory; /* may not be necessary*/

    public SwiperInteractor(SwiperPresenter swiperPresenter, SwiperDsGateway swiperDsGateway,
                            SwiperFactory swiperFactory){
        this.swiperFactory = swiperFactory;
        this.swiperPresenter = swiperPresenter;
        this.swiperDsGateway = swiperDsGateway;
    }

    @Override
    public SwiperResponseModel create(SwiperRequestModel requestModel) {

        if (requestModel.getAccepted()) {
            /* need to send information to chat data access*/
            return SwiperPresenter.prepareNextView("N");
        }
        else{
            /* need to send information to chat data access*/
            return SwiperPresenter.prepareNextView("N");
        }

    }
}
