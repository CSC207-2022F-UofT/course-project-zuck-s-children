package account_and_login.account_login;

public class LoginOutModel {
    private boolean loginStatus;
    private String failMsg;

    /**
     * Construct a login out model with the login status determining if login was successful or unsuccessful.
     *
     * @param loginStatus whether login was successful (true) or unsuccessful (false).
     */
    public LoginOutModel(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    /**
     * Get the login status: success (true) or failure (false).
     *
     */
    public boolean getLoginStatus() {
        return this.loginStatus;
    }
}
