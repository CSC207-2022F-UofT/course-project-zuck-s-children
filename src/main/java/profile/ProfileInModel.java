package profile;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfileInModel {
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


    public ProfileInModel(String name, String pronouns, String year, String fieldOfStudy, List<String> studyStyles, HashMap<String, List<String>> studyBuddyPreferences, List<String> studySpotPreferences) {
        this.name = name;
        this.pronouns = pronouns;
        this.year = year;
        this.fieldOfStudy = fieldOfStudy;
        this.studyStyles = studyStyles;
        this.studySpotPreferences = studySpotPreferences;
        this.studyBuddyPreferences = studyBuddyPreferences;
    }
}
