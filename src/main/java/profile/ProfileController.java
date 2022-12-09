package profile;

public class ProfileController {
    final ProfileEditInputBoundary userInput;

    /**
     * Construct a controller to modify the profile.
     * @param profileEdits all modifications passed in to be used to change the profile entity
     */
    public ProfileController(ProfileEditInputBoundary profileEdits) {
        this.userInput = profileEdits;
    }

    /**
     * Modify the profile based on changes the user made.
     * @param profileInModel the changes the user made on the UI
     */
    public void modifyProfile(ProfileInModel profileInModel) {
        userInput.modifyProfile(profileInModel);}
}
