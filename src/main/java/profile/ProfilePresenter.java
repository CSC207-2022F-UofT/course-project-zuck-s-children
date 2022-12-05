package profile;

public class ProfilePresenter implements ProfileUpdateOutputBoundary {
    static ProfileUI profileUI;
    public ProfilePresenter(ProfileUI UI) {
        profileUI = UI;
    }

    @Override
    public void showModifiedProfile(ProfileOutModel modifications) {
        profileUI.build(modifications);
        profileUI.changeSuccessDialog();
    }
}