package spots.useCases;

//import swiper.useCases. or chat??
//import chat.presenter...;
//import data.persistency.StudySpotAccessInterface;
import spots.entities.SpotRecommender;

import java.util.ArrayList;
import java.util.List;

public class RecommendSpots {
    private List<String> prefSpots1 = new ArrayList<String>();
    private List<String> prefSpots2 = new ArrayList<String>();

    public ArrayList<String> getRecSpots() {
        SpotRecommender.recommender(prefSpots1, prefSpots2);
        return SpotRecommender.getRecommendation();
    }

    //public spots from userdb

    //public void update
}
