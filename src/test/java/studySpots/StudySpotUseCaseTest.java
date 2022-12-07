package studySpots;

import account_creation.Account;
import org.junit.jupiter.api.Test;
import spots.presenter.RecsPresenter;
import spots.use_cases.GenerateRec;
import spots.use_cases.RecsOutBoundary;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StudySpotUseCaseTest {
    @Test
    public void testGenerateRecAllMutual() {
        Account user1 = new Account("Karen", "money");
        Account user2 = new Account("Zuck", "fbook");

        String[] studySpots1 = {"Robarts Library", "Gerstein Library", "Student Commons"};
        String[] studySpots2 = {"Robarts Library", "Gerstein Library", "Student Commons"};

        user1.getProfile().setStudySpotPreferences(Arrays.asList(studySpots1));
        user2.getProfile().setStudySpotPreferences(Arrays.asList(studySpots2));


        RecsOutBoundary presenter = new RecsPresenter();
        //RecsInBoundary
        GenerateRec interactor = new GenerateRec(presenter);

        interactor.setParticipants(user1, user2);

        ArrayList<String> correctRec = new ArrayList<>();
        correctRec.add(studySpots1[0]);
        correctRec.add(studySpots1[1]);
        correctRec.add(studySpots1[2]);

        assertEquals(correctRec, interactor.generateRec());
    }
    @Test
    public void testGenerateRecSomeMutual() {
        Account user1 = new Account("Karen", "money");
        Account user2 = new Account("Zuck", "fbook");

        String[] studySpots1 = {"Robarts Library", "College Classroom", "Student Commons"};
        String[] studySpots2 = {"Robarts Library", "College Classroom", "Bahen Centre"};

        user1.getProfile().setStudySpotPreferences(Arrays.asList(studySpots1));
        user2.getProfile().setStudySpotPreferences(Arrays.asList(studySpots2));

        RecsOutBoundary presenter = new RecsPresenter();
        //RecsInBoundary
        GenerateRec interactor = new GenerateRec(presenter);

        interactor.setParticipants(user1, user2);
        ArrayList<String> recs = interactor.generateRec();

        assertTrue(recs.contains("Robarts Library"));
        assertTrue(recs.contains("College Classroom"));
        assertTrue(recs.contains(studySpots1[2]) || recs.contains(studySpots2[2]));
    }
    @Test
    public void testGenerateRecsNotApplicable() {
        Account user1 = new Account("Karen", "money");
        Account user2 = new Account("Zuck", "fbook");

        String[] studySpots1 = {"Robarts Library", "N/A", "N/A"};
        String[] studySpots2 = {"Robarts Library", "Gerstein Library", "N/A"};

        user1.getProfile().setStudySpotPreferences(Arrays.asList(studySpots1));
        user2.getProfile().setStudySpotPreferences(Arrays.asList(studySpots2));

        RecsOutBoundary presenter = new RecsPresenter();
        //RecsInBoundary
        GenerateRec interactor = new GenerateRec(presenter);

        interactor.setParticipants(user1, user2);
        ArrayList<String> recs = interactor.generateRec();

        assertTrue(recs.contains(studySpots1[0]));
        assertTrue(recs.contains(studySpots2[1]));
        assertFalse(recs.contains("N/A"));
    }
}
