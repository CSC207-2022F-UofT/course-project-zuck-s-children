package spots.presenter;

import spots.StudySpotUI;
import spots.use_cases.RecsOutBoundary;

import java.util.ArrayList;

public class RecsPresenter implements RecsOutBoundary {

    /**
     * Update studySpots with the given recommendation
     *
     * @param recs String of recommendations
     */
    @Override
    public void update(ArrayList<String> recs) {
        StudySpotUI studySpots = new StudySpotUI();
        studySpots.build(recs);
    }
}
