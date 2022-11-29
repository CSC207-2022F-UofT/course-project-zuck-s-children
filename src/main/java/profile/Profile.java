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
        this.year = year;
    }

    /**
     * Sets the user's field of study
     *
     * @param fieldOfStudy
     */
    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    /**
     * Sets the user's study styles
     *
     * @param studyStyles the user's study styles
     */
    public void setStudyStyles(List<String> studyStyles) {
        this.studyStyles = studyStyles;
    }

    /**
     * Sets the user's preferred study spots
     *
     * @param studySpotPreferences the user's preferred study spots
     */
    public void setStudySpotPreferences(List<String> studySpotPreferences) {
        this.studySpotPreferences = studySpotPreferences;
    }

    /**
     * Sets the user's preferences for their ideal study buddy
     *
     * @param studyBuddyPreferences the user's study buddy preferences
     */
    public void setStudyBuddyPreferences(HashMap<String, List<String>> studyBuddyPreferences) {
        this.studyBuddyPreferences = studyBuddyPreferences;
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
        return year;
    }

    /**
     * Return the field of study of this user.
     *
     * @return the field of study of this user
     */
    public String getFieldOfStudy() {
        return this.fieldOfStudy;
    }

    /**
     * Return the study styles of this user.
     *
     * @return a List of the user's study styles (String)
     */
    public List<String> getStudyStyles() {
        return this.studyStyles;
    }

    /**
     * Return the user's preferences for their ideal study buddy in a HashMap. Each key is the year, field of study, and descriptions of the study buddy.
     *
     * @return the user's study buddy preferences
     */
    public HashMap<String, List<String>> getStudyBuddyPreferences() {
        return this.studyBuddyPreferences;
    }

    /**
     * Return the user's preferred study spots.
     *
     * @return user's preferred study spots
     */
    public List<String> getStudySpotPreferences() {
        return studySpotPreferences;
    }


    private String name;
    public String pronouns;
    // profilePicture;
    public static final String[] YEARS = {"1", "2", "3", "4", "4+"};
    public String year;
    public static final String[] FIELDS = {"Humanities", "Social Sciences", "Engineering", "Physical Sciences", "Life Sciences", "Arts", "Rotman Commerce", "Computer Science", "Kinesiology", "Other"};
    public String fieldOfStudy;
    public static final String[] STYLES = {"quiet", "talkative"};
    public List<String> studyStyles;
    public static String[] studySpots = {"Robarts Library", "Gerstein Library", "Student Commons",
            "Hart House", "UC College", "Caven Library", "E.J Pratt Library", "Graham Library", "UC Quad",
            "SS Commons", "Residence Study Space", "College Classroom", "Bahen Centre", "Brennen Hall"};
    public JComboBox<String> listOfStudySpots1 = new JComboBox<String>(studySpots);
    public List<String> studySpotPreferences;
    public HashMap<String, List<String>> studyBuddyPreferences;

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
        studyBuddyPreferences.put("year", new ArrayList<String>());
        studyBuddyPreferences.put("field of study", new ArrayList<String>());
        studyBuddyPreferences.put("descriptions", new ArrayList<String>());
    }

    /**
     * Check if the user input no more than three study styles for themselves.
     *
     * @return whether the user has input no more than three study styles for themselves
     */
    public boolean validStudyStyleInput() {
        return studyStyles.size() <= 3;
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
