package AccountCreation;

public class RegisterController {

    private RegisterInBoundary registerBoundary;

    public RegisterController(RegisterInBoundary registerInteractor) {
        this.registerBoundary = registerInteractor;
    }
    public boolean createNewAccount(RegisterInModel registerModel){
        registerBoundary.createNewAccount(registerModel);
    }

}
