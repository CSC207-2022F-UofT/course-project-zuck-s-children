package spots.controllers;

import java.util.ArrayList;

public class RecsOutModel {
    /**
     * An OutputModel
     */
    StringBuilder recommendation;

    public RecsOutModel(ArrayList<String> recs){
        this.recommendation = new StringBuilder();
        for(int i = 0; i < 3; i++){
            recommendation.append(recs.get(i));
            recommendation.append(", ");
        }
    }

    public String getRecs(){
        return recommendation.toString();
    }
}
