package AccountCreation;

import UI.LoginUI;

public class RegisterPresenter implements RegisterOutBoundary {
    ViewModel loginUI;

    public RegisterPresenter(ViewModel UI){
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
