package account_and_login.account_creation;

public class RegisterController {

    private RegisterInBoundary registerBoundary;

    /**
     * Construct a register controller to register a new account.
     *
     */
    public RegisterController(RegisterInBoundary registerBoundary) {
        this.registerBoundary = registerBoundary;
    }

    /**
     * Create a new account.
     *
     * @param username username of the register input.
     * @param password password of the register input.
     */
    public void createNewAccount(String username, String password){
        RegisterInModel registerModel = new RegisterInModel(username, password);
        registerBoundary.createNewAccount(registerModel);
    }
}
