import java.time.LocalDateTime;
import java.util.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Messenger {
    Scanner in=new Scanner(System.in);
    private List<Conversation> conversations;
    private List<Integer> noUnreadConversations;
    User user;
    public Messenger(User user) {
        this.user=user;
        this.conversations = new ArrayList<>();
    }

    public void MessengerFeed() {
        System.out.println("Welcome to Messenger");
        System.out.println("1-Create new conversation");
        System.out.println("2- Find conversation");
        System.out.println("3- Search in conversations by keyword");
        System.out.println("4- Delete Conversation");
        System.out.println("Choice:");
        int choice=in.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter number of participants:");
                int no=in.nextInt();
                String username;
                ArrayList<User>participants=new ArrayList<>();
                participants.add(user);
                for(int i=1;i<no-1;i++)
                {
                    System.out.println("Enter Participant "+i);
                    username=in.next();
                    for (User friend:user.getFriends()) {
                        if(friend.getUserName().equals(username))
                            participants.add(friend);
                    }
                }
                Conversation conversation=new Conversation(participants);
                user.getMessenger().NewConversation(conversation);
                conversation.displayMessages(conversation);
                Options(conversation);
                break;
            case 2:
                System.out.println("Enter ID:");
                int ID=in.nextInt();
                Conversation conv=user.getMessenger().findConversation(ID);
                conv.displayMessages(conv);
                Options(conv);break;
            case 3:
                break;
            case 4:
                System.out.println("Enter conversation ID:");
                int convID=in.nextInt();
                user.getMessenger().deleteConversation(convID);
                break;
            default:
                System.out.println("Invalid Choice");
                MessengerFeed();
        }

    }
    public void Options(Conversation conversation){
        System.out.println("1- Add a message");
        System.out.println("2- Delete a message");
        System.out.println("3- Edit a message");
        System.out.println("4- Search in conversation");
        int Choice;
        System.out.println("Enter Value:");
        Choice=in.nextInt();
        switch (Choice){
            case 1:
                System.out.println("Enter Content:");
                String content=in.next();
                conversation.Add_Message(user.getUserID(),content);
                break;
            case 2:
                conversation.DeleteMessage(conversation.getConversation_id());break;
            case 3:
                System.out.println("Enter MessageID:");
                int id=in.nextInt();
                System.out.println("Enter new content:");
                String NewContent=in.next();
                for (Messages mes:conversation.getMessages()) {
                    if(mes.getId()==(id))
                    {
                        mes.EditMessage(NewContent);
                    }
                }
                break;
            case 4:
                System.out.println("Enter Keyword:");
                String keyword=in.next();
                user.getMessenger().searchMessagesInConversation(conversation.getConversation_id(),keyword);
                break;
            default:
                System.out.println("Invalid Choice");
                Options(conversation);
        }
    }
    ////////methods

    //  new conversation
    public int newConversation(ArrayList<User> participants) {
        int newConvId = conversations.size() + 1;
        Conversation conversation = new Conversation(participants);
        conversations.add(conversation);
        return newConvId;
    }
    public int NewConversation(Conversation conv) {
        int newConvId = conversations.size() + 1;
        conversations.add(conv);
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
        conversations.sort(Comparator.comparing(Conversation::getTime).reversed());
    }

    // add message to conversation
  /* public void addMessageToConversation(int conversationId, int senderId, int recipientId, String content) {
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
    }*/

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

            List<User> participants = conversation.getParticipants();
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