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

    public String[] getStudyStyles() {
        return studyStyles;
    }

    public String[] getStudySpotPreferences() {
        return studySpotPreferences;
    }
    public String[] getSBDescriptions() {
        return SBDescriptions;
    }

    public String[] getSBFieldOfStudy() {
        return SBFieldOfStudy;
    }

    public String[] getSBYear() {
        return SBYear;
    }

    private String name;
    public String pronouns;
    // profilePicture;
    public String year;
    public String fieldOfStudy;
    public List<String> studyStyles;
    public List<String> studySpotPreferences;
    public HashMap<String, List<String>> studyBuddyPreferences;


    public ProfileInModel(String name, String pronouns, String year, String fieldOfStudy, List<String> studyStyles, String studySpot1, String studySpot2, String studySpot3, HashMap<String, List<String>> studyBuddyPreferences) {
        this.name = name;
        this.pronouns = pronouns;
        this.year = year;
        this.fieldOfStudy = fieldOfStudy;
        this.studyStyles = studyStyles;
        this.studySpotPreferences = new ArrayList<>();
        this.SBDescriptions = SBDescriptions;
        this.SBYear = SBYear;
        this.SBFieldOfStudy = SBFieldOfStudy;
    }
}
