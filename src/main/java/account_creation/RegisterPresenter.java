package account_creation;

import ui.LoginUI;

public class RegisterPresenter implements RegisterOutBoundary {
    LoginUI loginUI;

    public RegisterPresenter(LoginUI UI){
        this.loginUI = UI;
    }
    @Override
    public void alertUser(RegisterOutModel responseModel) {
        LoginUI loginUI = new LoginUI();
        if (responseModel.getCreationStatus()) {
            loginUI.registerSuccessMechanism();
        }
        else {
            loginUI.registerFailMechanism();
        }
    }
}
