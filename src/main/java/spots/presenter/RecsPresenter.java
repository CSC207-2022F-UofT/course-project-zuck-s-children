package spots.presenter;

import UI.StudySpotUI;
import spots.useCases.RecsOutModel;
import spots.useCases.RecsOutBoundary;

import javax.swing.*;

public class RecsPresenter implements RecsOutBoundary{
    StudySpotUI studySpots;
    JPanel spotPanel;

    /**
     * Construct a Presenter
     * @param studySpots display box of recommendations
     * @param spotPanel JPanel containing recommendations
     */
    public RecsPresenter(JPanel spotPanel, StudySpotUI studySpots){
        this.spotPanel = spotPanel;
        this.studySpots = studySpots;
    }
    /**
     * Update studySpots with the given recommendation
     *
     * @param recs String of recommendations
     * @return
     */
    @Override
    public void update(RecsOutModel recs) {
        studySpots.build(spotPanel, recs.getRecs());
        //return recs;
    }
}
