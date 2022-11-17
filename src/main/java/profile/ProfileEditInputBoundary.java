package profile;

public interface ProfileEditInputBoundary {
    Profile createProfile(ProfileInModel profile);
    void modifyProfile(String section, Object content);
}
