package chat.entities;

import account_and_login.account_creation.Account;
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

    private Account user1;
    private Account user2;

    /**
     * A list of messages in this chat room.
     */
    private ArrayList<MessageEnt> messageList;


    /**
     * Construct a ChatRoomEnt
     * @param user1
     * @param user2
     */
    public ChatRoomEnt(Account user1, Account user2){
        this.id = UUID.randomUUID().toString();
        this.user1 = user1;
        this.user2 = user2;
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
     * Return the another user with the different name
     * @return the name of the another user
     */
    public Account getOtherUser(){
        return UserDatabase.getUserDatabase().getCurrentUser().getUsername().equals(user1.getUsername())?
                user2:user1;
    }
    /**
     * Return true if and only if the user is in this room
     * @param user
     * @return
     */
    public boolean checkParticipant(Account user){
        return this.user1.getUsername().equals(user.getUsername()) ||
                this.user2.getUsername().equals(user.getUsername());
    }

    /**
     * Return an array of two participants
     * @return
     */
    public Account[] getParticipants(){
        Account[] participants = {this.user1, this.user2};
        return participants;
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
        return this.getOtherUser().getProfile().getName();
    }
}