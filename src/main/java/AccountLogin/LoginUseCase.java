package AccountLogin;

public class LoginUseCase implements LoginInBoundary{

    private LoginOutBoundary loginPresenter;
    @Override
    public void loginToAccount(LoginInModel loginModel) {
        if (UserDatabase.containsKey(loginModel.getInputUsername())) {
            if (UserDatabase[loginModel.getInputUsername()][0] == loginModel.getInputPassword()) {
                LoginOutModel responseModel = new LoginOutModel(true, UserDatabase[loginModel.getInputUsername()]);
                loginPresenter.loginStatus(responseModel);
            }
        } else {
            LoginOutModel responseModel = new LoginOutModel(false, UserDatabase[loginModel.getInputUsername()]);
            loginPresenter.loginStatus(responseModel);
        }
    }
}
