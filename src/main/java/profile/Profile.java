package profile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A user's profile that stores the user's name, pronouns, year of study, field of study, study styles, study buddy preferences, and study spot preferences.
 */

public class Profile implements Serializable {
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
     * @param pronouns the user's pronouns
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
     * @param fieldOfStudy the user's field of study
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
     * Sets the user's compatibility score with the user currently logged in.
     *
     * @param score the user's compatibility score
     */
    public void setScore(int score) {
        this.score = score;
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
        return fieldOfStudy;
    }

    /**
     * Return the study styles of this user.
     *
     * @return a List of the user's study styles (String)
     */
    public List<String> getStudyStyles() {
        return studyStyles;
    }

    /**
     * Return the user's preferences for their ideal study buddy in a HashMap. Each key is the year, field of study, and descriptions of the study buddy.
     *
     * @return the user's study buddy preferences
     */
    public HashMap<String, List<String>> getStudyBuddyPreferences() {
        return studyBuddyPreferences;
    }

    /**
     * Return the user's preferred study spots.
     *
     * @return user's preferred study spots
     */
    public List<String> getStudySpotPreferences() {
        return studySpotPreferences;
    }

    /**
     * Returns the compatibility score of the user to the user currently logged in.
     *
     * @return the user's compatibility score
     */
    public int getScore() {
        return score;
    }

    private String name = "N/A";
    private String pronouns = "N/A";
    public static final String[] YEARS = {"1", "2", "3", "4", "4+"};
    private String year = "N/A";
    public static final String[] FIELDS = {"N/A", "Humanities", "Social Sciences", "Engineering", "Physical Sciences", "Life Sciences", "Faculty of Architecture", "Arts", "Rotman Commerce", "Computer Science", "Kinesiology", "Faculty of Information (iSchool)", "Other"};
    private String fieldOfStudy = "N/A";
    public static final String[] STYLES = {"N/A", "quiet", "talkative", "goal-setting", "moves around", "hard work grinding"};
    private List<String> studyStyles = new ArrayList<>();
    public static final String[] STUDY_SPOTS = {"N/A", "Robarts Library", "Gerstein Library", "UTSU Student Commons", "Hart House", "UC Library", "Caven Library", "E.J. Pratt Library", "Graham Library", "SS Commons", "Residence Study Space", "College Classroom", "Bahen Centre", "Brennen Hall", "OISE", "Kelly Library", "Innis College Library"};
    private List<String> studySpotPreferences = new ArrayList<>();
    private HashMap<String, List<String>> studyBuddyPreferences = new HashMap<>();
    private int score = 0; // the user's compatibility score with the user currently logged in

    /**
     * Construct a new Profile object. The attributes name, pronouns, year, fieldOfStudy should be "N/A" by default. Attributes studyStyles and studySpotPreferences should be empty List objects by default. Attribute studyBuddyPreferences should be a HashMap with keys "year", "field of study", and "descriptions" corresponding to empty Lists.
     */
    public Profile() {
        studyBuddyPreferences.put("year", new ArrayList<>());
        studyBuddyPreferences.put("field of study", new ArrayList<>());
        studyBuddyPreferences.put("descriptions", new ArrayList<>());
    }
}
