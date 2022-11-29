package profile;

import static profile.ProfilePresenter.modifiedProfile;

public interface ProfileUpdateOutputBoundary {
    void showModifiedProfile(ProfileOutModel modifications);
}