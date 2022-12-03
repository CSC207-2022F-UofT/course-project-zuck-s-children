package account_creation;

public class RegisterInModel {
    private String inputUsername;
    private String inputPassword;

    public RegisterInModel(String username, String password){
        this.inputUsername = username;
        this.inputPassword = password;
    }

    public String getInputUsername(){return this.inputUsername;}
    public String getInputPassword(){return this.inputPassword;}
}
