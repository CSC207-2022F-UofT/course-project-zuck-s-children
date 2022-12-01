package profile;

import data.persistency.UserDataAccessInterface;


public class ProfileEditUseCase implements ProfileEditInputBoundary {
    private static final ProfileFactory FACTORY = new ProfileFactory();
    private static UserDataAccessInterface userDataAccess;
    private ProfilePresenter profilePresenter;

    /**
     * Construct an interactor for updating the profile.
     * @param profilePresenter
     */
    public ProfileEditUseCase(ProfilePresenter profilePresenter) {this.profilePresenter = profilePresenter;}

    @Override
    public void modifyProfile(ProfileInModel profileInModel) {
        Profile modifiedProfile = FACTORY.create(profileInModel);
        ProfileOutModel profileModifications = new ProfileOutModel(profileInModel);
        profilePresenter.showModifiedProfile(profileModifications);
    }
}
