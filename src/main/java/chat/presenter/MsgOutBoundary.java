package chat.presenter;


public interface MsgOutBoundary {
    void open(MsgOutModel responseModel, String roomId);

    void overwrite(MsgOutModel responseModel);
}
