package data.persistency;
import chat.ChatRoomEnt;

public interface ChatDataAccessInterface {
    void save();
    ChatRoomEnt load();
}
