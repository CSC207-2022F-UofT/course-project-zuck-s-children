package chat.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageEnt implements {
    /**
     * A content of the message
     */
    private String content;

    /**
     * A date and time when the message is sent
     */
    private LocalDateTime messageDateTime;

    /**
     * An Account of the user who sent the message
     */
    private Account sender;

    /**
     * Creates an instance of MessageEnt
     * @param content
     * @param sender
     */
    public MessageEnt(String content, Account sender){
        this.content = content;
        this.sender = sender;
        messageDateTime = LocalDateTime.now();
    }

    public LocalDateTime getSentTime(){
        return messageDateTime;
    }

    public Account getSender(){
        return sender;
    }

    public String getContent(){
        return content;
    }
}
