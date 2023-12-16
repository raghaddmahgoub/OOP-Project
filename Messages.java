import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Messages {
    private static int Message_ID;
    private ArrayList<Reply> MessageReplies = new ArrayList<>();
    private int ReactionCounter;
    private int Sender_ID;       //pair??
    private int Recipient_ID;
    private String Status;
    public LocalDateTime Timestamp;
    private String Content;
    Scanner in = new Scanner(System.in);

    public Messages() {
    }

    public Messages( int sender_ID, int recipient_ID, String content) {
        Message_ID++;
        MessageReplies=new ArrayList<>();
        ReactionCounter =0;
        Status = "Unread";
        Timestamp = getTime();
        Sender_ID = sender_ID;
        Recipient_ID = recipient_ID;
        Content = content;
    }
    //Methods
    public void EditMessage(Messages mes) {
        String NewContent = in.next();
        mes.setContent(NewContent);
    }
    public void AddReply(int sender_ID) {
        String Reply = in.next();
        MessageReplies.add(new Reply(sender_ID,Reply));
    }

    public void Status(Messages mes,String value) {
        mes.setStatus(value);
    }
    public void addReact(Messages mes) {
        int i=mes.getReactionCounter();
        mes.setReactionCounter(++i);
    }
    public LocalDateTime getTime(){
        LocalTime systemTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        LocalDateTime timestamp = LocalDateTime.of(currentDate, systemTime);
        return timestamp;
    }
    //getters & setters
    public static int getMessage_ID() {
        return Message_ID;
    }
    public static void setMessage_ID(int message_ID) {
        Message_ID = message_ID;
    }
    public ArrayList<Reply> getMessageReplies() {
        return MessageReplies;
    }
    public void setMessageReplies(ArrayList<Reply> messageReplies) {
        MessageReplies = messageReplies;
    }
    public int getReactionCounter() {
        return ReactionCounter;
    }
    public void setReactionCounter(int reactionCounter) {
        ReactionCounter = reactionCounter;
    }
    public int getSender_ID() {
        return Sender_ID;
    }
    public void setSender_ID(int sender_ID) {
        Sender_ID = sender_ID;
    }
    public int getRecipient_ID() {
        return Recipient_ID;
    }
    public void setRecipient_ID(int recipient_ID) {
        Recipient_ID = recipient_ID;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }
}
