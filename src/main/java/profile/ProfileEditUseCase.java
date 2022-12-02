package profile;

import data.persistency.UserDataAccessInterface;


public class ProfileEditUseCase implements ProfileEditInputBoundary {
    private static final ProfileBuilder BUILDER = new ProfileBuilder();
    private static UserDataAccessInterface userDataAccess;
    private ProfilePresenter profilePresenter;

    /**
     * Construct an interactor for updating the profile.
     * @param profilePresenter
     */
    public ProfileEditUseCase(ProfilePresenter profilePresenter) {this.profilePresenter = profilePresenter;}

    @Override
    public void modifyProfile(ProfileInModel profileInModel) {
        Profile modifiedProfile = BUILDER.create(profileInModel);
        ProfileOutModel profileModifications = new ProfileOutModel(profileInModel);
        profilePresenter.showModifiedProfile(profileModifications);
    }
}
