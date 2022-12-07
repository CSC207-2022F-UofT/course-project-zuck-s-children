package account_login;

import account_creation.Account;
import data.persistency.UserDatabase;
import profile.ProfileController;
import profile.ProfileEditUseCase;
import profile.ProfilePresenter;
import profile.ProfileUI;
import ui.ChatListUI;
import ui.LoginUI;
import matching.MatchingAlgorithm;
import swipe.SwiperInputBoundary;
import swipe.SwiperInteractor;
import swipe.SwiperPresenter;
import swipe.screen.EmptyScreen;
import swipe.screen.SwipeScreen;
import swipe.screen.SwiperController;
import swipe.screen.SwiperPresenterFormatter;
import ui.Navigation;
//import ui.NavigationUI;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

import static main_app.StudyBuddyApp.*;

public class LoginPresenter implements LoginOutBoundary{

    LoginUI loginUI;

    public LoginPresenter(LoginUI UI){
        this.loginUI = UI;
    }

    @Override
    public void loginOutcome(LoginOutModel responseModel) {
        LoginUI loginUI = new LoginUI();
        if (responseModel.getLoginStatus()) {
            loginUI.loginSuccessMechanism();
            currUserProfile = UserDatabase.getUserDatabase().getCurrentUser().getProfile();
            profileUI = new ProfileUI();
            profilePresenter = new ProfilePresenter(profileUI);
            profileEditUseCase = new ProfileEditUseCase(profilePresenter);
            profileController = new ProfileController(profileEditUseCase);
            chatListUI = new ChatListUI();

            Navigation.createAndShowGUI();
            loginUI.closeLoginUI();
        } else {
            //Carry out fail outcome in loginUI.
            loginUI.loginFailMechanism();
        }
    }
}
