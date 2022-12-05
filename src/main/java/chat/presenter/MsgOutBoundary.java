package chat.presenter;


public interface MsgOutBoundary {
    void update(MsgOutModel responseModel, String roomId);

    void overwrite(MsgOutModel responseModel, String roomId);
}
