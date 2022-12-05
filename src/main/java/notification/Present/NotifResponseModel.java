package notification.Present;

import java.util.ArrayList;
import java.util.List;

public class NotifResponseModel {
    private ArrayList<List> responseList;

    /**
     * Create a response model storing the all notifications.
     * @param formattedList list of all notifications in correct format.
     */
    public NotifResponseModel(ArrayList<List> formattedList){
        this.responseList = formattedList;
    }
    public ArrayList<List> getResponseModel(){
        return this.responseList;
    }
}
