package profile;

import data_persistency.UserDatabase;


public class ProfileEditUseCase implements profile.ProfileEditInputBoundary {
    private final ProfileUpdateOutputBoundary PROFILE_PRESENTER;

    /**
     * Construct an interactor for updating the profile.
     * @param profilePresenter the profile Presenter object
     */
    public ProfileEditUseCase(ProfileUpdateOutputBoundary profilePresenter) {
        this.PROFILE_PRESENTER = profilePresenter;
    }

    /**
     * Update in the UserDatabase the profile of the user currently logged in. Create an outModel for the UI to display the edits.
     * @param profileInModel profile modifications
     */
    @Override
    public void modifyProfile(ProfileInModel profileInModel) {
        Profile profileModifications = new Profile(profileInModel.getName(), profileInModel.getPronouns(), profileInModel.getYear(), profileInModel.getFieldOfStudy(), profileInModel.getStudyStyles(), profileInModel.getStudyBuddyPreferences(), profileInModel.getStudySpotPreferences());
        UserDatabase.getUserDatabase().getCurrentUser().setProfile(profileModifications);
        ProfileOutModel modifiedProfile = new ProfileOutModel(UserDatabase.getUserDatabase().getCurrentUser().getProfile());

        PROFILE_PRESENTER.showModifiedProfile(modifiedProfile);
    }
}