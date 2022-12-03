package spots.controllers;

import spots.useCases.RecsInBoundary;
import spots.useCases.RecsInModel;

public class RecsController {
    private RecsInBoundary recommendSpots;
    /**
     * Constructs a controller to create a recommendation list
     * @param recommendSpots an input interface
     */
    public RecsController(RecsInBoundary recommendSpots){
        this.recommendSpots = recommendSpots;
    }
    /**
     * Create a recommendation list
     * @param recModel 2 users of the chatroom
     */
    public void create(RecsInModel recModel){
        recommendSpots.createRecs(recModel);
    }
}
