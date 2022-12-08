package account_login;

import account_creation.Account;
import profile.ProfileController;
import profile.ProfileEditUseCase;
import profile.ProfilePresenter;
import profile.ProfileUI;
import ui.ChatListUI;
import ui.LoginUI;
import data_persistency.UserDatabase;

import java.util.HashMap;
import java.util.Objects;


public class LoginUseCase implements LoginInBoundary{

    private LoginInModel loginInModel;
    private LoginOutBoundary loginPresenter;
    private static HashMap<String, Account> userDatabaseAccounts;


    public LoginUseCase(LoginInModel loginInModel) {
        this.loginInModel = loginInModel;
        LoginUI loginUI = new LoginUI();
        this.loginPresenter = new LoginPresenter(loginUI);
        userDatabaseAccounts = UserDatabase.getUserDatabase().getAccounts();
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
