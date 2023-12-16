import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Messages {
    private static int Message_ID;
    private ArrayList<String> MessageReplies = new ArrayList<>();
    private int reactionCounter;
    private int Sender_ID;
    private int Recipient_ID;
    private String Status;
    public LocalDateTime Message_Time;
    private String Content;
    Scanner in=new Scanner(System.in);
    public Messages (){}
    public Messages(ArrayList<String> messageReplies, int reactionCounter, int sender_ID, int recipient_ID, String status, LocalDateTime message_Time, String content) {
        Message_ID++;
        MessageReplies = messageReplies;
        this.reactionCounter = reactionCounter;
        Sender_ID = sender_ID;
        Recipient_ID = recipient_ID;
        Status = status;
        Message_Time = message_Time;
        Content = content;
    }
    public String EditMessage(Messages mes) {
        String NewContent=in.next();
        mes.Content = NewContent;
        return NewContent;
    }
    public void DeleteMessage(Messages mes) {
        mes.Content = null;
    }
    public void AddReply(Messages mes) {
        String Reply=in.next();
        mes.MessageReplies.add(Reply);
    }
    public void Status(Messages mes, String value) {
        mes.Status = value;
    }
    public void AddReaction(Messages mes) {
        mes.reactionCounter++;
    }
    public int getMessage_ID() {
        return Message_ID;
    }
    public void setMessage_ID(int message_ID) {
        Message_ID = message_ID;
    }
    public LocalDateTime getMessage_Time() {
        return Message_Time;
    }
    public void setMessage_Time(LocalDateTime message_Time) {
        Message_Time = message_Time;
    }
    public void setContent(String content) {
        Content = content;
    }
}
