package profile;

import UI.ViewModel;
public class ProfilePresenter implements ProfileUpdateOutputBoundary {
    ViewModel modifiedProfile;
    public ProfilePresenter(ViewModel UI) {
        this.modifiedProfile = UI;
    }

    @Override
    public static void showModifiedProfile(ProfileOutModel modifications) {
        modifiedProfile.build(modifications);
    }
}