package profile;

public class ProfileController {
    private final ProfileEditInputBoundary userInput;

    public ProfileController(ProfileEditInputBoundary userInput) {
        this.userInput = userInput;
    }
    Profile createProfile(ProfileInModel profile) {userInput.createProfile(profile)};
    public modifyProfile()

}
