package profile;

import ui.ProfileUI;

public class ProfilePresenter implements ProfileUpdateOutputBoundary {
    static ProfileUI modifiedProfile;
    public ProfilePresenter(ProfileUI UI) {
        modifiedProfile = UI;
    }

    @Override
    public void showModifiedProfile(ProfileOutModel modifications) {
        String msg = "Changes successful.";
        modifiedProfile.build();
    }
}