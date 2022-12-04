package chat.presenter;


public interface MsgOutBoundary {
    void update(MsgOutModel responseModel, String roomId);
}
