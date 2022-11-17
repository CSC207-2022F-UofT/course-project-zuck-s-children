package profile;

import UI.ViewModel;
public class ProfilePresenter implements ProfileUpdateOutputBoundary {
    ViewModel profile;
    public ProfilePresenter(ViewModel UI) {
        this.profile = UI;
    }

}