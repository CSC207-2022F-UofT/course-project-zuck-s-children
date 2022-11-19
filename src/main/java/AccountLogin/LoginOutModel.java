package AccountLogin;

public class LoginOutModel {
    private boolean loginStatus;
    private String failMsg;

    public LoginOutModel(boolean loginStatus) {
        this.loginStatus = loginStatus;
        if (this.loginStatus) {
            this.failMsg = "Incorrect username or password. Please try again.";
        } else {
            this.failMsg = null;
        }
    }

    public String getFailMsg() {
        return this.failMsg;
    }
    public boolean getLoginStatus() {
        return this.loginStatus;
    }
}
