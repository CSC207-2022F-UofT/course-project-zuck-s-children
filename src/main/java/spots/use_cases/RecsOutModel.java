package spots.use_cases;

import java.util.ArrayList;

public class RecsOutModel {
    /**
     * Combined strings of study spots
     */
    StringBuilder recommendation;
    /**
     * Construct an output model from separate Strings to one StringBuilder
     * @param recs Arraylist of recommended spots
     */
    public RecsOutModel(ArrayList<String> recs){
        this.recommendation = new StringBuilder();
        for(int i = 0; i < 3; i++){
            recommendation.append(recs.get(i));
            recommendation.append(", ");
        }
    }
    /**
     * Returns String of recommendations
     * @return recommendation
     */
    public String getRecs(){
        return recommendation.toString();
    }
}
