package profile;

import account_creation.Account;
import data_persistency.UserDatabase;
import main_app.StudyBuddyApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfileEditUseCaseTest {
    ProfileUI profileUI;
    ProfilePresenter profilePresenter;
    ProfileEditUseCase profileEditUseCase;
    Account account = new Account("jojo", "123");
    Profile emptyProfile = new Profile();
    HashMap<String, List<String>> emptyHashMap = new HashMap<>();
    ProfileInModel profileInModel = new ProfileInModel("jojo", "helicopter", "4+", "Other", Arrays.asList("talkative", "moves around"), emptyHashMap, Arrays.asList("OISE", "Robarts Library"));

    @BeforeEach
    void setUp() {
        // adding the keys into the HashMap
        emptyHashMap.put("year", List.of("1"));
        emptyHashMap.put("field of study", List.of("Humanities"));
        emptyHashMap.put("descriptions", List.of("goal-setting"));

        // setting current user for retrieval of updated profile
        UserDatabase.setCurrentUser(account);

        // setting variable to prevent NullPointer error
        StudyBuddyApp.currUserProfile = emptyProfile;

        profileUI = new ProfileUI();
        profilePresenter = new ProfilePresenter(profileUI);
        profileEditUseCase = new ProfileEditUseCase(profilePresenter);
    }

    /**
     * Test if the ProfileEditUseCase object successfully modifies all fields of the profile given a ProfileInModel object.
     */
    @Test
    void modifyProfileTest() {
        profileEditUseCase.modifyProfile(profileInModel);
        Profile updatedProfile = UserDatabase.getUserDatabase().getCurrentUser().getProfile();
        assertEquals("jojo", updatedProfile.getName());
        assertEquals("helicopter", updatedProfile.getPronouns());
        assertEquals("Other", updatedProfile.getFieldOfStudy());
        assertEquals("4+", updatedProfile.getYear());
        assertEquals(2, updatedProfile.getStudyStyles().size());
        assertEquals(Arrays.asList("OISE", "Robarts Library"), updatedProfile.getStudySpotPreferences());
        assertEquals(emptyHashMap, updatedProfile.getStudyBuddyPreferences());
        assertEquals(0, updatedProfile.getScore());
    }
}