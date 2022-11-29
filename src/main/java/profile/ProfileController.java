package profile;

public class ProfileController {
    final ProfileEditInputBoundary userInput;

    public ProfileController(ProfileEditInputBoundary profileEdits) {
        this.userInput = profileEdits;
    }
    public void modifyProfile(ProfileInModel profileInModel) {
        userInput.modifyProfile(profileInModel);}
}