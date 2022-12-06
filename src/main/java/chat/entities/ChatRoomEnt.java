package chat.entities;

import account_creation.Account;
import data.persistency.UserDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChatRoomEnt implements Serializable {
    /**
     * The id of the chat room.
     */
    private String id;
    private Participants participants;
    public class Participants implements Serializable{
        private Account User1;
        private Account User2;

        /**
         * Return the another user with the different name
         * @throws IllegalArgumentException if myName is not the name of neither of the participants
         * @return the name of the another user
         */
        public String getOtherUser(){
            return UserDatabase.getUserDatabase().getCurrentUser().getUsername().equals(User1.getUsername())?
                    User2.getUsername() : User1.getUsername();
        }

        /**
         * Construct Participants with two accounts of users
         * @param User1
         * @param User2
         */
        public Participants(Account User1, Account User2){
            this.User1 = User1;
            this.User2 = User2;
        }

        /**
         * Return true if and only if the user is in this room
         * @param user
         * @return
         */
        public boolean checkParticipant(Account user){
            return this.User1.getUsername().equals(user.getUsername()) ||
                    this.User2.getUsername().equals(user.getUsername());
        }

        /**
         * Return an array of two participants
         * @return
         */
        public Account[] getParticipants(){
            Account[] participants = {this.User1, this.User2};
            return participants;
        }
    }

    /**
     * A list of messages in this chat room.
     */
    private ArrayList<MessageEnt> messageList;


    /**
     * Construct a ChatRoomEnt
     * @param User1
     * @param User2
     */
    public ChatRoomEnt(Account User1, Account User2){
        this.id = UUID.randomUUID().toString();
        this.participants = new Participants(User1, User2);
        this.messageList = new ArrayList<>();
    }

    /**
     * return the id of this chatroom
     * @return the id of this chatroom
     */
    public String getId(){
        return this.id;
    }

    /**
     * Return the participants of this chatroom
     * @return the participants of this chatroom
     */
    public Participants getParticipants(){
        return this.participants;
    }

    /**
     * Return the list of messages in this chatroom
     * @return the list of messages
     */
    public List<MessageEnt> getMessages(){
        return this.messageList;
    }
    public void addMessage(MessageEnt msg){
        this.messageList.add(msg);
    }

    public String toString() {
        return this.getParticipants().getOtherUser();
    }
}