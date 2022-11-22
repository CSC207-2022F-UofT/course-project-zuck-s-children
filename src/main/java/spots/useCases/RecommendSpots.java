package spots.useCases;


import AccountCreation.Account;
import profile.Profile;
import spots.controllers.RecsInModel;
import spots.controllers.RecsOutBoundary;
import spots.controllers.RecsOutModel;
import spots.entities.SpotRecommender;

import java.util.ArrayList;
public class RecommendSpots implements RecsInBoundary{
    private RecsOutBoundary recsPresenter;

    SpotRecommender spotRecommender = new SpotRecommender();

    public ArrayList<String> generateRec(ArrayList<Account> users){
        Account user1 = users.get(0);
        Account user2 = users.get(1);

        ArrayList<String> prefSpots1 = user1.getProfile().getStudySpotPreferences();
        ArrayList<String> prefSpots2 = user2.getProfile().getStudySpotPreferences();

        spotRecommender.setPrefSpots(prefSpots1, prefSpots2);
        spotRecommender.recommender();
        return spotRecommender.getRecommendation();
    }

    @Override
    public void openRecs(RecsInModel recsInModel) {
        RecsOutModel recModel = new RecsOutModel(generateRec(recsInModel.getUsers()));
        recsPresenter.update(recModel);
    }
}
