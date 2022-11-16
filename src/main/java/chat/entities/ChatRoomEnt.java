package chat.entities;

import java.util.ArrayList;
import java.util.UUID;

public class ChatRoomEnt {
    /**
     * The id of the chat room.
     */
    private String id;
    private Participants participants;

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
}

/**
 * Participants class which has two accounts of users
 */
public class Participants{
    private Account User1;
    private Account User2;

    /**
     * Return the another user with the different name
     * @param myName
     * @throws IllegalArgumentException if myName is not the name of neither of the participants
     * @return the name of the another user
     */
    public String getOtherUser(String myName) throws IllegalArgumentException{
        if(myName != User1.name && myName != User2.name){
            throw new IllegalArgumentException();
        }
        return myName == User1.name? User2 : User1;
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
}