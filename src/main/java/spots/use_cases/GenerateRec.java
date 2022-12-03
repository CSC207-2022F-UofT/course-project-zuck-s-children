package spots.use_cases;


<<<<<<<< HEAD:src/main/java/spots/use_cases/RecommendSpots.java
import account_creation.Account;
import spots.controllers.RecsInModel;
import spots.controllers.RecsOutBoundary;
import spots.controllers.RecsOutModel;
import spots.entities.SpotRecommender;
========
import AccountCreation.Account;
import chat.entities.ChatRoomEnt;
import spots.entities.RecGenerator;
>>>>>>>> a2b851f (Renamed classes and methods):src/main/java/spots/use_cases/GenerateRec.java

import java.util.ArrayList;
public class GenerateRec implements RecsInBoundary{
    private RecsOutBoundary recsPresenter;

    Account user1, user2;
    RecGenerator spotRecommender = new RecGenerator();
    /**
     * Construct a RecommendedSpots object
     * @param recsPresenter an OutBoundary
     */
    public GenerateRec(RecsOutBoundary recsPresenter){ //
        this.recsPresenter = recsPresenter;
    }

    public void setParticipants(ChatRoomEnt.Participants chatUsers){
        user1 = chatUsers.User1; // will fix this
        user2 = chatUsers.User2;
    }

    /**
     * Generate a recommendation from the users' spot preferences
     * Invoke methods of GenerateRec Object
     */
    public ArrayList<String> generateRec(){
//        Account user1 = (Account) users.get(0);
//        Account user2 = (Account) users.get(1);
//
        ArrayList<String> prefSpots1 = (ArrayList<String>) user1.getProfile().getStudySpotPreferences();
        ArrayList<String> prefSpots2 = (ArrayList<String>) user2.getProfile().getStudySpotPreferences();

        spotRecommender.setPrefSpots(prefSpots1, prefSpots2);
        spotRecommender.recommender();
        return spotRecommender.getRecommendation();
    }
    /**
     * Create a recommendation
     * Update the user interface with the recommendation
     */
    @Override
    public void createRecs() {
        //RecsOutModel recModel = new RecsOutModel(generateRec());
        recsPresenter.update(generateRec());
    }
}
