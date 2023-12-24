import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
                postJson.put("Post ID", post.getId());
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
                commentJson.put("Post ID", post.getId());
                commentJson.put("comment ID", comment.getId());
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
                    replayjson.put("Post ID", post.getId());
                    replayjson.put("Comment id", comment.getId());
                    replayjson.put("reply id", replay.getId());
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
            for (Conversation conversation : user.getMessenger().getConversations()) {
                JSONObject conversationJson = new JSONObject();
                conversationJson.put("User ID",user.getUserID());
                conversationJson.put("Messanger ID",user.getMessenger().getMessengerid());
                conversationJson.put("conversationID", conversation.getConversation_id());
                conversationJson.put("conversation time", conversation.getTime());
                conversationJson.put("conversation status", conversation.getStatus());
                JSONArray partecipants = new JSONArray();
                for (User partcipant:conversation.getParticipants()) {
                    JSONObject paticipant_id = new JSONObject();
                    paticipant_id.put("Username",partcipant.getUserName());
                }
                conversationJson.put("partcipent",partecipants);
                conversationsArray.put(conversationJson);
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
            for (Conversation conversation : user.getMessenger().getConversations()) {
                for (Messages Message : conversation.getMessages()) {
                    JSONObject messagejson = new JSONObject();
                    messagejson.put("user id", user.getUserID());
                    messagejson.put("messenger id", user.getMessenger().getMessengerid());
                    messagejson.put("Conversation id", conversation.getConversation_id());
                    messagejson.put("message id", Message.getId());
                    messagejson.put("message content", Message.getContent());
                    messagejson.put("message sender_id", Message.getSender_ID());
                    messagejson.put("message status", Message.getStatus());
                    messagejson.put("message timestamp", Message.getTimestamp());
                    messagejson.put("message reacts", Message.getReacts());
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
            for (Conversation conversation : user.getMessenger().getConversations()) {
                for (Messages Message : conversation.getMessages()) {
                     for (Reply messagereply : Message.getMessageReplies()) {
                         JSONObject messageReplayjson = new JSONObject();
                         messageReplayjson.put("user id", user.getUserID());
                         messageReplayjson.put("Messenger", user.getMessenger().getMessengerid());
                         messageReplayjson.put("conversation id", conversation.getConversation_id());
                         messageReplayjson.put("replay id", messagereply.getId());
                         messageReplayjson.put("replay content", messagereply.getContent());
                         messageReplayjson.put("replayer", messagereply.getAuthor().getUserName());
                         replayArray.put(messagereply);
                     }
                }
            }
        }
        try (FileWriter file = new FileWriter("messageReplay.json",false)) {
            file.write(replaysArray.toString(4)); // Use toString(int) for indentation
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            System.out.println("JSON file not work.");
        }
         //================================================

        JSONArray FriendshipArray = new JSONArray();
        for (FriendShip friend : Main.Friendships) {
            JSONObject Friendjson = new JSONObject();
            Friendjson.put("User1", friend.getUser1().getUserName());
            Friendjson.put("User2", friend.getUser2().getUserName());
            Friendjson.put("roles", friend.getFriends_Roles());
            Friendjson.put("status", friend.getFriendship_status());
            Friendjson.put("Timestamp", friend.getFriendsSince());
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
       /* try {
            // Read JSON file content as a String
            String jsonString = new String(Files.readAllBytes(Paths.get("user.json")));
            // Parse the JSON string into a JSONArray
            JSONArray jsonArray = new JSONArray(jsonString);
            // Iterate through the JSONArray
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
               *//* postJson.put("User ID", user.getUserID());
                postJson.put("Post ID", post.getId());
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
                postsArray.put(postJson);*//*
                // Access object properties
                Post post=new Post();
                post.setAuthor(Main.vec.get( jsonObject.getInt("User ID")));
                jsonObject.getString("username");
                String name = jsonObject.getString("name");
                String email = jsonObject.getString("email");
                String password = jsonObject.getString("password");
                String birth_date = jsonObject.getString("birth date");
                Date dateOfBirth=new SimpleDateFormat("yyyy-MM-dd").parse(birth_date);
                Long phonenumber=jsonObject.getLong("phone number");
                String gender = jsonObject.getString("gender");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

    }
}

