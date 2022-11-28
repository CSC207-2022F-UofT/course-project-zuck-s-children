package matching;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

import AccountCreation.Account;
import profile.*;

import java.util.*;

public class MatchingAlgorithm {

    /**
     * Back-end matching algorithm that will work with the swiper to determine potential matches.
     * Potential matches are determined by a compatibility score
     *
     * @param user
     * @param otherUsers
     */

    public static LinkedList MatchingAlgorithm(Account user, ArrayList<Account> otherUsers) {
        /**
         * Construct an arraylist of potential matches, giving them a score compatibility
         */

        // set all user's score to 0
        for (int i = 0; i < otherUsers.size(); i++) {
            otherUsers.get(i).getProfile().setScore(0);
        }

        //get preferences
        HashMap<String, List<String>> preferences = user.getProfile().getStudyBuddyPreferences();

        // assign scores to each user
        for (int i = 0; i < otherUsers.size(); i++) {
            Account oUser = otherUsers.get(i);
            for (String key : preferences.keySet()) {
                assignScore(key, preferences, oUser.getProfile());
            }
        }

        // sort users based on descending order of mathscore
//        ArrayList<Account> matches = new ArrayList<Account>(); //potential matches
        Collections.sort(otherUsers);


        // create new LinkedList
        LinkedList<Account> potentialMatches = new LinkedList<>(otherUsers);

        return potentialMatches;
    }

    //should make new class (class file?) for both of the below? or just make comparator a static method?
//    @Override
//    public int compareTo(Account other){
//        return profile.getScore().compareTo(other.getProfile().getScore());
//
//    }

    // sorter
//    public static void sort(ArrayList<Account> list) {
//
//        list.sort((o1, o2) -> compare(o1, o2));
//    }
//
//    // example: https://mkyong.com/java/java-object-sorting-example-comparable-and-comparator/#:~:text=To%20sort%20an%20Object%20by,the%20new%20Fruit%20class%20again.&text=The%20new%20Fruit%20class%20implemented,quantity%20property%20in%20ascending%20order.
//    // override compare users by comparing their scores
//    @Override
//    public static class matchScoreComparator implements Comparator<Account> {
//
//
//        public int compare(Account a1, Account a2) {
//            return a1.getProfile().getScore().compareTo(a2.getProfile().getScore());
//        }
//    }

    public static void assignScore(String key, HashMap preferences, Profile oUser) {


        // can change this to apply for all keys, need to see how joy implements preferences
        // if they are all sorted then can apply and dont need to check if key =

        // 3 keys: year, field, style
        // year preferences are sorted
        int score = oUser.getScore();

        //compare years
        if (Objects.equals(key, "year")) {
            ArrayList<String> years = (ArrayList<String>) preferences.get("year");
            for (int i = 0; i < years.size(); i++) {
                if (years.get(i) == oUser.getYear()) {
                    score += 1;
                }
            }
        }

        //compare field
        if (Objects.equals(key, "field")) {
            ArrayList<String> field = (ArrayList<String>) preferences.get("field of study");
            for (int i = 0; i < field.size(); i++) {
                if (field.get(i).equals(oUser.getFieldOfStudy())) {
                    score += 1;
                }
            }
        }

        //compare style
        if (Objects.equals(key, "style")) {
            ArrayList<String> style = (ArrayList<String>) preferences.get("style");
            for (int i = 0; i < style.size(); i++) {
                if (oUser.getStudyStyles().contains(style.get(i))){
                    // style toString will return Arraylist of style
                    score += 1;
                }
            }
        }
        oUser.setScore(score);
    }
}


