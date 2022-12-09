package account_login;


public class LoginController {

    private LoginInBoundary loginBoundary;

    /**
     * Get the input username.
     *
     */
    public LoginController(LoginInBoundary loginBoundary) {this.loginBoundary = loginBoundary; }

    /**
     * Login to account with the given input username and password.
     *
     * @param password input password.
     * @param username input username.
     */
    public void loginToAccount(String username, String password) {
        LoginInModel loginModel = new LoginInModel(username, password);
        loginBoundary.loginToAccount(loginModel);
    }
}
