package AccountLogin;

public class LoginUseCase implements LoginInBoundary{

    private LoginOutBoundary loginPresenter;
    @Override
    public void loginToAccount(LoginInModel loginModel) {
        if (userDatabase.containsKey(loginModel.getInputUsername())) {
            if (userDatabase[loginModel.getInputUsername()][0] == loginModel.getInputPassword()) {
                LoginOutModel responseModel = new LoginOutModel(true);
                loginPresenter.loginToAccount(responseModel);
            }
        } else {
            LoginOutModel responseModel = new LoginOutModel(false);
            loginPresenter.loginToAccount(responseModel);
        }
    }
}
