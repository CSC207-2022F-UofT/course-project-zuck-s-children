package AccountLogin;

import AccountCreation.Account;

public class LoginOutModel {
    private boolean loginStatus;
    private String failMsg;
    private Account userAccount;

    public LoginOutModel(boolean loginStatus) {
        this.loginStatus = loginStatus;
        this.userAccount = userAccount;
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
