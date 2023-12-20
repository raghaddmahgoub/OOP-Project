import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class Messenger {
    private List<Conversation> conversations;
    private List<Integer> noUnreadConversations ;

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
            System.out.println("Conversation ID: " + conversation.getConversationId());
        }
    }

    // delete conversation
    public void deleteConversation(int conversationId) {
        boolean removed = conversations.removeIf(conv -> conv.getConversationId() == conversationId);
        if (removed) {
            System.out.println("Conversation " + conversationId + " deleted successfully.");
        } else {
            System.out.println("Conversation " + conversationId + " not found.");
        }
    }

    // sort conversations based on timestamp
    public void sortConversations() {
        conversations.sort(Comparator.comparing(Conversation::getTimestamp).reversed());
    }

    // add message to conversation
    public void addMessageToConversation(int conversationId, int senderId, int recipientId, String content) {
        Conversation conversation = findConversation(conversationId);

            conversation.addMessage(senderId, recipientId, content);

    }

    // delete message from conversation
    public void deleteMessageFromConversation(int conversationId, int messageId) {
        Conversation conversation = findConversation(conversationId);
        if (conversation != null) {
            conversation.deleteMessage(messageId);
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
                count += conversation.getUnreadMessagesCount(userId);
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
    public List<Message> searchMessagesInConversation(int conversationId, String keyword) {
        Conversation conversation = findConversation(conversationId);
        if (conversation != null) {
            return conversation.searchMessages(keyword);
        } else {
            System.out.println("Conversation " + conversationId + " not found.");
            return new ArrayList<>();
        }
    }

    // Get conversation history
    public List<Message> getConversationHistory(int conversationId) {
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
            Message.EditMessage(messageId);
        } else {
            System.out.println("Conversation " + conversationId + " not found.");
        }
    }

    // react to a message in conversation
    public void reactToMessageInConversation(int conversationId, int messageId, String reaction) {
        Message mes = new Message();
        Conversation conversation = findConversation(conversationId);
        if (conversation != null) {
            mes.addReact(mes, reaction);
        } else{
            System.out.println("Conversation " + conversationId + " not found.");
        }
    }

    public Conversation findConversation(int conversationId) {
        for (Conversation conversation : conversations) {
            if (conversation.getConversationId() == conversationId) {
                return conversation; // Return the conversation if found
            }
        }
        return null; // Return null if no conversation is found for the given ID
    }


    // method to find a conversation BY USERNAME
    private Conversation findConvByUserName(String userName) {
        for (Conversation conversation : conversations) {

            List<String> participants = conversation.getParticipants();
            if (participants.contains(userName)) {
                return conversation;
            }
        }
        return null; //
    }

}
