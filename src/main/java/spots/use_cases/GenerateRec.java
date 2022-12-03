package spots.use_cases;


<<<<<<<< HEAD:src/main/java/spots/use_cases/RecommendSpots.java
import account_creation.Account;
import spots.controllers.RecsInModel;
import spots.controllers.RecsOutBoundary;
import spots.controllers.RecsOutModel;
import spots.entities.SpotRecommender;
========
import AccountCreation.Account;
import spots.entities.RecGenerator;
>>>>>>>> a2b851f (Renamed classes and methods):src/main/java/spots/use_cases/GenerateRec.java

import java.util.ArrayList;
public class GenerateRec implements RecsInBoundary{
    private RecsOutBoundary recsPresenter;
    RecGenerator spotRecommender = new RecGenerator();
    /**
     * Construct a RecommendedSpots object
     * @param recsPresenter an OutBoundary
     */
    public GenerateRec(RecsOutBoundary recsPresenter){ //
        this.recsPresenter = recsPresenter;
    }
    //where to get

    /**
     * Generate a recommendation from the users' spot preferences
     * Invoke methods of GenerateRec Object
     * @param users contains users of a chatroom
     */
    public ArrayList<String> generateRec(ArrayList<Object> users){
        Account user1 = (Account) users.get(0);
        Account user2 = (Account) users.get(1);

        ArrayList<String> prefSpots1 = (ArrayList<String>) user1.getProfile().getStudySpotPreferences();
        ArrayList<String> prefSpots2 = (ArrayList<String>) user2.getProfile().getStudySpotPreferences();

        spotRecommender.setPrefSpots(prefSpots1, prefSpots2);
        spotRecommender.recommender();
        return spotRecommender.getRecommendation();
    }
    /**
     * Create a recommendation
     * Update the view with the recommendation
     * @param recsInModel contains users of a chatroom
     */
    @Override
    public void createRecs(RecsInModel recsInModel) {
        RecsOutModel recModel = new RecsOutModel(generateRec(recsInModel.getUsers()));
        recsPresenter.update(recModel);
    }
}
