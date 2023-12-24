import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.json.simple.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.*;
import org.json.simple.parser.ParseException;

public class Data {
    public static void writeData() {
        // Creating some sample data
        // Convert User ARRAY to JSON
        //=============user=================================
        JSONArray UserJson = new JSONArray();
        for (User user : Main.vec) {
            JSONObject userjson = new JSONObject();
            userjson.put("User ID", user.getUserID());
            userjson.put("username", user.getUserName());
            userjson.put("name", user.getName());
            userjson.put("email", user.getEmail());
            userjson.put("password", user.getPassword());
            userjson.put("birth date", user.getBirthdateString());
            userjson.put("phone number", user.getPhoneNumber());
            userjson.put("gender", user.getGender());
            UserJson.put(userjson);
        }
        // Writing JSON to a file
        try (FileWriter file = new FileWriter("user.json",false)) {
            file.write(UserJson.toString(4)); // Use toString(int) for indentation
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            System.out.println("JSON file not work.");

        }
        //==========posts===============================
        JSONArray postsArray = new JSONArray();
        for (User user:Main.vec) {
            for (Post post : user.getAllPosts()) {
                JSONObject postJson = new JSONObject();
                postJson.put("User ID", user.getUserID());
                postJson.put("Post ID", user.getAllPosts().indexOf(post));
                postJson.put("content", post.getContent());
                postJson.put("time stamp", post.getTimestamp());
                postJson.put("Number of reacts", post.getReacts());
                postJson.put("Number of comments", post.getNumberOfComments());
                JSONArray taggedusers = new JSONArray();
                for (User tagged: post.getTaggedUsers()) {
                    JSONObject taggedfile = new JSONObject();
                    taggedfile.put("Username",tagged.getUserName());
                    taggedusers.put(taggedfile);
                }
                postJson.put("tagged users",taggedusers);
                postsArray.put(postJson);
            }
        }
        // Writing JSON to a file
        try (FileWriter file = new FileWriter("Posts.json",false)) {
            file.write(postsArray.toString(4)); // Use toString(int) for indentation
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            System.out.println("JSON file not work.");

        }
        //===================comments========================
        JSONArray commentsArray = new JSONArray();
        for (User user:Main.vec) {
            for (Post post: user.getAllPosts()) {
                for (Comment comment : post.getAllComments()) {
                JSONObject commentJson = new JSONObject();
                commentJson.put("User ID", user.getUserID());
                    int postID= user.getAllPosts().indexOf(post);
                commentJson.put("Post ID",postID);
                commentJson.put("comment ID", user.getAllPosts().get(postID).getAllComments().indexOf(comment));
                commentJson.put("comment reacts", comment.getReacts());
                commentJson.put("comment content", comment.getContent());
                commentJson.put("commenter", comment.getAuthor().getUserName());
                commentsArray.put(commentJson);
                }
            }
        }
        // Writing JSON to a file
        try (FileWriter file = new FileWriter("comments.json",false)) {
            file.write(commentsArray.toString(4)); // Use toString(int) for indentation
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            System.out.println("JSON file not work.");

        }
        //======================replays======================
        JSONArray replaysArray = new JSONArray();
        for (User user:Main.vec) {
            for (Post post: user.getAllPosts()) {
                for (Comment comment : post.getAllComments()) {
                    for (Reply replay : comment.getUserReplies()) {
                    JSONObject replayjson = new JSONObject();
                    replayjson.put("User ID", user.getUserID());
                        int postID= user.getAllPosts().indexOf(post);
                    replayjson.put("Post ID", postID);
                        int commentID=user.getAllPosts().get(postID).getAllComments().indexOf(comment);
                    replayjson.put("Comment id", commentID);
                    replayjson.put("reply id",user.getAllPosts().get(postID).getAllComments().get(commentID).getUserReplies().indexOf(replay) );
                    replayjson.put("reply content", replay.getContent());
                    replayjson.put("replier", replay.getAuthor().getUserName());
                    replaysArray.put(replayjson);
                    }
                }
            }
        }
        // Writing JSON to a file
        try (FileWriter file = new FileWriter("replays.json",false)) {
            file.write(replaysArray.toString(4)); // Use toString(int) for indentation
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            System.out.println("JSON file not work.");

        }
       //===================================messenger=====================
        JSONArray conversationsArray = new JSONArray();
        for (User user:Main.vec) {
            if(user.getMessenger()!=null) {
                for (Conversation conversation : user.getMessenger().getConversations()) {
                    JSONObject conversationJson = new JSONObject();
                    conversationJson.put("User ID", user.getUserID());
                    conversationJson.put("Messanger ID", user.getMessenger().getMessengerid());
                    conversationJson.put("conversationID", conversation.getConversation_id());
                    conversationJson.put("conversation time", conversation.getTime());
                    conversationJson.put("conversation status", conversation.getStatus());
                    JSONArray partecipants = new JSONArray();
                    for (User partcipant : conversation.getParticipants()) {
                        JSONObject paticipant_id = new JSONObject();
                        paticipant_id.put("Username", partcipant.getUserName());
                    }
                    conversationJson.put("partcipent", partecipants);
                    conversationsArray.put(conversationJson);
                }
            }
        }
        try (FileWriter file = new FileWriter("messanger.json",false)) {
            file.write(conversationsArray.toString(4)); // Use toString(int) for indentation
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            System.out.println("JSON file not work.");

        }
        //============================
        JSONArray MessageArray = new JSONArray();
        for (User user:Main.vec) {
            if(user.getMessenger()!=null) {
                for (Conversation conversation : user.getMessenger().getConversations()) {
                    for (Messages Message : conversation.getMessages()) {
                        JSONObject messagejson = new JSONObject();
                        messagejson.put("user id", user.getUserID());
                        int messengerid=user.getMessenger().getMessengerid();
                        messagejson.put("messenger id", messengerid);
                        messagejson.put("Conversation id",user.getMessenger().getConversations().indexOf(conversation));
                        messagejson.put("message id", Message.getId());
                        messagejson.put("message content", Message.getContent());
                        messagejson.put("message sender_id", Message.getSender_ID());
                        messagejson.put("message status", Message.getStatus());
                        messagejson.put("message timestamp", Message.getTimestamp());
                        messagejson.put("message reacts", Message.getReacts());
                    }
                }
            }
        }
        try (FileWriter file = new FileWriter("messages.json",false)) {
            file.write(MessageArray.toString(4)); // Use toString(int) for indentation
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            System.out.println("JSON file not work.");
        }
        //=================================
        JSONArray replayArray = new JSONArray();
        for (User user:Main.vec) {
            if(user.getMessenger()!=null) {

            for (Conversation conversation : user.getMessenger().getConversations()) {
                for (Messages Message : conversation.getMessages()) {
                     for (Reply messagereply : Message.getMessageReplies()) {
                         JSONObject messageReplayjson = new JSONObject();
                         messageReplayjson.put("user id", user.getUserID());
                         int messengerid=user.getMessenger().getMessengerid();
                         messageReplayjson.put("Messenger", messengerid);
                         int conversationid=user.getMessenger().getConversations().indexOf(conversation);
                         messageReplayjson.put("conversation id", conversationid);
                         int messageID=user.getMessenger().getConversations().get(conversationid).getMessages().indexOf(Message);
                         messageReplayjson.put("Message id", messageID);
                         messageReplayjson.put("reacts", messagereply.getReacts());
                         messageReplayjson.put("replay id",user.getMessenger().getConversations().get(conversationid).getMessages().get(messageID).getMessageReplies().indexOf(messagereply) );
                         messageReplayjson.put("replay content", messagereply.getContent());
                         messageReplayjson.put("replayer", messagereply.getAuthor().getUserName());
                         replayArray.put(messagereply);
                     }
                }
            }
        }}
        try (FileWriter file = new FileWriter("messageReplay.json",false)) {
            file.write(replaysArray.toString(4)); // Use toString(int) for indentation
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            System.out.println("JSON file not work.");
        }
         //================================================

        JSONArray FriendshipArray = new JSONArray();
        if (Main.Friendships!=null){

            for (FriendShip friend : Main.Friendships) {
                JSONObject Friendjson = new JSONObject();
                Friendjson.put("User1", friend.getUser1().getUserName());
                Friendjson.put("User2", friend.getUser2().getUserName());
                Friendjson.put("role1", friend.getFriend1_Role());
                Friendjson.put("role2", friend.getFriend2_Role());
                Friendjson.put("status", friend.getFriendship_status());
                Friendjson.put("Timestamp", friend.getFriendsSince());
            }
        }
        try (FileWriter file = new FileWriter("friendship.json",false)) {
            file.write(FriendshipArray.toString(4));// Use toString(int) for indentation
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            System.out.println("JSON file not work.");
        }
    }

