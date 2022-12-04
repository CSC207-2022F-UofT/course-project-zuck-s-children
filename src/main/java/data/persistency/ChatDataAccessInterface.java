package data.persistency;

import java.io.*;
import java.util.List;

public interface ChatDataAccessInterface {

    ChatDatabase getChatData();
    Object loadRoomById(String rid) throws Throwable;
    List<Object> loadRoomByAccount();
}
