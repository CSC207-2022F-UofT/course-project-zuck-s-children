package chat.control;

import java.util.ArrayList;
import java.util.List;

/**
 * An OutputModel that stores the list of chatrooms represented by opponents' names
 */
public class RoomOutModel {

    List<Object> listOfRooms;

    public RoomOutModel(List<Object> l){
        this.listOfRooms = new ArrayList<Object>();
        for(Object s : l){
            this.listOfRooms.add(s);
        }
    }

    public List<Object> getRoomList(){
        return this.listOfRooms;
    }
}
