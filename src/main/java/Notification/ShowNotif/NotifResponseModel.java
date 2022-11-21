package Notification.ShowNotif;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotifResponseModel {
    private ArrayList<List> responseList;


    public NotifResponseModel(ArrayList<List> formattedList){
        this.responseList = formattedList;
    }
    public ArrayList<List> getResponseModel(){
        return this.responseList;
    }
}
