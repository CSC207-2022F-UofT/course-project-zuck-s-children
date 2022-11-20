package chat.control;

/**
 * An InputModel that stores the id of a chatroom the user leaves
 */
public class RoomInModel {
    String id;

    /**
     * Construct the model using the chatroom id
     * @param id
     */
    public RoomInModel(String id){
        this.id = id;
    }

    /**
     * Return the id of a chatroom the user leaves
     * @return the chatroom id stored in this model
     */
    public String getId(){
        return this.id;
    }
}
