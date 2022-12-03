package swipe;

import account_creation.Account;

/**
 * A request model for the swiper
 */
public class SwiperRequestModel {
    /**
     * A boolean that refers to whether or not the user accepted their potential match.
     */
    private boolean accepted;
    /**
     * The account of the potential match
     */
    private Account potential;

    /**
     * A constructor that initializes attributes accepted and potential
     * @param accepted, potential
     */
    public SwiperRequestModel(boolean accepted, Account potential) {

        this.accepted = accepted;
        this.potential = potential;
    }

    /**
     * A method that returns accepted from SwiperRequestModel object in question
     * @return accepted
     */
    public boolean getAccepted() {
        return accepted;
    }

    /**
     * A method that changes accepted from SwiperRequestModel object in question
     * @param accepted
     */
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    /**
     * A method that returns potential from SwiperRequestModel object in question
     * @return potential
     */
    public Account getPotential() {
        return potential;
    }

    /**
     * A method that changes potential from SwiperRequestModel object in question
     * @param potential
     */
    public void setPotential(Account potential) {
        this.potential = potential;
    }

}
