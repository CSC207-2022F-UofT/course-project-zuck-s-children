package AccountLogin;

import AccountCreation.Account;
import swipe.screen.EmptyScreen;
import swipe.screen.SwipeScreen;
import swipe.screen.SwiperController;
import swipe.screen.SwiperPresenterFormatter;
import swipe.SwiperInputBoundary;
import swipe.SwiperInteractor;
import Swipe.SwiperPresenter;
import UI.LoginUI;
import UI.NavigationUI;
import UI.SwiperUI;
import UI.ViewModel;
import data.persistency.UserDatabase;
import matching.MatchingAlgorithm;

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
