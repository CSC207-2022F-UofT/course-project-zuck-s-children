package matching;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

import AccountCreation.Account;

import java.util.*;

public class MatchingAlgorithm {

    /**
     * Back-end matching algorithm that will work with the swiper to determine potential matches.
     * Potential matches are determined by a compatibility score
     * @param user
     * @param potentialMatches  List of all other users in database

     */

    public MatchingAlgorithm(Account user, ArrayList<Account> otherUsers){
        /**
         * Construct an arraylist of potential matches, giving them a score compatibility
         *

         */


        // set all user's score to 0
        for (int i = 0; i < otherUsers.size(); i++){
            otherUsers.get(i).getProfile().setScore(0);
        }

        //get preferences
        HashMap preferences = user.getProfile().getStudyBuddyPreferences();

        // assign scores to each user
        for (int i = 0; i < otherUsers.size(); i++){
            Account oUser = otherUsers.get(i);
            for (String key: preferences.keySet()){
                double score = oUser.getProfile().assignScore(key, preferences, oUser.getProfile());

            }
        }

        // sort users based on descending order of mathscore
        matches = new List<users>(); //potential matches
        Collections.sort(otherUsers, new matchScoreComparator());

        // create new LinkedList
        LinkedList<Account> ret = new LinkedList<Account>();

        return matches; //potential matches
    }

    //should make new class (class file?) for both of the below? or just make comparator a static method?


    // sorter
    public static void sort(ArrayList<Account> list) {

        list.sort((o1, o2) -> o1.getProfile.getScore().compareTo(
                o2.getProfile.getScore()));
    }

    // example: https://mkyong.com/java/java-object-sorting-example-comparable-and-comparator/#:~:text=To%20sort%20an%20Object%20by,the%20new%20Fruit%20class%20again.&text=The%20new%20Fruit%20class%20implemented,quantity%20property%20in%20ascending%20order.
    public static class matchScoreComparator implements Comparator<Account> {
        @Override
        // override compare users by comparing their scores

        public int compare(Account a1, Account a2) {
            return a1.getProfile().getScore().compareTo(a2.getProfile().getScore());
        }
    }

