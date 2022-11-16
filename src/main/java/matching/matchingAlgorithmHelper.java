package matching;

import java.lang.*;
import java.util.*;
import java.util.ArrayList;

public class matchingAlgorithmHelper {

    public static double assignScore(String key, HashMap preferences, profile oUser){


        // can change this to apply for all keys, need to see how joy implements preferences
        // if they are all sorted then can apply and dont need to check if key =

        // 3 keys: year, program, descriptions
        int score = 0;
        // year preferences are sorted

        //compare key

//        preference = preferences[key];
//        oPreference = oUserPreferences[key];
//
//        for (int i = 0, j = 0; (i < preference.length && j < oPreference.length);){
//            if (preference[i] == oPreference[j]){
//                score += 1;
//                i += 1;
//                j += 1;
//            }
//            else if(preference[i] < oPreference[j]){
//                j+= 1;
//            }
//        }
//        return score; // or change profiles score which can be a hidden part of profile
        //compare years
        if (Objects.equals(key, "year")){
            //compare years
            years = preferences[year];

            for (int i = 0; i < years.length ; i++){
                if (years[i] == oUser.getYear()){
                    score += 1;
                    i += 1;
                    j += 1;
                }
                else if(years[i] < oYears[j]){
                    j+= 1;
                }
            }
            return score; // or change profiles score which can be a hidden part of profile
        }

        if (Objects.equals(key, "program")){
            //compare program

        }
        if (Objects.equals(key, "descriptions")){
            //compare descriptions


    }



}



}

