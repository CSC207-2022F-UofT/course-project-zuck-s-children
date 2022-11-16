package AccountCreation;

public class RegisterOutModel {
    private boolean creationStatus;
    private String msgToUser;

    public RegisterOutModel(boolean creationStatus) {
        this.creationStatus = creationStatus;
        if (this.creationStatus) {
            this.msgToUser = "Account creation was successful. Please login.";
        } else {
            this.msgToUser = "Account creation was unsuccessful. Please try again.";
        }
    }
    public String getMsgToUser() {
        return this.msgToUser;
    }
}
