package spots.use_cases;

import account_creation.Account;
import spots.entities.RecGenerator;

import java.util.ArrayList;

public class GenerateRec implements RecsInBoundary {
    private RecsOutBoundary recsPresenter;

    Account user1, user2;
    RecGenerator spotRecommender = new RecGenerator();

    /**
     * Construct a RecommendedSpots object
     *
     * @param recsPresenter an OutBoundary
     */
    public GenerateRec(RecsOutBoundary recsPresenter) {
        this.recsPresenter = recsPresenter;
    }
    /**
     * Set the 2 users' accounts
     *
     * @param user1 chat room user
     * @param user2 chat room user
     */
    public void setParticipants(Account user1, Account user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    /**
     * Generate a recommendation from the users' spot preferences
     * Invoke methods of GenerateRec Object
     *
     * @return recommendation
     */
    public ArrayList<String> generateRec() {

        ArrayList<String> prefSpots1 = new ArrayList<>(user1.getProfile().getStudySpotPreferences());
        ArrayList<String> prefSpots2 = new ArrayList<>(user2.getProfile().getStudySpotPreferences());

        spotRecommender.setPrefSpots(prefSpots1, prefSpots2);
        spotRecommender.recommender();
        return spotRecommender.getRecommendation();
    }

    /**
     * Create a recommendation
     * Update the user interface with the recommendation
     *
     * @param user1 user in  a chat room
     * @param user2 user in a chat room
     */
    @Override
    public void createRecs(Account user1, Account user2) {
        setParticipants(user1, user2);
        recsPresenter.update(generateRec());
    }
}
