package chat.presenter;

import java.util.ArrayList;
import java.util.List;

/**
 * An OutputModel that stores the list of chatrooms represented by opponents' names
 */
public class RoomOutModel {

    List<Object> listOfRooms;

    /**
     * Construct an output model for a list of rooms
     * @param l
     */
    public RoomOutModel(List<Object> l){
        this.listOfRooms = new ArrayList<Object>();
        for(Object s : l){
            this.listOfRooms.add(s);
        }
    }

    /**
     * Return the list of rooms represented by this model
     * @return
     */
    public List<Object> getRoomList(){
        return this.listOfRooms;
    }
}