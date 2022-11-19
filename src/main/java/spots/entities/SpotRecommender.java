package spots.entities;

import java.util.List;
import java.util.ArrayList;

public class SpotRecommender { //database
    private static ArrayList<String> recommendation = new ArrayList<>(); //?? arr
    /**
     *
     * @param
     * @param
     * @return recommendation
     */
    public static void recommender(List<String> list1, List<String> list2){
        ArrayList<String> options = new ArrayList<>();
        options.addAll(list1);
        options.addAll(list2);

        for(int i = 0; i < 3; i++){
            if(list2.contains(list1.get(i))){ //  if arr & if none profile
                recommendation.add(list1.get(i));
                options.remove(list1.get(i));
                options.remove(list1.get(i));
            }
        }
        while (recommendation.size() < 3){
            String random = options.get((int) (Math.random() * (-3)));
            recommendation.add(random);
        }
    }
    public static ArrayList<String> getRecommendation(){return recommendation;}
}
