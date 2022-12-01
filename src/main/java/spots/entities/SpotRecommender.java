package spots.entities;

import java.util.ArrayList;
import java.util.Objects;

public class SpotRecommender {
    // add java docs
    private ArrayList<String> prefSpots1, prefSpots2;
    private ArrayList<String> recommendation;
    private ArrayList<String> options;

    /**
     */
    public SpotRecommender(){
        this.recommendation = new ArrayList<>();
        this.options = new ArrayList<>();
    }

    public void setPrefSpots(ArrayList<String> prefSpots1, ArrayList<String> prefSpots2) {
        this.prefSpots1 = prefSpots1;
        this.prefSpots2 = prefSpots2;
    }

    public void makeOptions(ArrayList<String> prefSpots){
        for(int i = 0; i < 3; i++){
            if(!Objects.equals(prefSpots.get(i), "N/A")){
                options.add(prefSpots.get(i));
            }
        }
    }
    public void recommender(){
        makeOptions(prefSpots1);
        makeOptions(prefSpots2);

        for(int i = 0; i < 3; i++){
            String option = prefSpots1.get(i);
            if(prefSpots2.contains(option)){
                recommendation.add(option);
                options.remove(option);
                options.remove(option);
            }
        }

        int i = 0;
        while (recommendation.size() < 3){
            String[] spots = new String[]{"Robarts Library", "Gerstein Library", "Student Commons",
                    "Hart House", "UC College", "Caven Library", "E.J Pratt Library", "Graham Library", "UC Quad",
                    "SS Commons", "Residence Study Space", "College Classroom", "Bahen Centre", "Brennen Hall"};
            //for joy
            if(!(options.isEmpty())){
                recommendation.add(options.remove(0));
            }
            else{
                String random = spots[i];
                if(!(recommendation.contains(random))){ recommendation.add(random);}
                i++;
            }
        }
    }

    public ArrayList<String> getRecommendation(){return recommendation;}
}
