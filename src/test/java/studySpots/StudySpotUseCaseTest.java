package studySpots;

import AccountCreation.Account;
import UI.StudySpotUI;
import org.junit.jupiter.api.Test;
import spots.presenter.RecsPresenter;
import spots.useCases.*;

import javax.swing.*;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StudySpotUseCaseTest {
    @Test
    void create(){
        Account user1 = new Account("Karen","money");
        Account user2 = new Account("Zuck","facebook");

        String[] studySpots1 = {"Robarts Library", "Gerstein Library", "Student Commons"};
        String[] studySpots2 = {"Robarts Library", "Gerstein Library", "Student Commons"};

        user1.getProfile().setStudySpotPreferences(Arrays.stream(studySpots1).toList());
        user1.getProfile().setStudySpotPreferences(Arrays.stream(studySpots2).toList());

        RecsInModel chatUsers = new RecsInModel(user1, user2);

        JPanel panel = new JPanel();
        StudySpotUI ui = new StudySpotUI();

        //RecsOutBoundary recsOutBoundary = new RecsOutBoundary() {
//            @Override
//            public RecsOutModel update(RecsOutModel rec) {
//                assertEquals();
//            }
//        }

        //new RecsPresenter(panel, ui);
        
        //RecsInBoundary useCase = new GenerateRec(recsOutBoundary);
        //useCase.createRecs(chatUsers);
    }
}
