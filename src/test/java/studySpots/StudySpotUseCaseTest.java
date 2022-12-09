package studySpots;

import account_and_login.account_creation.Account;
import org.junit.jupiter.api.Test;
import spots.presenter.RecsPresenter;
import spots.use_cases.GenerateRec;
import spots.use_cases.RecsOutBoundary;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudySpotUseCaseTest {
    @Test
    public void testGenerateRecAllMutual() {
        Account user1 = new Account("Karen", "money");
        Account user2 = new Account("Zuck", "fbook");

        List<String> studySpots1 = List.of(new String[]{"Robarts Library", "Gerstein Library", "Student Commons"});
        List<String> studySpots2 = List.of(new String[]{"Robarts Library", "Gerstein Library", "Student Commons"});

        user1.getProfile().setStudySpotPreferences(studySpots1);
        user2.getProfile().setStudySpotPreferences(studySpots2);


        RecsOutBoundary presenter = new RecsPresenter();
        //RecsInBoundary
        GenerateRec interactor = new GenerateRec(presenter);

        interactor.setParticipants(user1, user2);

        ArrayList<String> correctRec = new ArrayList<>();
        correctRec.add(studySpots1.get(0));
        correctRec.add(studySpots1.get(1));
        correctRec.add(studySpots1.get(2));

        assertEquals(correctRec, interactor.generateRec());
    }

    @Test
    public void testGenerateRecSomeMutual() {
        Account user1 = new Account("Karen", "money");
        Account user2 = new Account("Zuck", "fbook");

        List<String> studySpots1 = List.of(new String[]{"Robarts Library", "College Classroom", "Student Commons"});
        List<String> studySpots2 = List.of(new String[]{"Robarts Library", "College Classroom", "Bahen Centre"});

        user1.getProfile().setStudySpotPreferences(studySpots1);
        user2.getProfile().setStudySpotPreferences(studySpots2);

        RecsOutBoundary presenter = new RecsPresenter();
        GenerateRec interactor = new GenerateRec(presenter);

        interactor.setParticipants(user1, user2);
        ArrayList<String> recs = interactor.generateRec();

        assertTrue(recs.contains("Robarts Library"));
        assertTrue(recs.contains("College Classroom"));
        assertTrue(recs.contains(studySpots1.get(2)) || recs.contains(studySpots2.get(2)));
    }

    @Test
    public void testGenerateRecsNotApplicable() {
        Account user1 = new Account("Karen", "money");
        Account user2 = new Account("Zuck", "fbook");

        List<String> studySpots1 = List.of(new String[]{"Robarts Library", "N/A", "N/A"});
        List<String> studySpots2 = List.of(new String[]{"Robarts Library", "Gerstein Library", "N/A"});

        user1.getProfile().setStudySpotPreferences(studySpots1);
        user2.getProfile().setStudySpotPreferences(studySpots2);

        RecsOutBoundary presenter = new RecsPresenter();
        GenerateRec interactor = new GenerateRec(presenter);

        interactor.setParticipants(user1, user2);
        ArrayList<String> recs = interactor.generateRec();

        assertEquals("Robarts Library", recs.get(0));
        assertEquals("Gerstein Library", recs.get(1));

        assertFalse(recs.contains("N/A"));
    }
}
