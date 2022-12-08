package profile;

public class ProfilePresenter implements ProfileUpdateOutputBoundary {
    static ProfileUI profileUI;

    public ProfilePresenter(ProfileUI UI) {
        profileUI = UI;
    }

    /**
     * Present via the ProfileUI the change the user just made and show a message dialogue indicating that the changes are successfully made and saved.
     * @param modifications the edits the UI should display after the user clicks "Save."
     */
    @Override
    public void showModifiedProfile(ProfileOutModel modifications) {
        profileUI.build(modifications);
        profileUI.changeSuccessDialog();
    }
}