package swipe_left_use_case.src.swipe_left;

public class SwiperRequestModel {
    private boolean accepted;
    private Account potential;

    public SwiperRequestModel(boolean accepted, Account potential) {

        this.accepted = accepted;
        this.potential = potential;
    }


    public boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Account getPotential() {
        return potential;
    }

    public void setPotential(Account potential) {
        this.potential = potential;
    }

}
