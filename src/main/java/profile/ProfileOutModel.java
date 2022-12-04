package profile;

import java.util.HashMap;
import java.util.List;

public class ProfileOutModel {
    public String getName() {
        return name;
    }

    public String getPronouns() {
        return pronouns;
    }

    public String getYear() {
        return year;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public List<String> getStudyStyles() {
        return studyStyles;
    }

    public List<String> getStudySpotPreferences() {
        return studySpotPreferences;
    }
    public HashMap<String, List<String>> getStudyBuddyPreferences() {
        return studyBuddyPreferences;
    }

    private String name;
    public String pronouns;
    // profilePicture;
    public String year;
    public String fieldOfStudy;
    public List<String> studyStyles;
    public List<String> studySpotPreferences;
    public HashMap<String, List<String>> studyBuddyPreferences;

    public ProfileOutModel(profile.ProfileInModel inModel) {
        this.name = inModel.getName();
        this.pronouns = inModel.getPronouns();
        this.year = inModel.getYear();
        this.fieldOfStudy = inModel.getFieldOfStudy();
        this.studyStyles = inModel.getStudyStyles();
        this.studySpotPreferences = inModel.getStudySpotPreferences();
        this.studyBuddyPreferences = inModel.getStudyBuddyPreferences();
    }
}