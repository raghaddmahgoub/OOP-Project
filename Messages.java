import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Messages extends Text{
    private ArrayList<Reply> MessageReplies = new ArrayList<>();
    private int Sender_ID;       //pair??
    private int Recipient_ID;
    private String Status;
    public LocalDateTime Timestamp;
    Scanner in = new Scanner(System.in);

    public Messages() {
    }

    public Messages( int sender_ID, int recipient_ID, String content) {
        Id++;
        MessageReplies=new ArrayList<>();
        cntReacts=0;
        Status = "Unread";
        Timestamp = getTime();
        Sender_ID = sender_ID;
        Recipient_ID = recipient_ID;
        content = content;
    }
    //Methods
    public void EditMessage(String content) {
        setContent(content);
        System.out.println("Edited Successfully");
    }
    public void AddReply() {
        String Reply = in.next();
        MessageReplies.add(new Reply(Reply));
    }

    public void Status(String value) {
        setStatus(value);
    }
    public void addReact() {
        int i=getCntReacts();
        setCntReacts(++i);
    }

    @Override
    public int getReacts() {
        return cntReacts;
    }

    public LocalDateTime getTime(){
        LocalTime systemTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        LocalDateTime timestamp = LocalDateTime.of(currentDate, systemTime);
        return timestamp;
    }
    //getters & setters
    public ArrayList<Reply> getMessageReplies() {
        return MessageReplies;
    }
    public void setMessageReplies(Reply messageReply) {
        MessageReplies.add(messageReply);
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
}
