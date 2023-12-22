import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Vector;

public class Messenger {
    private List<Conversation> conversations;
    private List<Integer> noUnreadConversations;

    public Messenger() {
        this.conversations = new ArrayList<>();
    }


    ////////methods

    //  new conversation
    public int newConversation(ArrayList<String> participants) {
        int newConvId = conversations.size() + 1;
        Conversation conversation = new Conversation(participants);
        conversations.add(conversation);
        return newConvId;
    }

    // display all conversations
    public void displayConversations() {
        System.out.println("Conversations:");
        for (Conversation conversation : conversations) {
            System.out.println("Conversation ID: " + conversation.getConversation_id());
        }
    }

    // delete conversation

//// methods
    /*
    public int newConversation() {
      int newConvId = conversations.size() + 1;
        Conversation conversation = new Conversation(newConvId, System.currentTimeMillis());
       conversations.add(conversation);
        return newConvId;
    }
*/


    public void deleteConversation(int conversationId) {
        boolean removed = conversations.removeIf(conv -> conv.getConversation_id() == conversationId);
        if (removed) {
            System.out.println("Conversation " + conversationId + " deleted successfully.");
        } else {

            System.out.println("Conversation " + conversationId + " not found.");
        }
    }

    // sort conversations based on timestamp
    public void sortConversations() {
        // conversations.sort(Comparator.comparing(Conversation::getTimestamp).reversed());
    }

    // add message to conversation
    public void addMessageToConversation(int conversationId, int senderId, int recipientId, String content) {
        Conversation conversation = findConversation(conversationId);

        conversation.Add_Message(senderId, recipientId, content);

    }

    // delete message from conversation
    public void deleteMessageFromConversation(int conversationId, int messageId) {
        Conversation conversation = findConversation(conversationId);
        if (conversation != null) {
            conversation.DeleteMessage(messageId);
        } else {
            System.out.println("Conversation " + conversationId + " not found.");
        }
    }

    // mark conversation as read
    public void markConversationAsRead(int conversationId) {
        Conversation conversation = findConversation(conversationId);
        if (conversation != null) {
            conversation.markAsRead();
        } else {
            System.out.println("Conversation " + conversationId + " not found.");
        }
    }

    // get unread messages count for a user
    public int getUnreadMessagesCount(int userId) {
        int count = 0;
        for (Conversation conversation : conversations) {
            if (conversation.isParticipant(userId) && !conversation.isRead()) {
                count = count + conversation.getNoUnreadMessages().size();
            }
        }
        return count;
    }

    // search in conversations by keyword
    public List<Conversation> searchConversations(String keyword) {
        List<Conversation> matchingConversations = new ArrayList<>();
        for (Conversation conversation : conversations) {
            if (conversation.containsKeyword(keyword)) {
                matchingConversations.add(conversation);
            }
        }
        return matchingConversations;
    }

    // search messages in conversation by keyword
    public List<Messages> searchMessagesInConversation(int conversationId, String keyword) {
        Conversation conversation = findConversation(conversationId);
        if (conversation != null) {
            return conversation.searchMessages(keyword);
        } else {
            System.out.println("Conversation " + conversationId + " not found.");
            return new ArrayList<>();
        }
    }

    // Get conversation history
    public List<Messages> getConversationHistory(int conversationId) {
        Conversation conversation = findConversation(conversationId);
        if (conversation != null) {
            return conversation.getMessages();
        } else {
            System.out.println("Conversation " + conversationId + " not found.");
            return new ArrayList<>();
        }
    }

    // edit a message in a conversation
    public void editMessageInConversation(int conversationId, int messageId, String newContent) {
        Conversation conversation = findConversation(conversationId);
        if (conversation != null) {
            for (Messages mes : conversation.getMessages()) {
                if (mes.getId() == messageId) {
                    mes.EditMessage(newContent);
                }
            }
        } else {
            System.out.println("Conversation " + conversationId + " not found.");
        }
    }

    // react to a message in conversation
    public void reactToMessageInConversation(int conversationId, int messageId, String reaction) {
        Messages mes = new Messages();
        Conversation conversation = findConversation(conversationId);
        if (conversation != null) {
            mes.addReact();
        } else {
            System.out.println("Conversation " + conversationId + " not found.");
        }
    }

    public Conversation findConversation(int conversationId) {
        for (Conversation conversation : conversations) {
            if (conversation.getConversation_id() == conversationId) {
                return conversation;
            }
        }
        return null;
    }


    // method to find a conversation BY USERNAME
    private Conversation findConvByUserName(String userName) {
        for (Conversation conversation : conversations) {

            List<String> participants = conversation.getParticipants();
            if (participants.contains(userName)) {
                return conversation;
            }
        }
        return null;
/*
                public void sortConversations () {
                        //Sorting conversations based on timestamp from newest to oldest
                    // conversations.sort(Comparator.comparingLong(Conversation::getTimestamp().reversed());

                }*/
    }
}