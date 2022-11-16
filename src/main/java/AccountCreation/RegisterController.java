package AccountCreation;

public class RegisterController {

    private RegisterInBoundary registerBoundary;

    public RegisterController(RegisterInBoundary registerInteractor) {
        this.registerBoundary = registerInteractor;
    }
    public void createNewAccount(RegisterInModel registerModel){
        registerBoundary.createNewAccount(registerModel);
    }

}
