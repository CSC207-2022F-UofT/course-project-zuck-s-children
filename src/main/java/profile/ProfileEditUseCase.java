package profile;

public class ProfileEditUseCase implements ProfileEditInputBoundary {
    @Override
    public Profile createProfile(ProfileInModel profile) {
        return profile;
    }
    @Override
    public void modifyProfile(String section, Object content) {
        profile.Profile. = content;
    }

}
