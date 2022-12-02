package profile;

public class ProfileBuilder {
    /**
     * Create a Profile object based on the profileModel passed in.
     * @param profileModel the profile inModel based on user input
     * @return the newly constructed Profile object
     */
    public Profile create(ProfileInModel profileModel) {
        Profile modifiedProfile = new Profile();
        modifiedProfile.setName(profileModel.getName());
        modifiedProfile.setPronouns(profileModel.getPronouns());
        modifiedProfile.setYear(profileModel.getYear());
        modifiedProfile.setFieldOfStudy(profileModel.getFieldOfStudy());
        modifiedProfile.setStudyStyles(profileModel.getStudyStyles());
        modifiedProfile.setStudySpotPreferences(profileModel.getStudySpotPreferences());
        modifiedProfile.setStudyBuddyPreferences(profileModel.getStudyBuddyPreferences());
        return modifiedProfile;
    }
}