    public static void readData() {

        //===============users===================================
            try {
                // Read JSON file content as a String
                String jsonString = new String(Files.readAllBytes(Paths.get("user.json")));
                // Parse the JSON string into a JSONArray
                JSONArray jsonArray = new JSONArray(jsonString);
                // Iterate through the JSONArray
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    // Access object properties
                    int Id = jsonObject.getInt("User ID");
                    String username = jsonObject.getString("username");
                    String name = jsonObject.getString("name");
                    String email = jsonObject.getString("email");
                    String password = jsonObject.getString("password");
                    String birth_date = jsonObject.getString("birth date");
                    Date dateOfBirth=new SimpleDateFormat("yyyy-MM-dd").parse(birth_date);
                    Long phonenumber=jsonObject.getLong("phone number");
                    String gender = jsonObject.getString("gender");
                    User user=new User(username,password);
                    user.setName(name);
                    user.setPhoneNumber(phonenumber);
                    user.setEmail(email);
                    user.setBirthdate(dateOfBirth);
                    if(gender.equals("female")){
                        user.setGender(User.GenderOptions.FEMALE);
                    }else{
                        user.setGender(User.GenderOptions.MALE);
                    }
                    Main.vec.add(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        //======================================posts========================================
        try {
            // Read JSON file content as a String
            String jsonString = new String(Files.readAllBytes(Paths.get("Posts.json")));
            // Parse the JSON string into a JSONArray
            JSONArray jsonArray = new JSONArray(jsonString);
            // Iterate through the JSONArray
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // Access object properties
                Post post=new Post();
                User user=Main.vec.get( jsonObject.getInt("User ID"));
                post.setAuthor(user);
                post.setPostId( jsonObject.getInt("Post ID"));
                post.setContent(jsonObject.getString("content"));

                post.setCntReacts( jsonObject.getInt("Number of reacts"));
                post.setNumberOfComments( jsonObject.getInt("Number of comments"));
                for (Object obj:jsonObject.getJSONArray("tagged users")) {
                    String str = (String) obj;
                    post.addtaggedUsers(Feed.GetUserData(str));
                }
                user.addApost(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//==============================================comments===============
        try {
            // Read JSON file content as a String
            String jsonString = new String(Files.readAllBytes(Paths.get("comments.json")));
            // Parse the JSON string into a JSONArray
            JSONArray jsonArray = new JSONArray(jsonString);
            // Iterate through the JSONArray
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String content=jsonObject.getString("comment content");
                Comment comment=new Comment(content);
                User user=Main.vec.get( jsonObject.getInt("User ID"));
                comment.setAuthor(user);
                int post_id= jsonObject.getInt("Post ID");
                comment.setCommentId( jsonObject.getInt("comment ID"));
                String time = jsonObject.getString("time stamp");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date parsedDate = dateFormat.parse(time);
                comment.setTimestamp(new Timestamp(parsedDate.getTime()));
                comment.setCntReacts( jsonObject.getInt("comment reacts"));
                comment.setAuthor(Feed.GetUserData(jsonObject.getString("commenter")));
                user.getAllPosts().get(post_id).add_comment(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //================================================replays=================
        try {
            // Read JSON file content as a String
            String jsonString = new String(Files.readAllBytes(Paths.get("replays.json")));
            // Parse the JSON string into a JSONArray
            JSONArray jsonArray = new JSONArray(jsonString);
            // Iterate through the JSONArray
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String content=jsonObject.getString("reply content");
                Reply reply=new Reply(content);
                User user=Main.vec.get( jsonObject.getInt("User ID"));
                reply.setAuthor(user);
                int post_id= jsonObject.getInt("Post ID");
                int commentId= jsonObject.getInt("Comment id");
                reply.setReplyId( jsonObject.getInt("reply id"));
                reply.setAuthor(Feed.GetUserData(jsonObject.getString("replier")));
                user.getAllPosts().get(post_id).getAllComments().get(commentId).addReply(reply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//==================================messenger=============
        try {
            // Read JSON file content as a String
            String jsonString = new String(Files.readAllBytes(Paths.get("messanger.json")));
            // Parse the JSON string into a JSONArray
            JSONArray jsonArray = new JSONArray(jsonString);
            // Iterate through the JSONArray
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // Access object properties
                int user_Id = jsonObject.getInt("User ID");
                int Messangerid = jsonObject.getInt("Messanger ID");
                int conversationid = jsonObject.getInt("conversationID");
                String time = jsonObject.getString("conversation time");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date parsedDate = dateFormat.parse(time);
                String stat = jsonObject.getString("conversation status");
                ArrayList <User> part=new ArrayList<>();
                for (Object obj:jsonObject.getJSONArray("partcipent")) {
                    String str = (String) obj;
                    part.add(Feed.GetUserData(str));
                }
                Main.vec.get(user_Id).setMessenger(Main.vec.get(user_Id));
                Conversation con=new Conversation(part);
                con.setStatus(stat);
                con.setTimestamp(new Timestamp(parsedDate.getTime()));
                Main.vec.get(user_Id).getMessenger().addconversations(con);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //====================================messages===========
        try {
            // Read JSON file content as a String
            String jsonString = new String(Files.readAllBytes(Paths.get("messages.json")));
            // Parse the JSON string into a JSONArray
            JSONArray jsonArray = new JSONArray(jsonString);
            // Iterate through the JSONArray
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // Access object properties

                int user_Id = jsonObject.getInt("User ID");
                int Messangerid = jsonObject.getInt("messenger id");
                int conversationid = jsonObject.getInt("Conversation id");
                int messageId = jsonObject.getInt("message id");
                String content=jsonObject.getString("message content");
                int senderID = jsonObject.getInt("message sender_id");
                String stat = jsonObject.getString("message status");
                String time = jsonObject.getString("message timestamp");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date parsedDate = dateFormat.parse(time);
                int reacts = jsonObject.getInt("message reacts");
                Messages m=new Messages(senderID,content);
                m.setTimestamp(new Timestamp(parsedDate.getTime()));
                m.setStatus(stat);
                m.setCntReacts(reacts);
                Main.vec.get(user_Id).getMessenger().getConversations().get(conversationid).getMessages().add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //===============================================message reply
        try {
            // Read JSON file content as a String
            String jsonString = new String(Files.readAllBytes(Paths.get("messageReplay.json")));
            // Parse the JSON string into a JSONArray
            JSONArray jsonArray = new JSONArray(jsonString);
            // Iterate through the JSONArray
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // Access object properties
                int user_Id = jsonObject.getInt("user id");
                int Messangerid = jsonObject.getInt("Messenger");
                int conversationid = jsonObject.getInt("conversation id");
                int messageId = jsonObject.getInt("Message id");
                int replyId = jsonObject.getInt("replay id");
                int reacts = jsonObject.getInt("reacts");
                String content=jsonObject.getString("replay content");
                String username = jsonObject.getString("replayer");
                Reply r=new Reply(content);
                r.setCntReacts(reacts);
                r.setAuthor(Feed.GetUserData(username));
                Main.vec.get(user_Id).getMessenger().getConversations().get(conversationid).getMessages().get(messageId).addreplay(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //=====================================friendship=======
        try {
            // Read JSON file content as a String
            String jsonString = new String(Files.readAllBytes(Paths.get("friendship.json")));
            // Parse the JSON string into a JSONArray
            JSONArray jsonArray = new JSONArray(jsonString);
            // Iterate through the JSONArray
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // Access object properties
                String user1 = jsonObject.getString("User1");
                String user2 = jsonObject.getString("User2");
                int role1=jsonObject.getInt("role1");
                int role2=jsonObject.getInt("role2");
                String status = jsonObject.getString("status");
                String time = jsonObject.getString("conversation time");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date parsedDate = dateFormat.parse(time);
                FriendShip f=new FriendShip(Feed.GetUserData(user1),Feed.GetUserData(user2),role1,role2,status,new Timestamp(parsedDate.getTime()));
                Main.Friendships.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

