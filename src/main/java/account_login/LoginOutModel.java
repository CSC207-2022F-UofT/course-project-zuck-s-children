package account_login;

public class LoginOutModel {
    private boolean loginStatus;
    private String failMsg;

    public LoginOutModel(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public boolean getLoginStatus() {
        return this.loginStatus;
    }
}
