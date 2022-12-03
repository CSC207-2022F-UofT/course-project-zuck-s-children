package account_login;

public class LoginInModel {
    private String inputUsername;
    private String inputPassword;

    public LoginInModel(String username, String password) {
        this.inputUsername = username;
        this.inputPassword = password;
    }

    public String getInputUsername(){return this.inputUsername;}
    public String getInputPassword(){return this.inputPassword;}
}
