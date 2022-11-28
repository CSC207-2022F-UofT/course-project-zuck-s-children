package AccountCreation;

public class RegisterController {

    private RegisterInBoundary registerBoundary;

    public RegisterController(RegisterInBoundary registerBoundary) {
        this.registerBoundary = registerBoundary;
    }
    public void createNewAccount(String username, String password){
        RegisterInModel registerModel = new RegisterInModel(username, password);
        registerBoundary.createNewAccount(registerModel);
    }

}
