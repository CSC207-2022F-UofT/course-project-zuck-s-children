package profile;

import data.persistency.UserDataAccessInterface;


public class ProfileEditUseCase implements profile.ProfileEditInputBoundary {
    private static final profile.ProfileBuilder BUILDER = new profile.ProfileBuilder();
    private static UserDataAccessInterface userDataAccess;
    private ProfileUpdateOutputBoundary profilePresenter;

    /**
     * Construct an interactor for updating the profile.
     * @param profilePresenter
     */
    public ProfileEditUseCase(ProfileUpdateOutputBoundary profilePresenter, UserDataAccessInterface userDataAccess) {
        this.profilePresenter = profilePresenter;
        ProfileEditUseCase.userDataAccess = userDataAccess;
    }

    @Override
    public void modifyProfile(ProfileInModel profileInModel) {
        Profile modifiedProfile = BUILDER.create(profileInModel);
        ProfileOutModel profileModifications = new ProfileOutModel(profileInModel);
        profilePresenter.showModifiedProfile(profileModifications);
//        userDataAccess.
    }
}
