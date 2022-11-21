package data.persistency;

import java.io.*;
import java.util.List;

public interface ChatDataAccessInterface {
    void save(String filepath, ChatData chatList) throws IOException;

    ChatData getChatData();
    Object loadRoomById(String rid) throws Throwable;
    List<Object> loadRoomByAccount(Object acc);
}
