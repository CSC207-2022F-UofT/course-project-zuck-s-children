package Matching;

import AccountCreation.Account;
import Swipe.Screen.SwiperPresenterFormatter;
import Swipe.SwiperInteractor;
import Swipe.SwiperPresenter;
import Swipe.SwiperRequestModel;
import data.persistency.UserDatabase;
import org.junit.jupiter.api.Test;
import matching.MatchingAlgorithm;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MatchingAlgorithmTest {




    @Test
    public void testMatching() {

        // makeshift profiles for testing

        // Lance profile
        Account Lance = new Account("Lance", "password");

        UserDatabase.setCurrentUser(Lance);
        Lance.getProfile().setName("Lance");
        Lance.getProfile().setPronouns("he/him");
        Lance.getProfile().setYear("3");
        Lance.getProfile().setFieldOfStudy("Cognitive Science");
        // lance's study styles
        List<String> LanceStudyStyles = new ArrayList<>();
        LanceStudyStyles.add("Quiet");
        LanceStudyStyles.add("Long");
        LanceStudyStyles.add("Visual");
        Lance.getProfile().setStudyStyles(LanceStudyStyles);

        //lance's study spot preferences
        List<String> LanceStudySpotPreferences = new ArrayList<>();
        LanceStudyStyles.add("Robarts");
        LanceStudyStyles.add("Gerstein");
        LanceStudyStyles.add("TTC");
        Lance.getProfile().setStudySpotPreferences(LanceStudySpotPreferences);

        //lance's study buddy preferences
        HashMap<String, List<String>> LanceStudyBuddyPreferences = new HashMap<>();
        List<String> LanceYearPreferences = new ArrayList<>();
        List<String> LanceFieldPreferences = new ArrayList<>();
        List<String> LanceStylePreferences = new ArrayList<>();

        LanceYearPreferences.add("2");
        LanceFieldPreferences.add("Computer Science");
        LanceFieldPreferences.add("Cognitive Science");
        LanceStylePreferences.add("Quiet");
        LanceStylePreferences.add("Long");
        LanceStylePreferences.add("Audio");

        LanceStudyBuddyPreferences.put("year", LanceYearPreferences);
        LanceStudyBuddyPreferences.put("field", LanceFieldPreferences);
        LanceStudyBuddyPreferences.put("style", LanceStylePreferences);
        Lance.getProfile().setStudyBuddyPreferences(LanceStudyBuddyPreferences);

        // Kenji Profile
        Account Kenji = new Account("Kenji", "password");

        Kenji.getProfile().setName("Kenji");
        Kenji.getProfile().setPronouns("he/him");
        Kenji.getProfile().setYear("2");
        Kenji.getProfile().setFieldOfStudy("Computer Science");
        // Kenji's study styles
        List<String> KenjiStudyStyles = new ArrayList<>();
        KenjiStudyStyles.add("Quiet");
        KenjiStudyStyles.add("Long");
        KenjiStudyStyles.add("Audio");
        Kenji.getProfile().setStudyStyles(KenjiStudyStyles);

        //Kenji's study spot preferences
        List<String> KenjiStudySpotPreferences = new ArrayList<>();
        KenjiStudyStyles.add("Robarts");
        KenjiStudyStyles.add("Gerstein");
        KenjiStudyStyles.add("TTC");
        Kenji.getProfile().setStudySpotPreferences(KenjiStudySpotPreferences);

        //Kenji's study buddy preferences
        HashMap<String, List<String>> KenjiStudyBuddyPreferences = new HashMap<>();
        List<String> KenjiYearPreferences = new ArrayList<>();
        List<String> KenjiFieldPreferences = new ArrayList<>();
        List<String> KenjiStylePreferences = new ArrayList<>();

        KenjiYearPreferences.add("2");
        KenjiYearPreferences.add("3");
        KenjiFieldPreferences.add("Computer Science");
        KenjiFieldPreferences.add("Cognitive Science");
        KenjiStylePreferences.add("Quiet");
        KenjiStylePreferences.add("Loud");

        KenjiStudyBuddyPreferences.put("year", KenjiYearPreferences);
        KenjiStudyBuddyPreferences.put("field", KenjiFieldPreferences);
        KenjiStudyBuddyPreferences.put("style", KenjiStylePreferences);
        Kenji.getProfile().setStudyBuddyPreferences(KenjiStudyBuddyPreferences);

        // Nina Profile
        Account Nina = new Account("Nina", "password");

        Nina.getProfile().setName("Nina");
        Nina.getProfile().setPronouns("she/her");
        Nina.getProfile().setYear("3");
        Nina.getProfile().setFieldOfStudy("Computer Science");
        // Nina's study styles
        List<String> NinaStudyStyles = new ArrayList<>();
        NinaStudyStyles.add("Loud");
        NinaStudyStyles.add("Long");
        NinaStudyStyles.add("Visual");
        Nina.getProfile().setStudyStyles(NinaStudyStyles);

        //Nina's study spot preferences
        List<String> NinaStudySpotPreferences = new ArrayList<>();
        NinaStudyStyles.add("Robarts");
        NinaStudyStyles.add("Gerstein");
        NinaStudyStyles.add("TTC");
        Nina.getProfile().setStudySpotPreferences(NinaStudySpotPreferences);

        //Nina's study buddy preferences
        HashMap<String, List<String>> NinaStudyBuddyPreferences = new HashMap<>();
        List<String> NinaYearPreferences = new ArrayList<>();
        List<String> NinaFieldPreferences = new ArrayList<>();
        List<String> NinaStylePreferences = new ArrayList<>();

        NinaYearPreferences.add("2");
        NinaYearPreferences.add("3");
        NinaFieldPreferences.add("Computer Science");
        NinaFieldPreferences.add("Cognitive Science");
        NinaStylePreferences.add("Quiet");
        NinaStylePreferences.add("Loud");

        NinaStudyBuddyPreferences.put("year", NinaYearPreferences);
        NinaStudyBuddyPreferences.put("field", NinaFieldPreferences);
        NinaStudyBuddyPreferences.put("style", NinaStylePreferences);
        Nina.getProfile().setStudyBuddyPreferences(NinaStudyBuddyPreferences);

        // Other Users
        ArrayList<Account> oUsers = new ArrayList<>();
        oUsers.add(Nina);
        oUsers.add(Kenji);

        MatchingAlgorithm.MatchingAlgorithm(Lance, oUsers);

        // need to change test1 to a LinkedList
        LinkedList<Account> test1 = new LinkedList<>();
        test1.add(Kenji);
        test1.add(Nina);
        //asserts True if oUsers == Kenji, Nina
        assertEquals(oUsers, test1);


    }
}
