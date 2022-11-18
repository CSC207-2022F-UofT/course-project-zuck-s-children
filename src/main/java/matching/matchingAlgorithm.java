package matching;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


public class matchingAlgorithm {
    /**
     * Back-end matching algorithm that will work with the swiper to determine potential matches.
     * Potential matches are determined by a compatibility score


     *
     * @param user              Person using the account
     * @param potentialMatches  List of all other users in database

     */
    public matchingAlgorithm(account user, ArrayList<account> otherUsers){
        /**
         * Construct an arraylist of potential matches, giving them a score compatibility
         *
         * returns a stack of users
         */

        //get preferences
        HashMap preferences = user.getHashMap();


        /* assign scores: brute force
        iterate through each user O(len(potentialMatches)
        use key to look up each part

        iterate through:

            mayb make a helper function to find each?
              -

            - Hashmap studyBuddyPreferences
            - ArrayList preferredYear
            - ArrayList preferredProgram
            - ArrayList descriptions

        assign points to potential match
        */
        for (int i = 0; i < otherUsers.length; i++){
            oUser = otherUsers[i];
            HashMap oUserPreference = oUser.getHashMap();
            for (String key: preferences){
                oUser.assignScore(key, preferences, oUserPreference);
            }
        }

        /* all users have been assigned a score
        - can then sort potential matches based on score
        - create a new copy of potential matches and sort based on score
        OR
        - we can append directly to a queue and return the queue
        */

        // need to create sort
        matches = new List<users>(); //potential matches

        // create new queue
        Queue<User> matches = new PriorityQueue<User> ();

        return matches; //potential matches
    }

    //should make new class (class file?) for both of the below? or just make comparator a static method?

    // sorter
    public static void sort(ArrayList<CustomObject> list) {

        list.sort((o1, o2)
                -> o1.getCustomProperty().compareTo(
                o2.getCustomProperty()));
    }

    // example: https://mkyong.com/java/java-object-sorting-example-comparable-and-comparator/#:~:text=To%20sort%20an%20Object%20by,the%20new%20Fruit%20class%20again.&text=The%20new%20Fruit%20class%20implemented,quantity%20property%20in%20ascending%20order.
    public class matchScoreComparator implements Comparator<accounts> {
        @Override
        // override compare users by comparing their scores
        public int compare(account o1, account o2) {
            return o1.getScore().compareTo(o2.getScore());
        }
    }

}

