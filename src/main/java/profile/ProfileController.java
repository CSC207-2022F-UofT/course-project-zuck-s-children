package profile;

public class ProfileController {
    private final ProfileEditInputBoundary profileEdits;

    public ProfileController(ProfileEditInputBoundary userInput) {
        this.profileEdits = userInput;
    }
    public void modifyProfile(ProfileInModel profile) {
        profileEdits.modifyProfile(profile);}
}
