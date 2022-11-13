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


    public ChatRoomEnt(Account User1, Account User2){
        this.id = UUID.randomUUID().toString();
        this.participants = new Participants(User1, User2);
        this.messageList = new ArrayList<>();
    }

    public String getId(){
        return this.id;
    }
    public Participants getParticipants(){
        return this.participants;
    }
}

public class Participants{
    private Account User1;
    private Account User2;

    public String getOtherUser(String myName){
        return myName == User1.name? User2 : User1;
    }
    public Participants(Account User1, Account User2){
        this.User1 = User1;
        this.User2 = User2;
    }
}