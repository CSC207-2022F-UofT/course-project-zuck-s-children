package profile;

import ui.ProfileUI;
public class ProfilePresenter implements ProfileUpdateOutputBoundary {
    static ProfileUI modifiedProfile;
    public ProfilePresenter(ProfileUI UI) {
        this.modifiedProfile = UI;
    }

}