package Notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotifResponseModel {
    final List<String> content = new ArrayList<String>();
    final List<String> sender = new ArrayList<String>();
    final List<Date> time = new ArrayList<Date>();


    public NotifResponseModel(List<List> notifList){
        for (List lst: notifList){
            this.content.add((String) lst.get(0));
            this.sender.add((String) lst.get(1));
            this.time.add((Date) lst.get(2));
        }
    }
}
