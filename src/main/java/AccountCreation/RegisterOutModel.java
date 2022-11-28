package AccountCreation;

public class RegisterOutModel {
    private boolean creationStatus;

    public RegisterOutModel(boolean creationStatus) {
        this.creationStatus = creationStatus;
    }

    public boolean getCreationStatus() {
        return this.creationStatus;
    }
}
