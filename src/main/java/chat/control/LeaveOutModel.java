package chat.control;

import java.util.List;

/**
 * An OutputModel that stores the list of chatrooms represented by opponents' names
 */
public class LeaveOutModel {

    List<String> listOfRooms;

    public LeaveOutModel(List<String> l, String left){

    }

    public List<String> getRoomList(){
        return this.listOfRooms;
    }
}
