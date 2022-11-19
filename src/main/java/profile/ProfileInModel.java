package profile;

import javax.swing.*;
import java.util.HashMap;

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

    public Object getSBFieldOfStudy() {
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
    public String[] studyStyles;
    public String[] studySpotPreferences;
    public String[] SBDescriptions;
    public Object SBFieldOfStudy;
    public String[] SBYear;


    public ProfileInModel(String name, String pronouns, String year, String fieldOfStudy, String[] studyStyles, String studySpot1, String studySpot2, String studySpot3, String[] SBDescriptions, String[] SBYear) {
        this.name = name;
        this.pronouns = pronouns;
        this.year = year;
        this.fieldOfStudy = fieldOfStudy;
        this.studyStyles = studyStyles;
        this.studySpotPreferences = new String[]{studySpot1, studySpot2, studySpot3};
        this.SBDescriptions = SBDescriptions;
        this.SBYear = SBYear;
    }
}
