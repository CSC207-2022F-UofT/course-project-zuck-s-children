package profile;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A user's profile that stores the user's name, pronouns, profile picture, year of study, field of study, study style, study buddy preferences, and study spot preferences.
 * A user's profile that stores the user's name, pronouns, profile picture, year of study, field of study, study style, study buddy preferences, and study spot preferences.
 */

public class Profile {
    public void setName(String name) {
        this.name = name;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    public void setYear(int year) {
        listOfYears.setSelectedValue(year, true);
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldsOfStudyDropdown.setSelectedItem(fieldOfStudy);
    }

    public void setStudyStyles(String studyStyle) {
        this.studyStyles.setSelectedValue(studyStyle, true);
    }

    public void setStudySpotPreferences(String studySpot, int column) {
        this.studySpotPreferences[column].setSelectedItem(studySpot);
    }

    public void setStudyBuddyPreferences(HashMap<String, ArrayList<String>> studyBuddyPreferences) {
        this.studyBuddyPreferences = studyBuddyPreferences;
    }

    /**
     * Return the name of this user.
     * @return the user's name

     * Return which year of university this user is in.
     * @return the year this user is in
     */
    public String getYear() {
        return listOfYears.getSelectedValue().toString();
        }

    /**
     * Return the POSt of this user.
     * @return the program of this user
     */
    public String getFieldOfStudy() {
        return fieldsOfStudyDropdown.getSelectedItem().toString();
    }

    public List<String> getStudyStyles() {
        return studyStyles.getSelectedValuesList();
    }

    public HashMap<String, ArrayList<String>> getStudyBuddyPreferences() {
        HashMap<String, ArrayList<String>> SBP = new HashMap<String, ArrayList<String>>;
        SBP.put("year", studyBuddyPreferences.get("year"));
        SBP.put("field of study", studyBuddyPreferences.get("field of study"));
        SBP.put("descriptions", studyBuddyPreferences.get("descriptions"));
        return SBP;
    }

    public ArrayList<String> getStudySpotPreferences() {
        ArrayList<String> listOfSS = new ArrayList<String>;
        for (JComboBox column : studySpotPreferences) {
            listOfSS.add((String) column.getSelectedItem());
        }
        return listOfSS;
    }

    public String getName() {
        return name;
    }

    private String name;

    public String getPronouns() {
        return pronouns;
    }

    public String pronouns;
    profilePicture;
    final String[] YEARS = {"1", "2", "3", "4", "4+"};
    public JList listOfYears = new JList(YEARS);
    public final String[] FIELDS = {"Humanities", "Social Sciences", "Engineering", "Physical Sciences", "Life Sciences", "Arts", "Rotman Commerce", "Computer Science", "Kinesiology", "Other"};
    public JComboBox<String> fieldsOfStudyDropdown = new JComboBox<String>(FIELDS);
    final String[] STYLES = {"quiet", "talkative"};
    public JList<String> studyStyles = new JList<String>(STYLES);
    public String[] studySpots = {};
    public JComboBox<String> listOfStudySpots1 = new JComboBox<String>(studySpots);
    public JComboBox<String> listOfStudySpots2 = new JComboBox<String>(studySpots);
    public JComboBox<String> listOfStudySpots3 = new JComboBox<String>(studySpots);
    public JComboBox[] studySpotPreferences = new JComboBox[]{listOfStudySpots1, listOfStudySpots2, listOfStudySpots3};
    HashMap<String, ArrayList<String>> studyBuddyPreferences;

    public int getScore() {
        return score;
    }
    private int score;


    public void Profile() {
        studyBuddyPreferences.put("year", null);
        studyBuddyPreferences.put("field of study", null);
        studyBuddyPreferences.put("descriptions", null);
        studyStyles.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

//    /**
//     * Creates a new Profile object for a user. This constructor takes in all arguments.
//     * @param name The user's name
//     * @param pronouns The user's pronouns
//     * @param profilePicture The user's profile picture
//     * @param studyStyle The study style of the user
//     * @param studyBuddyPreference The user's preferences for study buddies
//     * @param studySpotPreferences The user's preferences for study spots
//     */
//
//    public Profile(String name, String pronouns, int year, String fieldOfStudy, ArrayList<String> studyStyle, HashMap<String, ArrayList> studyBuddyPreference, ArrayList<String> studySpotPreferences) {
//        this.name = name;
//        this.pronouns = pronouns;
//        this.year = year;
//        listOfAllFieldsOfStudy.setSelectedItem(fieldOfStudy);
//        this.fieldOfStudy = (String) listOfAllFieldsOfStudy.getSelectedItem();
//        this.studyStyle = studyStyle;
//        this.studyBuddyPreference = studyBuddyPreference;
//        this.studySpotPreferences = studySpotPreferences;
//    }

    public String toString() {
        return "Profile\\nName: " + getName() + "\\nPronouns: " + getPronouns() + "\\nYear: " + getYear() + "\\nField of Study: " + getFieldOfStudy() + "\\nStudy Style: " + getStudyStyles() +
                "\\n\\n-- Study Buddy Preferences --\\nYear: " + studyBuddyPreferences.get("year").toString() + "\\nField of Study: " + studyBuddyPreferences.get("field of study").toString() + "\\nDescriptions: " + studyBuddyPreferences.get("descriptions").toString() + "\\n\\n-- Study Spot Preferences --\\n" + getStudySpotPreferences().toString();
    }
    }
