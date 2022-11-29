package spots.controllers;

import spots.useCases.RecsInBoundary;
/**
 * A controller class for the study spots.
 */
public class RecsController {
    /**
     * Input boundary
     */
    private RecsInBoundary recommendSpots;
    /**
     * Constructor that assigns the value
     */
    public RecsController(RecsInBoundary recommendSpots){
        this.recommendSpots = recommendSpots;
    }
    /**
     *
     */
    public void navigate(RecsInModel recModel){
        recommendSpots.openRecs(recModel);
    }
}
