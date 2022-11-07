package data.persistency;
import chat.entities.ChatRoomEnt;

import java.util.ArrayList;

public interface ChatDataAccessInterface {
    void save();
    ChatRoomEnt load();
}
