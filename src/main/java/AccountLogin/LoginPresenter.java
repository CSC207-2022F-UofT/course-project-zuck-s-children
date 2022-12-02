package AccountLogin;

import UI.LoginUI;
import UI.SwiperUI;
import UI.ViewModel;

import javax.swing.*;

public class LoginPresenter implements LoginOutBoundary{

    ViewModel loginUI;

    public LoginPresenter(ViewModel UI){
        this.loginUI = UI;
    }

    @Override
    public void loginOutcome(LoginOutModel responseModel) {
        LoginUI loginUI = new LoginUI();
        if (responseModel.getLoginStatus()) {
            loginUI.loginSuccessMechanism();
            // TODO: go to swiperUI of this user's account.
            JFrame frame = new JFrame("FrameDemo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

            loginUI.closeLoginUI();
        } else {
            //Carry out fail outcome in loginUI.
            loginUI.loginFailMechanism();
        }
    }
}
