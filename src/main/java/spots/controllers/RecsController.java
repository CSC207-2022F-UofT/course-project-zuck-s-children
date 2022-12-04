package spots.controllers;

import spots.useCases.RecsInBoundary;

public class RecsController {
    private RecsInBoundary recommendSpots;

    /**
     * Constructs a controller to create a recommendation list
     *
     * @param recommendSpots an input interface
     */
    public RecsController(RecsInBoundary recommendSpots) {
        this.recommendSpots = recommendSpots;
    }

    /**
     * Create a recommendation list
     */
    public void create() {
        recommendSpots.createRecs();
    }
}
