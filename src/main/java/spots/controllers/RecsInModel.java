package spots.controllers;

import java.util.ArrayList;

public class RecsInModel {
    ArrayList<Object> users;

    /**
     * Construct a recommendation using the 2 users of the given chatroom
     * @param user1 user of the chat
     * @param user2 user of the chat
     */
    public RecsInModel(Object user1, Object user2){

        this.users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
    }

    /**
     * Returns a list of the users in the chatroom
     * @return users
     */
    public ArrayList<Object> getUsers(){
        return users;
    }
}
