package AccountLogin;

import UI.LoginUI;
import UI.Navigation;
import UI.SwiperUI;
import UI.ViewModel;

import javax.swing.*;

public class LoginPresenter implements LoginOutBoundary{

    LoginUI loginUI;

    public LoginPresenter(ViewModel UI){
        this.loginUI = (LoginUI)UI;
    }

    @Override
    public void loginOutcome(LoginOutModel responseModel) {
        if (responseModel.getLoginStatus()) {
            loginUI.loginSuccessMechanism();
            // TODO: go to swiperUI of this user's account.
            /*JFrame frame = new JFrame("FrameDemo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);*/

            Navigation navigation = new Navigation();
            navigation.build();

            loginUI.dispose();
        } else {
            //Carry out fail outcome in loginUI.
            loginUI.loginFailMechanism();
        }
    }
}
