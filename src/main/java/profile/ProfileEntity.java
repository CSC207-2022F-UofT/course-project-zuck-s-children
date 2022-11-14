package profile;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A user's profile that stores the user's name, pronouns, profile picture, year of study, program, study style, study buddy preferences, and study spot preferences.
 */
public class ProfileEntity {
    /**
     * Return the name of this user.
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Return the pronouns of this user.
     * @return the user's pronouns
     */
    public String getPronouns() {
        return pronouns;
    }

    /**
     * Return which year of university this user is in.
     * @return the year this user is in
     */
    public int getYear() {
        return year;
    }

    /**
     * Return the POSt of this user.
     * @return the program of this user
     */
    public ArrayList<String> getFieldOfStudy() {
        return fieldOfStudy;
    }

    public ArrayList<String> getStudyStyle() {
        return studyStyle;
    }

    public HashMap<String, ArrayList> getStudyBuddyPreference() {
        return studyBuddyPreference;
    }

    public ArrayList<String> getStudySpotPreferences() {
        return studySpotPreferences;
    }

    private String name;
    public String pronouns;
    profilePicture;
    int year;
    String fieldOfStudy;
    ArrayList<String> studyStyle, studySpotPreferences;
    HashMap<String, ArrayList> studyBuddyPreference;
    String[] allFieldsOfStudy = {"Humanities", "Social Sciences", "Engineering", "Physical Sciences", "Life Sciences", "Arts", "Rotman Commerce"};
    JComboBox listOfAllFieldsOfStudy = new JComboBox(allFieldsOfStudy);

    /**
     * Creates a new Profile object for a user. This constructor takes in all arguments.
     * @param name The user's name
     * @param pronouns The user's pronouns
     * @param profilePicture The user's profile picture
     * @param studyStyle The study style of the user
     * @param studyBuddyPreference The user's preferences for study buddies
     * @param studySpotPreferences The user's preferences for study spots
     */

    public ProfileEntity(String name, String pronouns, int year, String fieldOfStudy, ArrayList<String> studyStyle, HashMap<String, ArrayList> studyBuddyPreference, ArrayList<String> studySpotPreferences) {
        this.name = name;
        this.pronouns = pronouns;
        this.year = year;
        listOfAllFieldsOfStudy.setSelectedItem(fieldOfStudy);
        this.fieldOfStudy = (String) listOfAllFieldsOfStudy.getSelectedItem();
        this.studyStyle = studyStyle;
        this.studyBuddyPreference = studyBuddyPreference;
        this.studySpotPreferences = studySpotPreferences;
    }
}
