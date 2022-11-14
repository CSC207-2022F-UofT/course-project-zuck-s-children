package AccountCreationLogin;

public class RegisterInBoundary {

    private static final String inputUsername = RegisterController.getInputUsernameControl();
    private static final String inputPassword = RegisterController.getInputPasswordControl();

    public static String getInputUsernameBoundary() {
        return inputUsername;
    }

    public static String getInputPasswordBoundary() {
        return inputPassword;
    }
}
