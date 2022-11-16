package profile;

import UI.components.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudyBuddyPreferencesEntity {
    ArrayList<Integer> preferredYear;
    String preferredProgram;
    String preferredCourse;
    ArrayList<Button> descriptions;

    public StudyBuddyPreferencesEntity(ArrayList<Integer> preferredYear, String preferredProgram, String preferredCourse, ArrayList<Button> descriptions) {
        this.preferredYear = preferredYear;
        this.preferredProgram = preferredProgram;
        this.preferredCourse = preferredCourse;
        this.descriptions = descriptions;
    }

    public List ChangeSelection(Button description) {
        if (descriptions.size() < 3) {
            description.changeSelectionStatus();
            if (description.isSelected()) {
                descriptions.add(description);}
            else {descriptions.remove(description);}
            return descriptions;}
        return false;
    }

    /**
     * Return the HashMap representation of the user's preferences for study buddies.
     * @return a HashMap of study buddy preferences of the user. The keys are "year," "program," and "descriptions." The values are all ArrayLists containing the (String) years, (String) programs, (String) courses, and (String) characteristics of the ideal  buddy the user hopes to study with.
     */
    public HashMap<String, ArrayList> toHashMap() {
        HashMap studyBuddyPreferences = new HashMap(3);
        ArrayList preferredYear;
        ArrayList preferredProgram;
        return studyBuddyPreferences;
    }
}
