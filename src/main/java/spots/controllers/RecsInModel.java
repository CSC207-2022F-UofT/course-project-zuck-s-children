package spots.controllers;

import AccountCreation.Account; //i will fix this

import java.util.ArrayList;

public class RecsInModel {
    ArrayList<Account> users;

    /**
     * Construct a recommendation using the 2 users of the given chatroom
     * @param user1
     * @param user2
     */
    public RecsInModel(Account user1, Account user2){

        this.users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
    }

    /**
     * Return the id of a chatroom the user leaves
     * @return the chatroom id stored in this model
     */
    public ArrayList<Account> getUsers(){
        return users;
    }
}
