package swipe_left_use_case.src.swipe_left;

public class SwiperResponseModel {
    String creationTime;

    public SwiperResponseModel(boolean accepted, String creationTime) {
        this.creationTime = creationTime;
    }


    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
