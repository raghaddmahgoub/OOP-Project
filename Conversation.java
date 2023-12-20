import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Conversation {
    Scanner in = new Scanner(System.in);
               //Attributes
    private int conversation_id;
    public Timestamp timestamp;
    private ArrayList<Messages> Messages = new ArrayList<>();
    private ArrayList<String> Participants = new ArrayList<>();
    ArrayList <Integer> noUnreadMessages=new ArrayList<>();

    private String Status;

    //Constructor
    public Conversation(ArrayList<String> participants) {
        conversation_id++;
        timestamp = Timestamp.valueOf(getTime());
        this.Messages = new ArrayList<>();
        this.Participants = participants;
        Status = GroupOrPrivateChat();
        NoUnreadMessages=null;
    }

                 //Methods
    public void Add_Message(int senderID, int recipientID) {
        String content = in.next();
        Messages.add(new Messages(senderID, recipientID, content));
        noUnreadMessages.remove(Integer.valueOf(messageId));
    }
    public void Sort_Messages() {
        Messages.sort(new sorting());
    }
    public void DeleteMessage(Messages mes) {
        Messages.remove(mes);
    }
    public String GroupOrPrivateChat() {
        if (this.Participants.size() > 2) {
            return "Group Chat";
        }
        return "Private Chat";
    }
    public void markAsRead() {
        noUnreadMessages.clear();
    }

    public boolean isRead() {
        return noUnreadMessages.isEmpty();
    }

    public boolean isParticipant(int userId) {
        return participants.contains(String.valueOf(userId));
    }

    private void ViewParticipants() {
        System.out.println(getParticipants());
    }
    // method to search within the conv
    public boolean containsKeyword(String keyword) {
        for (Message message : messages) {
            if (message.getContent().contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    public List<Message> searchMessages(String keyword) {
        List<Message> matchingMessages = new ArrayList<>();
        for (Message message : messages) {
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
        return conversation_id;
    }
    public void setConversation_id(int conversation_id) {
        this.conversation_id = conversation_id;
    }
    public ArrayList<Messages> getMessages() {
        return Messages;
    }
    public void setMessages(ArrayList<Messages> messages) {
        Messages = messages;
    }
    public ArrayList<String> getParticipants() {
        return Participants;
    }
    public void setParticipants(ArrayList<String> participants) {
        Participants = participants;
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
