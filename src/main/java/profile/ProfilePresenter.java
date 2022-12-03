package profile;

import ui.ViewModel;
public class ProfilePresenter implements ProfileUpdateOutputBoundary {
    static ViewModel modifiedProfile;
    public ProfilePresenter(ViewModel UI) {
        this.modifiedProfile = UI;
    }

}