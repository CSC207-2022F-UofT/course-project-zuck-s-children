package data_persistency;

import chat.entities.ChatRoomEnt;

import java.io.*;
import java.util.List;

public interface ChatDataAccessInterface {

    ChatDatabase getChatData();
    Object loadRoomById(String rid);
    List<Object> loadRoomByAccount();
    void addChatRoom(ChatRoomEnt room);

}
