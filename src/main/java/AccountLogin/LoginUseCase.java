package AccountLogin;

import data.persistency.UserDatabase;
public class LoginUseCase implements LoginInBoundary{
    private UserDatabase userDatabase;
    private LoginOutBoundary loginPresenter;

    public LoginUseCase(UserDatabase userDatabase, LoginOutBoundary loginPresenter){
        this.userDatabase = userDatabase;
        this.loginPresenter = loginPresenter;
    }
    @Override
    public void loginToAccount(LoginInModel loginModel) {
        if (userDatabase.containsKey(loginModel.getInputUsername())) {
            if (userDatabase[loginModel.getInputUsername()][0] == loginModel.getInputPassword()) {
                LoginOutModel responseModel = new LoginOutModel(true);
                loginPresenter.loginToAccount(responseModel);

                // Sets the current user to be the logged-in user for program to know.
                UserDatabase.setCurrentUser(userDatabase.getAccounts().get(loginModel.getInputUsername()));
            }
        } else {
            LoginOutModel responseModel = new LoginOutModel(false);
            loginPresenter.loginToAccount(responseModel);
        }
    }
}
