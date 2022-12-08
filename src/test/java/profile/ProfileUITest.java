package profile;

import account_creation.Account;
import data.persistency.UserDatabase;
import main_app.StudyBuddyApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfileUITest {
    ProfileUI profileUI;
    ProfilePresenter profilePresenter;
    ProfileEditUseCase profileEditUseCase;
    ProfileController profileController;
    Account account = new Account("jay", "456");
    Profile emptyProfile = new Profile();
    List<String> emptyList = new ArrayList<>();
    HashMap<String, List<String>> emptyHashMap = new HashMap<>();

    @BeforeEach
    void setUp() {
        // adding the keys into the HashMap
        emptyHashMap.put("year", emptyList);
        emptyHashMap.put("field of study", emptyList);
        emptyHashMap.put("descriptions", emptyList);

        // setting current user for retrieval of updated profile
        UserDatabase.getUserDatabase();
        UserDatabase.setCurrentUser(account);

        // setting variable to prevent NullPointer error
        StudyBuddyApp.currUserProfile = emptyProfile;

        profileUI = new ProfileUI();
        profilePresenter = new ProfilePresenter(profileUI);
        profileEditUseCase = new ProfileEditUseCase(profilePresenter);
        profileController = new ProfileController(profileEditUseCase);
    }

    /**
     * Test if input on the UI's name textfield successfully updates the name of the user's profile, both in the UserDatabase and on the UI.
     */
    @Test
    void modifyNameTest() {
        profileUI.nameTF.setText("jay");
        profileController.modifyProfile(profileUI.generateInModel());
        assertEquals("jay", profileUI.nameTF.getText());
        assertEquals("jay", UserDatabase.getUserDatabase().getCurrentUser().getProfile().getName());
    }

    /**
     * Test if data still get stored in the UserDatabase if the user made no input but toggled the Edit/Save button.
     */
    @Test
    void noModificationTest() {
        profileController.modifyProfile(profileUI.generateInModel());
        assertEquals("N/A", profileUI.nameTF.getText());
        assertEquals("N/A", UserDatabase.getUserDatabase().getCurrentUser().getProfile().getName());
        assertEquals("N/A", profileUI.pronounTF.getText());
        assertEquals("N/A", UserDatabase.getUserDatabase().getCurrentUser().getProfile().getPronouns());
        assertEquals("1", profileUI.yearCB.getSelectedItem());
        assertEquals("1", UserDatabase.getUserDatabase().getCurrentUser().getProfile().getYear());
        assertEquals("N/A", profileUI.fieldCB.getSelectedItem());
        assertEquals("N/A", UserDatabase.getUserDatabase().getCurrentUser().getProfile().getFieldOfStudy());
        assertEquals("N/A", profileUI.style1.getSelectedItem());
        assertEquals(Arrays.asList("N/A", "N/A", "N/A"), UserDatabase.getUserDatabase().getCurrentUser().getProfile().getStudyStyles());
        emptyHashMap.replace("field of study", Arrays.asList("N/A", "N/A", "N/A"));
        emptyHashMap.replace("descriptions", Arrays.asList("N/A", "N/A", "N/A"));
        assertEquals(emptyHashMap, UserDatabase.getUserDatabase().getCurrentUser().getProfile().getStudyBuddyPreferences());
        assertEquals(Arrays.asList("N/A", "N/A", "N/A"), UserDatabase.getUserDatabase().getCurrentUser().getProfile().getStudySpotPreferences());
    }
}