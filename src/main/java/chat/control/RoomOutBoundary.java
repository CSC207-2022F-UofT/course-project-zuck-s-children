package chat.control;

/**
 * An OutputBoundary for leaving a chatroom
 */
public interface RoomOutBoundary {
    void update(RoomOutModel responseModel);
}
