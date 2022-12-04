package spots.presenter;

import UI.StudySpotUI;
import spots.useCases.RecsOutBoundary;

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
