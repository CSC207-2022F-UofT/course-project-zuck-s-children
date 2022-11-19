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

    public void setYear(String year) {
        listOfYears.setSelectedValue(year, true);
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldsOfStudyDropdown.setSelectedItem(fieldOfStudy);
    }

    public void setStudyStyles(String[] studyStyles) {
        for (String studyStyle : studyStyles) {this.studyStyles.setSelectedValue(studyStyle, true);};
    }

    public void setStudySpotPreferences(String[] studySpotPreferences) {
        for (int i = 0; i < studySpotPreferences.length; i++) {this.studySpotPreferences[i].setSelectedItem(studySpotPreferences[i]);}
    }

    public void setStudyBuddyPreferences(String[] year, Object field, String[] descriptions) {
        this.studyBuddyPreferences.replace("year", year);
        this.studyBuddyPreferences.replace("field of study", field);
        this.studyBuddyPreferences.replace("descriptions", descriptions);
    }

    /**
     * Return the name of this user.
     * @return the user's name
     * */
    public String getName() {
        return name;
    }
    /**
     * Return the pronouns of this user.
     * @return the user's pronouns
     * */
    public String getPronouns() {
        return pronouns;
    }
    /**
     * Return which year in university this user is in.
     * @return the year this user is in
     */
    public String getYear() {
        return listOfYears.getSelectedValue();
        }
    /**
     * Return the field of study of this user.
     * @return the field of study of this user
     */
    public String getFieldOfStudy() {
        return (String) fieldsOfStudyDropdown.getSelectedItem();
    }
    /**
     * Return the study styles of this user.
     * @return a List of the user's study styles (String)
     */
    public List<String> getStudyStyles() {
        return studyStyles.getSelectedValuesList();
    }

    /**
     * Return the user's preferences for their ideal study buddy. Each key of the HashMap is the
     * @return the user's study buddy preferences
     */
    public HashMap<String, List<String>> getStudyBuddyPreferences() {
        HashMap<String, List<String>> SBP = new HashMap<String, List<String>>;
        SBP.put("year", ((JList<String>) studyBuddyPreferences.get("year")).getSelectedValuesList());
        SBP.put("field of study", ((JList<String>) studyBuddyPreferences.get("field of study")).getSelectedValuesList());
        SBP.put("descriptions", ((JList<String>) studyBuddyPreferences.get("descriptions")).getSelectedValuesList());
        return SBP;
    }

    public ArrayList<String> getStudySpotPreferences() {
        ArrayList<String> listOfSS = new ArrayList<String>;
        for (JComboBox column : studySpotPreferences) {
            listOfSS.add((String) column.getSelectedItem());
        }
        return listOfSS;
    }



    private String name;
    public String pronouns;
    // profilePicture;
    final String[] YEARS = {"1", "2", "3", "4", "4+"};
    public JList<String> listOfYears = new JList(YEARS);
    public final String[] FIELDS = {"Humanities", "Social Sciences", "Engineering", "Physical Sciences", "Life Sciences", "Arts", "Rotman Commerce", "Computer Science", "Kinesiology", "Other"};
    public JComboBox<String> fieldsOfStudyDropdown = new JComboBox<String>(FIELDS);
    final String[] STYLES = {"quiet", "talkative"};
    public JList<String> studyStyles = new JList<String>(STYLES);
    public String[] studySpots = {"Robarts Library", "Gerstein Library"};
    public JComboBox<String> listOfStudySpots1 = new JComboBox<String>(studySpots);
    public JComboBox<String> listOfStudySpots2 = new JComboBox<String>(studySpots);
    public JComboBox<String> listOfStudySpots3 = new JComboBox<String>(studySpots);
    public JComboBox[] studySpotPreferences = new JComboBox[]{listOfStudySpots1, listOfStudySpots2, listOfStudySpots3};
    HashMap<String, Object> studyBuddyPreferences;

    public int getScore() {
        return score;
    }
    private int score;


    public void Profile() {
        listOfYears.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studyBuddyPreferences.put("year", new JList<String>(YEARS));
        studyBuddyPreferences.put("field of study", new JList<String>(FIELDS));
        studyBuddyPreferences.put("descriptions", new JList<String>(STYLES));
        studyStyles.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    public boolean validStudyStyleInput() {
        if (studyStyles.getSelectedValuesList().size() > 3) {return false;}
        return true;
    }

    public boolean validSBStudyStyleInput() {
        if (((JList<String>) studyBuddyPreferences.get("descriptions")).getSelectedValuesList().size() > 3) {return false;}
        return true;
    }

    public boolean validSBStudyFieldsInput() {
        if (((JList<String>) studyBuddyPreferences.get("field of study")).getSelectedValuesList().size() > 3) {return false;}
        return true;
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
