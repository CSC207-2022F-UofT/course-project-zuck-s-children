package matching;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

import account_creation.Account;
import data.persistency.UserDatabase;
import profile.*;

import java.util.*;

public class MatchingAlgorithm {

    /**
     * Back-end matching algorithm that will work with the swiper to determine potential matches.
     * Potential matches are determined by a compatibility score
     *
     * @param user an account of the user
     * @param otherUsers a list of other users
     */

    public static LinkedList MatchingAlgorithmFinal(Account user, ArrayList<Account> otherUsers) {
        /**
         * Construct an arraylist of potential matches, giving them a score compatibility
         */
        ArrayList<Account> accountQueue = new ArrayList<>();

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
                try {
                    assignScore(key, preferences, oUser.getProfile());
                } catch(Exception e){

                }
            }
            if (!oUser.getBuddies().contains(user)){
                accountQueue.add(oUser);
            }
        }

        // sort users based on descending order of mathscore
//        ArrayList<Account> matches = new ArrayList<Account>(); //potential matches
        Collections.sort(accountQueue);

        // create new LinkedList
        LinkedList<Account> potentialMatches = new LinkedList<>(accountQueue);

        return potentialMatches;
    }

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
            ArrayList<String> field = (ArrayList<String>) preferences.get("field");
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
    public static ArrayList<Account> getOthers() {
        ArrayList<Account> otherUsers = new ArrayList<>();
        for (Account a : UserDatabase.getUserDatabase().getAccounts().values()) {
            if (a != UserDatabase.getUserDatabase().getCurrentUser()) {
                otherUsers.add(a);
            }
        }
        return otherUsers;
    }

    public static LinkedList<Account> finalMatches() {
        return MatchingAlgorithmFinal(UserDatabase.getUserDatabase().getCurrentUser(),
                getOthers());
    }
}


