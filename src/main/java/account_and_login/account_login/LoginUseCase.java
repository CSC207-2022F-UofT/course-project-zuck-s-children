package account_and_login.account_login;

import account_and_login.account_creation.Account;
import account_and_login.LoginUI;
import data_persistency.UserDatabase;

import java.util.HashMap;
import java.util.Objects;


public class LoginUseCase implements LoginInBoundary {

    private LoginInModel loginInModel;
    private LoginOutBoundary loginPresenter;
    private static HashMap<String, Account> userDatabaseAccounts;

    /**
     * Construct a UseCase Interactor.
     *
     * @param loginInModel the loginModel which includes username and password inside.
     */
    public LoginUseCase(LoginInModel loginInModel) {
        this.loginInModel = loginInModel;
        LoginUI loginUI = new LoginUI();
        this.loginPresenter = new LoginPresenter(loginUI);
        userDatabaseAccounts = UserDatabase.getUserDatabase().getAccounts();
    }
    /**
     * Run the login use case. Login iff correct username and password.
     *
     * @param loginInModel the loginModel which includes username and password inside.
     */
    @Override
    public void loginToAccount(LoginInModel loginInModel) {
        String inputUsername = loginInModel.getInputUsername();
        String inputPassword = loginInModel.getInputPassword();

        if (userDatabaseAccounts.containsKey(inputUsername)) {
            if (Objects.equals(userDatabaseAccounts.get(inputUsername).getPassword(), inputPassword)) {
                // Sets the current user to be the logged-in user for program to know.
                UserDatabase.getUserDatabase().setCurrentUser(userDatabaseAccounts.get(inputUsername));
                LoginOutModel responseModel = new LoginOutModel(true);
                loginPresenter.loginOutcome(responseModel);
            }
        } else {
            LoginOutModel responseModel = new LoginOutModel(false);
            loginPresenter.loginOutcome(responseModel);
        }
    }
}
