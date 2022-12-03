package spots.presenter;

import ui.StudySpotUI;
import spots.controllers.RecsOutModel;
import spots.controllers.RecsOutBoundary;

import javax.swing.*;

public class RecsPresenter implements RecsOutBoundary{
    StudySpotUI studySpots;
    JPanel spotPanel;

    public RecsPresenter(JPanel spotPanel, StudySpotUI studySpots){
        this.spotPanel = spotPanel;
        this.studySpots = studySpots;
    }

    @Override
    public void update(RecsOutModel recs) {
        studySpots.build(spotPanel, recs.getRecs());
    }
}
