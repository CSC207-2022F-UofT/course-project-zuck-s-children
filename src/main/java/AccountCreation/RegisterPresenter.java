package AccountCreation;

import UI.ViewModel;

public class RegisterPresenter implements RegisterOutBoundary {
    ViewModel loginUI;

    public RegisterPresenter(ViewModel UI){
        this.loginUI = UI;
    }
    @Override
    public void alertUser(RegisterOutModel responseModel) {
        String msg = responseModel.getMsgToUser();
        // TODO: update the view model with this msg to let user know if account creation
        //  was successful.
    }
}
