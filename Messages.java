import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Messages {
    private static int Message_ID;
    private ArrayList<String> MessageReplies = new ArrayList<>();
    private int reactionCounter;
    private int Sender_ID;
    private int Recipient_ID;
    private String Status;
    private Date Message_Time;
    private String Content;
    Scanner in=new Scanner(System.in);
    public Messages (){}
    public Messages(ArrayList<String> messageReplies, int reactionCounter, int sender_ID, int recipient_ID, String status, Date message_Time, String content) {
        Message_ID++;
        MessageReplies = messageReplies;
        this.reactionCounter = reactionCounter;
        Sender_ID = sender_ID;
        Recipient_ID = recipient_ID;
        Status = status;
        Message_Time = message_Time;
        Content = content;
    }
    private String EditMessage(Messages mes) {
        String NewContent=in.next();
        mes.Content = NewContent;
        return NewContent;
    }
    private void DeleteMessage(Messages mes) {
        mes.Content = null;
    }
    private void AddReply(Messages mes) {
        String Reply=in.next();
        mes.MessageReplies.add(Reply);
    }
    private void Status(Messages mes, String value) {
        mes.Status = value;
    }
    private void AddReaction(Messages mes) {
        mes.reactionCounter++;
    }
    public int getMessage_ID() {
        return Message_ID;
    }
    public void setMessage_ID(int message_ID) {
        Message_ID = message_ID;
    }
    public Date getMessage_Time() {
        return Message_Time;
    }
    public void setMessage_Time(Date message_Time) {
        Message_Time = message_Time;
    }
    public void setContent(String content) {
        Content = content;
    }
}
