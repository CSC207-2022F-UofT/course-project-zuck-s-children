package chat.control;

import java.util.ArrayList;
import java.util.List;

/**
 * An OutputModel that stores the list of chatrooms represented by opponents' names
 */
public class RoomOutModel {

    List<String> listOfRooms;

    public RoomOutModel(List<Object> l){
        this.listOfRooms = new ArrayList<String>();
        for(Object s : l){
            this.listOfRooms.add((String)s);
        }
    }

    public List<String> getRoomList(){
        return this.listOfRooms;
    }
}
