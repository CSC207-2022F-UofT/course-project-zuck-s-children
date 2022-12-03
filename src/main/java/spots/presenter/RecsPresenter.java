package spots.presenter;

import UI.StudySpotUI;
import spots.useCases.RecsOutBoundary;

import java.util.ArrayList;

public class RecsPresenter implements RecsOutBoundary{
    StudySpotUI studySpots;

    /**
     * Construct a Presenter
     * @param studySpots display box of recommendations
     */
    public RecsPresenter(StudySpotUI studySpots){
        this.studySpots = studySpots;
    }
    /**
     * Update studySpots with the given recommendation
     * @param recs String of recommendations
     */
    @Override
    public void update(ArrayList<String> recs) {
        studySpots.build(recs);
        //return recs;
    }
}
