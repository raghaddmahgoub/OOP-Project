import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.Iterator;
public class Conversation {
    Scanner in = new Scanner(System.in);
    //Attributes
    private static int conversation_id=0;
    private int convID;

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessages(ArrayList<Messages> messages) {
        Messages = messages;
    }

    public Timestamp timestamp;

    private ArrayList<Messages> Messages = new ArrayList<>();
    private ArrayList<User> Participants = new ArrayList<>();
    ArrayList <Integer> noUnreadMessages=new ArrayList<>();
    private String Status;
    public int last = Messages.lastIndexOf(Messages)+1;

    //Constructor
    public Conversation(){
        conversation_id++;
    }

    public Conversation(ArrayList<User>participants) {
        conversation_id++;
        convID=conversation_id;
        timestamp = Timestamp.valueOf(getTime());
        this.Messages = new ArrayList<>();
        this.Participants = participants;
        Status = GroupOrPrivateChat();
        noUnreadMessages=null;
    }

    //Methods
    public void Add_Message(int senderID,String content) {
        Messages.add(new Messages(senderID,content));
        // noUnreadMessages.remove(Integer.valueOf(mes.getId()));
    }
    public void Sort_Messages() {
        Messages.sort(new sorting().reversed());
    }
    public void DeleteMessage(Conversation con) {
        displayMessages(con);
        System.out.println("Enter Message ID:");
        int ID=in.nextInt();
        for (Messages mes:con.getMessages()) {
            if(mes.getMesID()==ID){
                {
                    con.getMessages().remove(mes);
                    //mes.setContent(null);
                    System.out.println("Message Deleted Successfully");
                    break;
                }
            }
        }
    }

    public String GroupOrPrivateChat() {
        if (this.Participants.size() > 2) {
            return "Group Chat";
        }
        return "Private Chat";
    }
   /* public void markAsRead() {
        noUnreadMessages.clear();
    }*/

    public boolean isRead() {
        return noUnreadMessages.isEmpty();
    }

    public boolean isParticipant(int userId) {
        return Participants.contains(String.valueOf(userId));
    }

    private void ViewParticipants() {
        System.out.println(getParticipants());
    }
    // method to search within the conv
    public boolean containsKeyword(String keyword) {
        for (Messages message : getMessages()) {
            if (message.getContent().contains(keyword)) {
                return true;
            }
        }
        return false;
    }
    public void displayMessages(Conversation conv){
        for (Messages mes: conv.getMessages()) {
            System.out.println(mes.getMesID());
            System.out.println(mes.content);
        }
    }

    public ArrayList<Messages> searchMessages(Conversation conv,String keyword) {
        ArrayList<Messages> matchingMessages = new ArrayList<>();
        for (Messages message : conv.getMessages()) {
            if (message.getContent().contains(keyword)) {
                matchingMessages.add(message);
            }
        }
        return matchingMessages;
    }

    public LocalDateTime getTime(){
        LocalTime systemTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        LocalDateTime timestamp = LocalDateTime.of(currentDate, systemTime);
        return timestamp;
    }
    //getters & setters
    public int getConversation_id() {
        return convID;
    }
    public ArrayList<Messages> getMessages() {
        return Messages;
    }
    public void setMessages(Messages messages) {
        Messages.add(messages);
    }
    public ArrayList<User> getParticipants() {
        return Participants;
    }
    public void setParticipants(User participants) {
        Participants.add(participants);
    }

    public ArrayList<Integer> getNoUnreadMessages() {
        return noUnreadMessages;
    }

    public void setNoUnreadMessages(int noUnreadMessages) {
        this.noUnreadMessages.add(noUnreadMessages);
    }

    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }

}

class sorting implements Comparator<Messages> {
    public int compare(Messages mes1, Messages mes2) {
        return mes1.Timestamp.compareTo(mes2.Timestamp);
    }
}