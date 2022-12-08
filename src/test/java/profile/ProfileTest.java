package profile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest {
    Profile profile = new Profile();
    List<String> emptyList = new ArrayList<>();
    HashMap<String, List<String>> emptyHashMap = new HashMap<>();
    @BeforeEach
    public void setUp() {
        emptyHashMap.put("year", emptyList);
        emptyHashMap.put("field of study", emptyList);
        emptyHashMap.put("descriptions", emptyList);
    }

    /**
     * Test if the Profile constructor correctly sets up an empty profile.
     */
    @Test
    public void createEmptyProfileTest() {
        assertEquals("N/A", profile.getName());
        assertEquals("N/A", profile.getPronouns());
        assertEquals("N/A", profile.getFieldOfStudy());
        assertEquals("N/A", profile.getYear());
        assertEquals(emptyList, profile.getStudyStyles());
        assertEquals(emptyList, profile.getStudySpotPreferences());
        assertEquals(emptyHashMap, profile.getStudyBuddyPreferences());
        assertEquals(0, profile.getScore());
    }

    /**
     * Test if the Profile setters correctly sets up all fields in the profile.
     */
    @Test
    public void allGettersAndSettersTest() {
        profile.setName("Xi Wang");
        assertEquals("Xi Wang", profile.getName());
        profile.setPronouns("she/her");
        assertEquals("she/her", profile.getPronouns());
        profile.setYear("2");
        assertEquals("2", profile.getYear());
        profile.setFieldOfStudy("Other");
        assertEquals("Other", profile.getFieldOfStudy());
        profile.setStudyStyles(Arrays.asList("quiet", "moves around"));
        assertTrue(profile.getStudyStyles().contains("quiet"));
        assertTrue(profile.getStudyStyles().contains("moves around"));
        assertEquals(2, profile.getStudyStyles().size());
        emptyHashMap.replace("year", Arrays.asList("2", "3", "4"));
        emptyHashMap.replace("field of study", Arrays.asList("Engineering", "Physical Sciences", "Life Sciences", "Arts", "Computer Science"));
        emptyHashMap.replace("descriptions", List.of("quiet"));
        profile.setStudyBuddyPreferences(emptyHashMap);
        assertEquals(3, profile.getStudyBuddyPreferences().get("year").size());
        assertTrue(profile.getStudyBuddyPreferences().get("year").containsAll(Arrays.asList("2", "3", "4")));
        assertEquals(5, profile.getStudyBuddyPreferences().get("field of study").size());
        assertEquals("quiet", profile.getStudyBuddyPreferences().get("descriptions").get(0));
        assertEquals(1, profile.getStudyBuddyPreferences().get("descriptions").size());
        profile.setStudySpotPreferences(Arrays.asList("Robarts Library", "Graham Library"));
        assertEquals(2, profile.getStudySpotPreferences().size());
        assertTrue(profile.getStudySpotPreferences().containsAll(Arrays.asList("Robarts Library", "Graham Library")));
        profile.setScore(3);
        assertEquals(3, profile.getScore());
    }

    @AfterEach
    void tearDown() {
        emptyHashMap.replace("year", emptyList);
        emptyHashMap.replace("field of study", emptyList);
        emptyHashMap.replace("descriptions", emptyList);
    }
}