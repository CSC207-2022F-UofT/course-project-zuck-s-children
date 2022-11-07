package chat.control;
import java.time.LocalDateTime;
public class MsgInModel {
    String content;
    LocalDateTime sentTime;
    Account sender;

    public MsgInModel(String s, Account sender){
        this.content = s;
        this.sender = sender;
        this.sentTime = LocalDateTime.now();
    }

}
