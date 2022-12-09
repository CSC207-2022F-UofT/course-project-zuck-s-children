package profile;

import java.util.HashMap;
import java.util.List;

public class ProfileInModel {
    public String getName() {
        return NAME;
    }

    public String getPronouns() {
        return PRONOUNS;
    }

    public String getYear() {
        return YEAR;
    }

    public String getFieldOfStudy() {
        return FIELD_OF_STUDY;
    }

    public List<String> getStudyStyles() {
        return STUDY_STYLES;
    }

    public List<String> getStudySpotPreferences() {
        return STUDY_SPOT_PREFERENCES;
    }

    public HashMap<String, List<String>> getStudyBuddyPreferences() {
        return STUDY_BUDDY_PREFERENCES;
    }

    private final String NAME;
    private final String PRONOUNS;
    // profilePicture;
    private final String YEAR;
    private final String FIELD_OF_STUDY;
    private final List<String> STUDY_STYLES;
    private final List<String> STUDY_SPOT_PREFERENCES;
    private final HashMap<String, List<String>> STUDY_BUDDY_PREFERENCES;


    /**
     * Create a profile inModel for the use case interactor to use, based on edits the user made.
     * @param name the user's name after their edit
     * @param pronouns the user's pronouns after their edit
     * @param year the user's year in university after their edit
     * @param fieldOfStudy the user's field of study after their edit
     * @param studyStyles the user's study styles after their edit
     * @param studyBuddyPreferences the user's study buddy preferences after their edit
     * @param studySpotPreferences the user's study spot preferences after their edit
     */
    public ProfileInModel(String name, String pronouns, String year, String fieldOfStudy, List<String> studyStyles, HashMap<String, List<String>> studyBuddyPreferences, List<String> studySpotPreferences) {
        this.NAME = name;
        this.PRONOUNS = pronouns;
        this.YEAR = year;
        this.FIELD_OF_STUDY = fieldOfStudy;
        this.STUDY_STYLES = studyStyles;
        this.STUDY_SPOT_PREFERENCES = studySpotPreferences;
        this.STUDY_BUDDY_PREFERENCES = studyBuddyPreferences;
    }
}