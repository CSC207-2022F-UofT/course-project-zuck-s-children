package profile;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfileBuilderTest {
    ProfileBuilder profileBuilder = new ProfileBuilder();

    /**
     * Test if the ProfileBuilder class successfully builds an empty profile.
     */
    @Test
    void emptyProfile() {
        profile.Profile profile = new profile.Profile();
        profile.ProfileInModel profileInModel = new profile.ProfileInModel(profile.getName(), profile.getPronouns(), profile.getYear(), profile.getFieldOfStudy(), profile.getStudyStyles(), profile.getStudyBuddyPreferences(), profile.getStudySpotPreferences());
        profileBuilder.createNewProfile(profileInModel);
        assertEquals("N/A", profileInModel.getName());
        assertEquals("N/A", profileInModel.getPronouns());
        assertEquals("N/A", profileInModel.getFieldOfStudy());
        assertEquals("N/A", profileInModel.getYear());
        List<String> emptyList = new ArrayList<>();
        assertEquals(emptyList, profileInModel.getStudyStyles());
        assertEquals(emptyList, profileInModel.getStudySpotPreferences());
        HashMap<String, List<String>> emptyHashMap = new HashMap<>();
        emptyHashMap.put("year", emptyList);
        emptyHashMap.put("field of study", emptyList);
        emptyHashMap.put("descriptions", emptyList);
        assertEquals(emptyHashMap, profileInModel.getStudyBuddyPreferences());
    }

}