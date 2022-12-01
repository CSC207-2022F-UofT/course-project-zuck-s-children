package AccountLogin;

import AccountCreation.Account;
import UI.LoginUI;
import UI.SwiperUI;
import UI.ViewModel;
import matching.MatchingAlgorithm;
import swipe.SwiperInputBoundary;
import swipe.SwiperInteractor;
import swipe.SwiperPresenter;
import swipe.screen.EmptyScreen;
import swipe.screen.SwipeScreen;
import swipe.screen.SwiperController;
import swipe.screen.SwiperPresenterFormatter;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

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


            //Open SwiperUI frame


            //Open navigation frame
            NavigationUI navigationUI = new NavigationUI();
            navigationUI.build();

            loginUI.closeLoginUI();
        } else {
            //Carry out fail outcome in loginUI.
            loginUI.loginFailMechanism();
        }
    }
}
