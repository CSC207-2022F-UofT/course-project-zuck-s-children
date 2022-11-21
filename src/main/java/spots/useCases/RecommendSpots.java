package spots.useCases;

import chat.entities.ChatRoomEnt;
//import chat....OutBoundary;
import AccountCreation.Account;
import profile.Profile;
import spots.entities.SpotRecommender;

import java.util.ArrayList;
public class RecommendSpots { // connect with chatroom
    SpotRecommender spotRecommender = new SpotRecommender();

    //set
    public void generateRec(Account user1, Account user2){
        ArrayList<String> prefSpots1 = user1.getProfile().getStudySpotPreferences();
        ArrayList<String> prefSpots2 = user2.getProfile().getStudySpotPreferences();
        spotRecommender.setPrefSpots(prefSpots1, prefSpots2);
        spotRecommender.recommender();
    }
    public ArrayList<String> getRecSpots() {
        // call everytime, if a selected spot is there then highilght it (D:)
        return spotRecommender.getRecommendation();
    }
    //public void update(){}
}
