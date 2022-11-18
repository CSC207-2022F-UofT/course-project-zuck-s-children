package profile;

import data.persistency.UserDataAccessInterface;

public class ProfileEditUseCase implements ProfileEditInputBoundary {
    private static final ProfileFactory FACTORY = new ProfileFactory();
    private static UserDataAccessInterface userDataAccess;
    private ProfileUpdateOutputBoundary profilePresenter;
    public ProfileEditUseCase(ProfileUpdateOutputBoundary profilePresenter) {this.profilePresenter = profilePresenter;}

    @Override
    public void modifyProfile(ProfileInModel profile) {
        Profile modifiedProfile = FACTORY.create(profile);
        ProfileOutModel profileModifications = new ProfileOutModel();
        ProfilePresenter.update()
    }
}
