import java.io.*;
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
        JSONArray UserJson = new JSONArray();
        for (User user : Main.vec) {
            JSONObject userjson = new JSONObject();
            userjson.put("ID", user.getUserID());
            userjson.put("username", user.getUserName());
            userjson.put("name", user.getName());
            userjson.put("email", user.getEmail());
            userjson.put("password", user.getPassword());
            userjson.put("birth date", user.getBirthdateString());
            userjson.put("phone number", user.getPhoneNumber());
            userjson.put("gender", user.getGender());
            JSONArray postsArray = new JSONArray();
            for (Post post : user.getAllPosts()) {
                JSONObject postJson = new JSONObject();
                postJson.put("ID", post.getId());
                postJson.put("content", post.getContent());
                postJson.put("time stamp", post.getTimestamp());
                JSONArray commentsArray = new JSONArray();
                for (Comment comment : post.getAllComments()) {
                    JSONObject commentJson = new JSONObject();
                    commentJson.put("comment ID", comment.getId());
                    commentJson.put("comment content", comment.getContent());
                    commentJson.put("commenter", comment.getAuthor().getUserName());
                    JSONArray replaysArray = new JSONArray();
                    for (Reply replay : comment.getUserReplies()) {
                        JSONObject replayjson = new JSONObject();
                        replayjson.put("reply id", replay.getId());
                        replayjson.put("reply content", replay.getContent());
                        replayjson.put("replier", replay.getAuthor().getUserName());
                        replaysArray.put(replayjson);
                    }
                    commentJson.put("replay",replaysArray);
                    commentsArray.put(commentJson);
                }
                postJson.put("comments",commentsArray);
                postsArray.put(postJson);

            }
            JSONObject Messengerjson = new JSONObject();
            //Messengerjson.put("messanger ID",user.getMessenger().getMessenger_id());
            JSONArray conversationsArray = new JSONArray();
            for (Conversation conversation :user.getMessenger().getConversations()) {
                JSONObject conversationJson = new JSONObject();
                conversationJson.put("conversationID", conversation.getConversation_id());
                conversationJson.put("conversation time", conversation.getTime());
                conversationJson.put("conversation status", conversation.getStatus());
                JSONArray MessageArray = new JSONArray();
                for (Messages Message : conversation.getMessages()) {
                    JSONObject messagejson = new JSONObject();
                    messagejson.put("message id", Message.getId());
                    messagejson.put("message content", Message.getContent());
                    messagejson.put("message sender_id", Message.getSender_ID());
                    messagejson.put("message status", Message.getStatus());
                    messagejson.put("message timestamp", Message.getTimestamp());
                    messagejson.put("message reacts", Message.getReacts());
                    for (Reply messagereply : Message.getMessageReplies()) {
                        JSONObject messageReplayjson = new JSONObject();
                        messageReplayjson.put("replay id", messagereply.getId());
                        messageReplayjson.put("replay content", messagereply.getContent());
                        messageReplayjson.put("replayer", messagereply.getAuthor().getUserName());

                    }

                }
            }
            userjson.put("posts",postsArray);
            UserJson.put(userjson);
        }

            // Writing JSON to a file
        try (FileWriter file = new FileWriter("user.json",false)) {
                file.write(UserJson.toString(4)); // Use toString(int) for indentation
                System.out.println("JSON file created successfully.");
        } catch (IOException e) {
                System.out.println("JSON file not work.");

        }

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
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("src/user.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            String password = (String) jsonObject.get("password");
            System.out.println(password);

            String gender= (String) jsonObject.get("gender");
            System.out.println(gender);
            String name= (String) jsonObject.get("name");
            System.out.println(name);

            Long phone= (Long) jsonObject.get("phone number");
            //Long Phone=Long.getLong(phone);
            System.out.println(phone);


            Long Id= (Long) jsonObject.get("ID");
            //int id=Integer.getInteger(Id);
            System.out.println(Id);




       /*     // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<Object> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
*/

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

