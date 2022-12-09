package account_and_login.account_login;

import data.persistency.UserDatabase;
import profile.ProfileController;
import profile.ProfileEditUseCase;
import profile.ProfilePresenter;
import profile.ProfileUI;
import chat.ChatListUI;
import account_and_login.LoginUI;
import main_app.NavigationUI;
//import main_app.NavigationUI;

import static main_app.StudyBuddyApp.*;

public class LoginPresenter implements LoginOutBoundary {

    LoginUI loginUI;

    /**
     * Construct a login presenter.
     *
     * @param UI the loginUI for the presenter to call on for success and failure mechanisms.
     */
    public LoginPresenter(LoginUI UI){
        this.loginUI = UI;
    }

    /**
     * Implement the outcome of the login procedure based on successful or unsuccessful login. Show a failure message if
     * login is unsuccessful. Close the login frame and open the navigation frame if login is successful.
     *
     * @param responseModel containing the login status to determine which outcome to present.
     */
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

            NavigationUI.createAndShowGUI();
            loginUI.closeLoginUI();
        } else {
            //Carry out fail outcome in loginUI.
            loginUI.loginFailMechanism();
        }
    }
}
