package account_login;


public class LoginController {

    private LoginInBoundary loginBoundary;

    public LoginController(LoginInBoundary loginBoundary) {this.loginBoundary = loginBoundary; }

    public void loginToAccount(String username, String password) {
        LoginInModel loginModel = new LoginInModel(username, password);
        loginBoundary.loginToAccount(loginModel);
    }
}
