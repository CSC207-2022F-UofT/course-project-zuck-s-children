package AccountCreation;

import UI.LoginUI;
import UI.ViewModel;
import data.persistency.UserDatabase;

import java.util.HashMap;

public class RegisterUseCase implements RegisterInBoundary {
    private RegisterInModel registerInModel;
    private RegisterOutBoundary registerPresenter;
    private static HashMap<String, Account> userDatabase;


    public RegisterUseCase (RegisterInModel registerInModel) {
        this.registerInModel = registerInModel;
        LoginUI loginUI = new LoginUI();
        this.registerPresenter = new RegisterPresenter(loginUI);
        userDatabase = UserDatabase.getAccounts();
    }
    @Override
    public void createNewAccount(RegisterInModel registerInModel) {
        String registerUser = registerInModel.getInputUsername();
        String registerPwd = registerInModel.getInputPassword();

        if (checkDuplicateUsername(registerUser)) {
            // must raise exception or error and send message up to view
            int numberOfAccounts = userDatabase.size();
            System.out.println(numberOfAccounts);
            RegisterOutModel responseModel = new RegisterOutModel(false);
            registerPresenter.alertUser(responseModel);
        } else {
            // add NewAccount entity into UserDatabase
            Account newAccount = new Account(registerUser,
                    registerPwd);

            userDatabase.put(registerUser, newAccount);

            int numberOfAccounts = userDatabase.size();
            System.out.println(numberOfAccounts);

            RegisterOutModel responseModel = new RegisterOutModel(true);
            registerPresenter.alertUser(responseModel);
        }
    }

    public static boolean checkDuplicateUsername(String inputUsername) {
        return userDatabase.containsKey(inputUsername);
    }

}
