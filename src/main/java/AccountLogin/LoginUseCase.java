package AccountLogin;

import AccountCreation.Account;
import UI.LoginUI;
import data.persistency.UserDatabase;

import java.util.HashMap;
import java.util.Objects;

public class LoginUseCase implements LoginInBoundary{

    private LoginInModel loginInModel;
    private LoginOutBoundary loginPresenter;
    private static HashMap<String, Account> userDatabase;


    public LoginUseCase(LoginInModel loginInModel) {
        this.loginInModel = loginInModel;
        LoginUI loginUI = new LoginUI();
        this.loginPresenter = new LoginPresenter(loginUI);
        userDatabase = UserDatabase.getAccounts();
    }
    /**
     * Run the login use case.
     * @param loginInModel the loginModel which includes username and password inside.
     * Checks if username and passwords are in userDatabase.
     */
    @Override
    public void loginToAccount(LoginInModel loginInModel) {
        String inputUsername = loginInModel.getInputUsername();
        String inputPassword = loginInModel.getInputPassword();

        if (userDatabase.containsKey(inputUsername)) {
            if (Objects.equals(userDatabase.get(inputUsername).getPassword(), inputPassword)) {
                LoginOutModel responseModel = new LoginOutModel(true);
                loginPresenter.loginOutcome(responseModel);

                // Sets the current user to be the logged-in user for program to know.
                UserDatabase.setCurrentUser(userDatabase.get(inputUsername));
            }
        } else {
            LoginOutModel responseModel = new LoginOutModel(false);
            loginPresenter.loginOutcome(responseModel);
        }
    }
}
