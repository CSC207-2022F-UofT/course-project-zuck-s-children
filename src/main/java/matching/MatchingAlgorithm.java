package matching;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

import account_and_login.account_creation.Account;
import data_persistency.UserDatabase;
import profile.*;

import java.util.*;


public class MatchingAlgorithm {

    /**
     * Back-end matching algorithm that will work with the swiper to determine potential matches.
     * Potential matches are determined by a compatibility score
     *
     * @param user current user
     * @param otherUsers all other users
     */

    public static LinkedList<Account> MatchingAlgorithmMethod(Account user, ArrayList<Account> otherUsers) {
        /*
         * Construct an arraylist of potential matches, giving them a score compatibility
         */

        // set all user's score to 0
        for (Account otherUser : otherUsers) {
            otherUser.getProfile().setScore(0);
        }

        //get preferences
        HashMap<String, List<String>> preferences = user.getProfile().getStudyBuddyPreferences();

        // assign scores to each user
        for (Account oUser : otherUsers) {
            for (String key : preferences.keySet()) {
                assignScore(key, preferences, oUser.getProfile());
            }
        }

        // sort users based on descending order of mathscore
//        ArrayList<Account> matches = new ArrayList<Account>(); //potential matches
        Collections.sort(otherUsers);


        // create new LinkedList
        LinkedList<Account> potentialMatches = new LinkedList<>();
        for (Account otherUser : otherUsers) {
            if (!user.getSeen().contains(otherUser)) {
                potentialMatches.add(otherUser);
            }
        }

        return potentialMatches;
    }

    public static void assignScore(String key, HashMap<String, List<String>> preferences, Profile oUser)  {

        /* Helper method that assigns score, for each matching preference and
        other user style, compatibility score is raised by 1
        * 3 keys: year, field, style
        * year preferences are sorted
         */
        int score = oUser.getScore();

        //compare years
        if (Objects.equals(key, "year")) {
            if(!preferences.get("year").isEmpty()) {
                ArrayList<String> years = (ArrayList<String>) preferences.get("year");
                for (String year : years) {
                    if (Objects.equals(year, oUser.getYear())) {
                        score += 1;
                    }
                }
            }
        }

        //compare field
        if (Objects.equals(key, "field")) {
            if(!preferences.get("field").isEmpty()) {
                ArrayList<String> field = (ArrayList<String>) preferences.get("field");
                for (String s : field) {
                    if (s.equals(oUser.getFieldOfStudy())) {
                        score += 1;
                    }
                }
            }
        }

        //compare style
        if (Objects.equals(key, "style")) {
            if(!preferences.get("style").isEmpty()) {
                ArrayList<String> style = (ArrayList<String>) preferences.get("style");
                for (String s : style) {
                    if (oUser.getStudyStyles().contains(s)) {
                        // style toString will return Arraylist of style
                        score += 1;
                    }
                }
            }
        }
        oUser.setScore(score);
    }

    public static ArrayList<Account> getOthers() {
        /*
        * method to get an arrayList of all other users excluding the current one
         */
        ArrayList<Account> otherUsers = new ArrayList<>();
        for (Account a : UserDatabase.getUserDatabase().getAccounts().values()) {
            if (a != UserDatabase.getUserDatabase().getCurrentUser()) {
                otherUsers.add(a);
            }
        }
        return otherUsers;
    }

    public static LinkedList<Account> finalMatches() {
        /*
         * method to get all finalMatches of the current user
         */
        return MatchingAlgorithmMethod(UserDatabase.getUserDatabase().getCurrentUser(),
                getOthers());
    }
}



