package Profile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ProfileBuilderTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void emptyProfile() {
        profile.Profile profile = new profile.Profile();
        profile.ProfileInModel profileModel = new profile.ProfileInModel(profile.getName(), profile.getPronouns(), profile.getYear(), profile.getFieldOfStudy(), profile.getStudyStyles(), profile.getStudyBuddyPreferences(), profile.getStudySpotPreferences());
        assertEquals("N/A", profileModel.getName());
        assertEquals("N/A", profileModel.getPronouns());
        assertEquals("N/A", profileModel.getFieldOfStudy());
        assertEquals("N/A", profileModel.getYear());
        ArrayList<Object> emptyList = new ArrayList<>();
        assertEquals(emptyList, profileModel.getStudyStyles());
        assertEquals(emptyList, profileModel.getStudySpotPreferences());
        HashMap<Object, Object> emptyHashMap = new HashMap<>();
        emptyHashMap.put("year", emptyList);
        emptyHashMap.put("field of study", emptyList);
        emptyHashMap.put("descriptions", emptyList);
        assertEquals(emptyHashMap, profileModel.getStudyBuddyPreferences());
    }

}