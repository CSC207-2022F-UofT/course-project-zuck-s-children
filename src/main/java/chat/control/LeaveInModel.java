package chat.control;

import chat.entities.ChatRoomEnt;

public class LeaveInModel {
    String id;

    public LeaveInModel(String s){
        this.id = s;
    }
    public String getId(){
        return this.id;
    }
}
