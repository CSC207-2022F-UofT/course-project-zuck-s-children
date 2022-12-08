package account_login;

import account_creation.Account;
import data_persistency.UserDatabase;
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

//    public void swipePage(){
//        LinkedList<Account> potentialMatches = MatchingAlgorithm.finalMatches();
//        SwiperPresenter swiperPresenter = new SwiperPresenterFormatter();
//        SwiperInputBoundary swiperInputBoundary = new SwiperInteractor(swiperPresenter);
//        SwiperController swiperController = new SwiperController(swiperInputBoundary);
//        if (potentialMatches.isEmpty()) {
//            EmptyScreen em = new EmptyScreen();
//            JFrame swiper = new JFrame("");
//            CardLayout cardLayout = new CardLayout();
//            JPanel screens = new JPanel(cardLayout);
//            swiper.add(screens);
//            screens.add(em, "welcome");
//            cardLayout.show(screens, "swipe");
//            swiper.pack();
//            swiper.setBounds(0, 0, 1440, 1000);
//            swiper.setResizable(false);
//            swiper.setVisible(true);
//        }
//        else {
//            for (Account pot: potentialMatches) {
//                SwipeScreen swipeScreen = new SwipeScreen(swiperController, pot);
//                JFrame swiper = new JFrame("Time to swipe");
//                CardLayout cardLayout = new CardLayout();
//                JPanel screens = new JPanel(cardLayout);
//                swiper.add(screens);
//                screens.add(swipeScreen, "welcome");
//                cardLayout.show(screens, "swipe");
//
//                swiper.pack();
//                swiper.setBounds(0, 0, 1440, 1000);
//                swiper.setResizable(false);
//                swiper.setVisible(true);
//                while (!swipeScreen.getPressed()) {
//                    int i = 1;
//                    i++;
//                }
//                swiper.setVisible(false);}
//        }
//    }
}
