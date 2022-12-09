package account_and_login.account_creation;

public class RegisterInModel {
    private String inputUsername;
    private String inputPassword;

    /**
     * Construct a register in model containing the data necessary to register a new account.
     *
     * @param username username of the register input.
     * @param password password of the register input.
     */
    public RegisterInModel(String username, String password){
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
