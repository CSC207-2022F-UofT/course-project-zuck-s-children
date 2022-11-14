package chat.control;
import java.time.LocalDateTime;
public class MsgInModel {
    private String content;
    private Account sender;

    public MsgInModel(String s, Account sender){
        this.content = s;
        this.sender = sender;
    }

    public String getContent(){
        return this.content;
    }

    public Account getSender(){
        return this.sender;
    }
}
