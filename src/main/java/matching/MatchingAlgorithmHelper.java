package matching;

import java.lang.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import profile.*;

public class MatchingAlgorithmHelper {

    public static void assignScore(String key, HashMap preferences, Profile oUser) {


        // can change this to apply for all keys, need to see how joy implements preferences
        // if they are all sorted then can apply and dont need to check if key =

        // 3 keys: year, field, descriptions
        // year preferences are sorted
        int score = oUser.getScore();

        //compare years
        if (Objects.equals(key, "year")) {
            years = preferences[year];
            ArrayList<String> years = (ArrayList<String>) preferences.get("year");
            for (int i = 0; i < years.size(); i++) {
                if (years.get(i) == oUser.getYear()) {
                    score += 1;

                }
            }
        }

        //compare field
        if (Objects.equals(key, "field")) {
            field = preferences[field];
            ArrayList<String> field = (ArrayList<String>) preferences.get("field of study");
            for (int i = 0; i < field.size(); i++) {
                if (field.get(i).equals(oUser.getFieldOfStudy())) {
                    score += 1;
                }
            }
        }

        //compare descriptions
        if (Objects.equals(key, "descriptions")) {
            descriptions = preferences[descriptions];
            ArrayList<String> descriptions = (ArrayList<String>) preferences.get("descriptions");
            for (int i = 0; i < descriptions.size(); i++) {
                // if oUser.getDescriptions().contains(descriptions.get(i) maybe this line
                if (descriptions.get(i).in(oUser.getDescriptions())) {
                    // descriptions toString will return Arraylist of descriptions
                    score += 1;
                }
            }
        }

        oUser.setScore(score);
    }
}
