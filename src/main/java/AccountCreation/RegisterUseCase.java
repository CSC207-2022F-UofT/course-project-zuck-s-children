package AccountCreation;

import data.persistency.UserDatabase;

public class RegisterUseCase implements RegisterInBoundary {
    private UserDatabase userDatabase;
    private RegisterOutBoundary registerPresenter;


    public void RegisterUserCase (UserDatabase userDatabase, RegisterOutBoundary presenter){
        this.userDatabase = userDatabase;
        this.registerPresenter = presenter;
    }

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

            userDatabase.getAccounts().put(registerModel.getInputUsername(), newAccount);

            RegisterOutModel responseModel = new RegisterOutModel(true);
            registerPresenter.alertUser(responseModel);
        }
    }

    public boolean checkDuplicateUsername(String inputUsername) {
        return this.userDatabase.getAccounts().containsKey(inputUsername);
    }

}
