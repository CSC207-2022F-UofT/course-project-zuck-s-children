package account_creation;

import ui.LoginUI;

public class RegisterPresenter implements RegisterOutBoundary {
    LoginUI loginUI;

    /**
     * Construct a register presenter.
     *
     * @param UI the loginUI for the presenter to call on for success and failure mechanisms.
     */
    public RegisterPresenter(LoginUI UI){
        this.loginUI = UI;
    }

    /**
     * Alert the user of whether registration was successful or unsuccessful.
     *
     * @param responseModel containing the account creation status to determine the success/fail mechanism call.
     */
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
