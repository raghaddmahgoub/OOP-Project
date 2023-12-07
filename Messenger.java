import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
public class Messenger {
    private List<Conversation> conversations;
    private Vector<Integer> noUnreadConversations = new Vector<>();
    public Messenger() {
        this.conversations = new ArrayList<>();
    }
// methods
    public int newConversation() {
        int newConvId = conversations.size() + 1;
        Conversation conversation = new Conversation(newConvId, System.currentTimeMillis());
        conversations.add(conversation);
        return newConvId;
    }



    public void displayConversations() {
        System.out.println("Conversations:");
        for (Conversation conversation : conversations) {
            System.out.println("Conversation ID: " + conversation.getId());
        }
    }

    public void deleteConversation(int conversationId) {
        boolean removed = conversations.removeIf(conv -> conv.getId() == conversationId);
        if (removed) {
            System.out.println("Conversation " + conversationId + " deleted successfully.");
        } else {
            System.out.println("Conversation " + conversationId + " not found.");
        }
    }

    public void sortConversations() {
        // Sorting conversations based on timestamp from newest to oldest
        conversations.sort(Comparator.comparingLong(Conversation::getTimestamp).reversed());
    }

}
