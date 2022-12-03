package spots.entities;

import java.util.ArrayList;
import java.util.Objects;

public class RecGenerator {
    /**
     * Selected preferred study spots from a users profile
     */
    private ArrayList<String> prefSpots1, prefSpots2;
    /**
     * Recommended study spots
     */
    private ArrayList<String> recommendation;
    /**
     * Options of non-mutual study spots
     */
    private ArrayList<String> options;

    /**
     * Construct a RecGenerator
     */
    public RecGenerator(){
        this.recommendation = new ArrayList<>();
        this.options = new ArrayList<>();
    }
    /**
     * Set preferred study spot list from both users of a chatroom
     */
    public void setPrefSpots(ArrayList<String> prefSpots1, ArrayList<String> prefSpots2) {
        this.prefSpots1 = prefSpots1;
        this.prefSpots2 = prefSpots2;
    }
    /**
     * Create potential options from both users' preferred spots
     */
    public void makeOptions(ArrayList<String> prefSpots){
        for(int i = 0; i < 3; i++){
            if(!Objects.equals(prefSpots.get(i), "N/A")){
                options.add(prefSpots.get(i));
            }
        }
    }
    /**
     * Creates a recommendation by comparing mutually preferred spots
     */
    public void recommender(){
        makeOptions(prefSpots1);
        makeOptions(prefSpots2);

        //adding mutually preferred study spots
        for(int i = 0; i < 3; i++){
            String option = prefSpots1.get(i);
            if(prefSpots2.contains(option)){
                recommendation.add(option);
                options.remove(option);
                options.remove(option);
            }
        }
        // if there are less than 3 mutual spots
        int i = 0;
        while (recommendation.size() < 3){
            String[] spots = new String[]{"Robarts Library", "Gerstein Library", "Student Commons",
                    "Hart House", "UC College", "Caven Library", "E.J Pratt Library", "Graham Library", "UC Quad",
                    "SS Commons", "Residence Study Space", "College Classroom", "Bahen Centre", "Brennen Hall"};

            // add a spot randomly from either users' preferred study spots except N/A
            if(!(options.isEmpty())){
                recommendation.add(options.remove(0));
            }
            // if users both picked N/A, add a random spot from the original selection options
            else{
                String random = spots[i];
                if(!(recommendation.contains(random))){ recommendation.add(random);}
                i++;
            }
        }
    }
    /**
     * Returns class variable recommendation
     * @return recommendation
     */
    public ArrayList<String> getRecommendation(){return recommendation;}
}
