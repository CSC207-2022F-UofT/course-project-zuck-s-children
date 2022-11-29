package profile;

import java.util.List;

public class ProfileFactory {
    public Profile create(ProfileInModel profileModel) {
        Profile modifiedProfile = new Profile();
        modifiedProfile.setName(profileModel.getName());
        modifiedProfile.setPronouns(profileModel.getPronouns());
        modifiedProfile.setYear(profileModel.getYear());
        modifiedProfile.setFieldOfStudy(profileModel.getFieldOfStudy());
        modifiedProfile.setStudyStyles(profileModel.getStudyStyles());
        modifiedProfile.setStudySpotPreferences(profileModel.getStudySpotPreferences());
        modifiedProfile.setStudyBuddyPreferences(profileModel.getStudyBuddyPreferences());
        return new Profile();
    }
}
