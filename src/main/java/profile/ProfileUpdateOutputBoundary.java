package profile;

import static profile.ProfilePresenter.modifiedProfile;

public interface ProfileUpdateOutputBoundary {
    static void showModifiedProfile(ProfileOutModel modifications){
        modifiedProfile.build();
    }
}