package AccountCreationLogin;

public class RegisterOutBoundary {

    public static boolean creationStatus() {
        return RegisterUseCase.createNewAccount();
    }

}
