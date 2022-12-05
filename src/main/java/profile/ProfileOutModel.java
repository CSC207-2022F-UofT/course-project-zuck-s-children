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

    private final String name;
    public final String pronouns;
    // profilePicture;
    public final String year;
    public String fieldOfStudy;
    public List<String> studyStyles;
    public List<String> studySpotPreferences;
    public HashMap<String, List<String>> studyBuddyPreferences;

    public ProfileOutModel(Profile modifiedProfile) {
        this.name = modifiedProfile.getName();
        this.pronouns = modifiedProfile.getPronouns();
        this.year = modifiedProfile.getYear();
        this.fieldOfStudy = modifiedProfile.getFieldOfStudy();
        this.studyStyles = modifiedProfile.getStudyStyles();
        this.studySpotPreferences = modifiedProfile.getStudySpotPreferences();
        this.studyBuddyPreferences = modifiedProfile.getStudyBuddyPreferences();
    }
}