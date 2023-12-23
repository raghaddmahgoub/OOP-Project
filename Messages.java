import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Messages extends Text{
    private static int MesID=0;
    private  int M_ID;
    private ArrayList<Reply> MessageReplies = new ArrayList<>();
    private int Sender_ID;
    private String Status;
    public LocalDateTime Timestamp;
    Scanner in = new Scanner(System.in);

    public Messages() {
        MesID++;
    }

    public Messages( int sender_ID, String content) {
        MesID++;
        M_ID=MesID;
        // this.Id=con.last;
        MessageReplies=new ArrayList<>();
        cntReacts=0;
        Status = "Unread";
        Timestamp = getTime();
        Sender_ID = sender_ID;
        this.content = content;
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

    public void addReact() {
        cntReacts++;
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
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }

    public int getMesID() {
        return M_ID;
    }
}