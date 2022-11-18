package profile;

public class ProfileFactory {
    public Profile create(ProfileInModel profileModel) {
        Profile modifiedProfile = new Profile();
        modifiedProfile.setName(profileModel.getName());
        modifiedProfile.setPronouns(profileModel.getPronouns());
        modifiedProfile.setYear(profileModel.getYear());
        modifiedProfile.setFieldOfStudy(profileModel.getFieldOfStudy());
        modifiedProfile.setStudyStyles(profileModel.getStudyStyles());
        modifiedProfile.setStudySpotPreferences(profileModel.getStudySpotPreferences());
        modifiedProfile.setStudyBuddyPreferences(profileModel.getSBYear(), profileModel.getSBFieldOfStudy(), profileModel.getSBDescriptions());
        return new Profile();
    }
}
