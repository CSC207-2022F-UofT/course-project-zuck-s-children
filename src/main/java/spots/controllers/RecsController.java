package spots.controllers;

import account_creation.Account;
import spots.use_cases.RecsInBoundary;

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
     *
     * @param user1 user in a chat room
     * @param user2 user in a chat room
     */
    public void create(Account user1, Account user2) {
        recommendSpots.createRecs(user1, user2);
    }
}
