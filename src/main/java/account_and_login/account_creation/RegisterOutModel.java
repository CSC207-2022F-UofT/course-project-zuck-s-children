package account_and_login.account_creation;

public class RegisterOutModel {
    private boolean creationStatus;

    /**
     * Construct the register out model with information on account creation status.
     *
     * @param creationStatus the status of the account creation, whether it succeeded (true) or failed (false).
     */
    public RegisterOutModel(boolean creationStatus) {
        this.creationStatus = creationStatus;
    }

    /**
     * Get the status on registration creation.
     *
     */
    public boolean getCreationStatus() {
        return this.creationStatus;
    }
}
