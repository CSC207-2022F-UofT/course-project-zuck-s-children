package profile;

import javax.swing.*;
import java.util.HashMap;

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
    public String[] listOfValidInputCheckMsgs;


    public ProfileOutModel(ProfileInModel inModel, String[] listOfValidInputCheckMsgs) {
        this.name = inModel.getName();
        this.pronouns = inModel.getPronouns();
        this.year = inModel.getYear();
        this.fieldOfStudy = inModel.getFieldOfStudy();
        this.studyStyles = inModel.getStudyStyles();
        this.studySpotPreferences = inModel.getStudySpotPreferences();
        this.SBDescriptions = inModel.getSBDescriptions();
        this.SBYear = inModel.getSBYear();
        this.listOfValidInputCheckMsgs = listOfValidInputCheckMsgs;
    }
}
