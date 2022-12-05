package profile;

import data.persistency.UserDatabase;


public class ProfileEditUseCase implements profile.ProfileEditInputBoundary {
    private static final profile.ProfileBuilder BUILDER = new profile.ProfileBuilder();
    private final ProfileUpdateOutputBoundary profilePresenter;

    /**
     * Construct an interactor for updating the profile.
     * @param profilePresenter the profile Presenter object
     */
    public ProfileEditUseCase(ProfileUpdateOutputBoundary profilePresenter) {
        this.profilePresenter = profilePresenter;
    }

    @Override
    public void modifyProfile(ProfileInModel profileInModel) {
        Profile profileModifications = BUILDER.createNewProfile(profileInModel);
        UserDatabase.getUserDatabase().getCurrentUser().setProfile(profileModifications);
        ProfileOutModel modifiedProfile = new ProfileOutModel(UserDatabase.getUserDatabase().getCurrentUser().getProfile());
        profilePresenter.showModifiedProfile(modifiedProfile);
    }
}
