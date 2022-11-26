package AccountLogin;

import UI.LoginUI;
import UI.SwiperUI;
import UI.ViewModel;

public class LoginPresenter implements LoginOutBoundary{

    ViewModel loginUI;

    public LoginPresenter(ViewModel UI){
        this.loginUI = UI;
    }

    @Override
    public void loginOutcome(LoginOutModel responseModel) {
        if (responseModel.getLoginStatus()) {
            // TODO: go to swiperUI of this user's account.

        } else {
            //Carry out fail outcome in loginUI.
            LoginUI loginUI = new LoginUI();
            loginUI.loginFailMechanism();
        }
    }
}
