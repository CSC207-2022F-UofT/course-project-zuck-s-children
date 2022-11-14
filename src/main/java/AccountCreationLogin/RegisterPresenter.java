package AccountCreationLogin;

public class RegisterPresenter {

    public String successFailure() {
        if (RegisterOutBoundary.creationStatus()) {
            return "Account creation was successful. Please Login.";
        } else {
            return "Account creation was unsuccessful. Please try again.";
        }
    }
}
