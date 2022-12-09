package account_and_login.account_login;

public class LoginInModel {
    private String inputUsername;
    private String inputPassword;

    /**
     * Construct a login in model with necessary info for login.
     *
     * @param username input username.
     * @param password input password.
     */
    public LoginInModel(String username, String password) {
        this.inputUsername = username;
        this.inputPassword = password;
    }

    /**
     * Get the input username.
     *
     */
    public String getInputUsername(){return this.inputUsername;}

    /**
     * Get the input password.
     *
     */
    public String getInputPassword(){return this.inputPassword;}
}
