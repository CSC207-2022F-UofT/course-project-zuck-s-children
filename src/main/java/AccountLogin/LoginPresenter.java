package AccountLogin;

import UI.ViewModel;

public class LoginPresenter implements LoginOutBoundary{

    ViewModel loginUI;
    ViewModel profileUI;

    public LoginPresenter(ViewModel UI){
        this.loginUI = UI;
    }

    @Override
    public void loginToAccount(LoginOutModel responseModel) {
        if (responseModel.getLoginStatus()) {
            // TODO: go to profileUI of this user's account.
        } else {
            String failMsg = responseModel.getFailMsg();
            // TODO: display failMsg in loginUI.
        }
    }
}
