package AccountCreation;

public class RegisterUseCase implements RegisterInBoundary {

    private RegisterOutBoundary registerPresenter;

    @Override
    public void createNewAccount(RegisterInModel registerModel) {
        if (checkDuplicateUsername(registerModel.getInputUsername())) {
            // must raise exception or error and send message up to view
            RegisterOutModel responseModel = new RegisterOutModel(false);
            registerPresenter.alertUser(responseModel);
        } else {
            // add NewAccount entity into UserDatabase
            Account newAccount = new Account(registerModel.getInputUsername(),
                    registerModel.getInputPassword());

            userDatabase.put(registerModel.getInputUsername(), newAccount);

            RegisterOutModel responseModel = new RegisterOutModel(true);
            registerPresenter.alertUser(responseModel);
        }
    }

    public static boolean checkDuplicateUsername(String inputUsername) {
        return userDatabase.containsKey(inputUsername);
    }

}
