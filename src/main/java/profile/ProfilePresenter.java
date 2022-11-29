package profile;

import UI.ViewModel;
public class ProfilePresenter implements ProfileUpdateOutputBoundary {
    static ViewModel modifiedProfile;
    public ProfilePresenter(ViewModel UI) {
        this.modifiedProfile = UI;
    }

    @Override
    public void showModifiedProfile(ProfileOutModel modifications) {
        String msg = "Changes successful.";
    }
}