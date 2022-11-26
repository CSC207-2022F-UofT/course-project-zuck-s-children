package profile;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A user's profile that stores the user's name, pronouns, year of study, field of study, study styles, study buddy preferences, and study spot preferences.
 */

public class Profile {
    /**
     * Sets the user's name
     *
     * @param name the user's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the user's pronouns
     *
     * @param pronouns
     */
    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    /**
     * Sets the user's year in university
     *
     * @param year the user's year in university
     */
    public void setYear(String year) {
        listOfYears.setSelectedValue(year, true);
    }

    /**
     * Sets the user's field of study
     *
     * @param fieldOfStudy
     */
    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldsOfStudyDropdown.setSelectedItem(fieldOfStudy);
    }

    /**
     * Sets the user's study styles
     *
     * @param studyStyles the user's study styles
     */
    public void setStudyStyles(String[] studyStyles) {
        for (String studyStyle : studyStyles) {
            this.studyStyles.setSelectedValue(studyStyle, true);
        }
    }

    /**
     * Sets the user's preferred study spots
     *
     * @param studySpotPreferences the user's preferred study spots
     */
    public void setStudySpotPreferences(String[] studySpotPreferences) {
        for (int i = 0; i < studySpotPreferences.length; i++) {
            this.studySpotPreferences[i].setSelectedItem(studySpotPreferences[i]);
        }
    }

    /**
     * Sets the user's preferences for their ideal study buddy
     *
     * @param year
     * @param field
     * @param descriptions
     */
    public void setStudyBuddyPreferences(String[] year, String[] field, String[] descriptions) {
        this.studyBuddyPreferences.replace("year", year);
        this.studyBuddyPreferences.replace("field of study", field);
        this.studyBuddyPreferences.replace("descriptions", descriptions);
    }

    /**
     * Return the name of this user.
     *
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Return the pronouns of this user.
     *
     * @return the user's pronouns
     */
    public String getPronouns() {
        return pronouns;
    }

    /**
     * Return which year in university this user is in.
     *
     * @return the year this user is in
     */
    public String getYear() {
        return listOfYears.getSelectedValue();
    }

    /**
     * Return the field of study of this user.
     *
     * @return the field of study of this user
     */
    public String getFieldOfStudy() {
        return (String) fieldsOfStudyDropdown.getSelectedItem();
    }

    /**
     * Return the study styles of this user.
     *
     * @return a List of the user's study styles (String)
     */
    public List<String> getStudyStyles() {
        return studyStyles.getSelectedValuesList();
    }

    /**
     * Return the user's preferences for their ideal study buddy in a HashMap. Each key is the year, field of study, and descriptions of the study buddy.
     *
     * @return the user's study buddy preferences
     */
    public HashMap<String, List<String>> getStudyBuddyPreferences() {
        HashMap<String, List<String>> SBP = new HashMap<String, List<String>>();
        SBP.put("year", ((JList<String>) studyBuddyPreferences.get("year")).getSelectedValuesList());
        SBP.put("field of study", ((JList<String>) studyBuddyPreferences.get("field of study")).getSelectedValuesList());
        SBP.put("descriptions", ((JList<String>) studyBuddyPreferences.get("descriptions")).getSelectedValuesList());
        return SBP;
    }

    /**
     * Return the user's preferred study spots.
     *
     * @return user's preferred study spots
     */
    public ArrayList<String> getStudySpotPreferences() {
        ArrayList<String> listOfSS = new ArrayList<String>();

        for (JComboBox<String> column : studySpotPreferences) {
            listOfSS.add((String) column.getSelectedItem());
        }
        return listOfSS;
    }


    private String name;
    public String pronouns;
    // profilePicture;
    public static final String[] YEARS = {"1", "2", "3", "4", "4+"};
    public static final String[] FIELDS = {"Humanities", "Social Sciences", "Engineering", "Physical Sciences", "Life Sciences", "Arts", "Rotman Commerce", "Computer Science", "Kinesiology", "Other"};
    public JComboBox<String> fieldsOfStudyDropdown = new JComboBox<String>(FIELDS);
    public static final String[] STYLES = {"quiet", "talkative"};
    public JList<String> studyStyles = new JList<String>(STYLES);
    public static String[] studySpots = {"Robarts Library", "Gerstein Library", "Student Commons",
            "Hart House", "UC College", "Caven Library", "E.J Pratt Library", "Graham Library", "UC Quad",
            "SS Commons", "Residence Study Space", "College Classroom", "Bahen Centre", "Brennen Hall"};
    public JComboBox<String> listOfStudySpots1 = new JComboBox<String>(studySpots);
    public JComboBox<String> listOfStudySpots2 = new JComboBox<String>(studySpots);
    public JComboBox<String> listOfStudySpots3 = new JComboBox<String>(studySpots);
    public JComboBox[] studySpotPreferences = new JComboBox[]{listOfStudySpots1, listOfStudySpots2, listOfStudySpots3};
    HashMap<String, Object> studyBuddyPreferences;

    /**
     * Returns the compatibility score of the user to the user currently logged in.
     *
     * @return the user's compatibility score
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the user's compatibility score with the user currently logged in.
     *
     * @param score the user's compatibility score
     */
    public void setScore(int score) {
        this.score = score;
    }

    private int score = 0;

    /**
     * Construct a new Profile object.
     */
    public void Profile() {
        listOfYears.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studyBuddyPreferences.put("year", new JList<String>(YEARS));
        studyBuddyPreferences.put("field of study", new JList<String>(FIELDS));
        studyBuddyPreferences.put("descriptions", new JList<String>(STYLES));
        studyStyles.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    /**
     * Check if the user input no more than three study styles for themselves.
     *
     * @return whether the user has input no more than three study styles for themselves
     */
    public boolean validStudyStyleInput() {
        return studyStyles.getSelectedValuesList().size() <= 3;
    }

    /**
     * Check if the user input no more than three study styles for their ideal study buddy.
     *
     * @return whether the user has input no more than three study styles for their ideal study buddy
     */
    public boolean validSBStudyStyleInput() {
        if (((JList<String>) studyBuddyPreferences.get("descriptions")).getSelectedValuesList().size() > 3) {
            return false;
        }
        return true;
    }

    /**
     * Check if the user input no more than three fields of study for their ideal study buddy.
     *
     * @return whether the user has input no more than three fields of study for their ideal study buddy
     */
    public boolean validSBStudyFieldsInput() {
        return ((JList<String>) studyBuddyPreferences.get("field of study")).getSelectedValuesList().size() <= 3;
    }

    /**
     * Returns a string representation of the profile.
     *
     * @return the profile in string
     */
    @Override
    public String toString() {
        return "Profile\\nName: " + getName() + "\\nPronouns: " + getPronouns() + "\\nYear: " + getYear() + "\\nField of Study: " + getFieldOfStudy() + "\\nStudy Style: " + getStudyStyles() +
                "\\n\\n-- Study Buddy Preferences --\\nYear: " + studyBuddyPreferences.get("year").toString() + "\\nField of Study: " + studyBuddyPreferences.get("field of study").toString() + "\\nDescriptions: " + studyBuddyPreferences.get("descriptions").toString() + "\\n\\n-- Study Spot Preferences --\\n" + getStudySpotPreferences().toString();
    }
}
