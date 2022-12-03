package data.persistency;

import java.io.*;
import java.util.List;

public interface ChatDataAccessInterface {
    void save(String filepath, ChatDatabase chatList) throws IOException;

    ChatDatabase getChatData();
    Object loadRoomById(String rid) throws Throwable;
    List<Object> loadRoomByAccount();
}
