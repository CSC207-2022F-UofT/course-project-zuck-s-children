package spots.controllers;

import chat.control.RoomInModel;
import spots.useCases.RecsInBoundary;

public class RecsController {
    private RecsInBoundary recommendSpots;

    public RecsController(RecsInBoundary recommendSpots){
        this.recommendSpots = recommendSpots;
    }

    public void navigate(RecsInModel recModel){
        recommendSpots.openRecs(recModel);
    }
}
