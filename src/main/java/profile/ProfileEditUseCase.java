package profile;

import data.persistency.UserDataAccessInterface;
import data.persistency.UserDatabase;


public class ProfileEditUseCase implements profile.ProfileEditInputBoundary {
    private static final profile.ProfileBuilder BUILDER = new profile.ProfileBuilder();
    private static UserDatabase userDataAccess;
    private ProfileUpdateOutputBoundary profilePresenter;

    /**
     * Construct an interactor for updating the profile.
     * @param profilePresenter
     */
    public ProfileEditUseCase(ProfileUpdateOutputBoundary profilePresenter, UserDatabase userDataAccess) {
        this.profilePresenter = profilePresenter;
        ProfileEditUseCase.userDataAccess = userDataAccess;
    }

    @Override
    public void modifyProfile(ProfileInModel profileInModel) {
        Profile modifiedProfile = BUILDER.createNewProfile(profileInModel);
        ProfileOutModel profileModifications = new ProfileOutModel(profileInModel);
        profilePresenter.showModifiedProfile(profileModifications);
//        userDataAccess.
    }
}
