
import java.util.*;
import javafx.util.Pair;
import org.w3c.dom.ls.LSOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//user1=3 user2=5
//pair=35;
// pair (35,accepted)

class FriendShip {
////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////////////
    private User User1, User2;
    private Pair User_IDs =new Pair(User1.getUserID(),User2.getUserID());
    private int status_user1, status_user2;
    Pair Friendship_Status =new Pair(status_user1,status_user2);
    Pair Friendship_ID = new Pair(User_IDs,Friendship_Status);
    private String StringFriendship_status;
    private String Friendship_Role;
    ArrayList<Post> Mutual_Posts = new ArrayList<>();

    //////////////////////////////////////////////CONSTRUCTORS//////////////////////////////////////
    public FriendShip(User user1,User user2){
        this.User1 =user1;
        this.User2 =user2;
        StringFriendship_status= "Pending";
    }
    ////////////////////////////////////////////////////METHODS//////////////////////////////////////////////////////

    ////////////////////////////////////////////////////getters//////////////////////////////////////////////////
    public Pair getUser_IDs() {
        return User_IDs;
    }
    public int getStatus_user1() {return status_user1;}
    public int getStatus_user2() { return status_user2;}
    public Pair getFriendship_Status() { return Friendship_Status;}
    public Pair getFriendship_ID() { return Friendship_ID;}

    public String getFriendship_status() {
        return StringFriendship_status;
    }
    public String getFriendship_Role() {
        return Friendship_Role;
    }
    public ArrayList<Post> getMutual_Posts() {
        return Mutual_Posts;
    }
    public static FriendShip getFriendship(User First_User,User Second_User ) {

        Pair Searched_Users_IDs1 = new Pair(First_User.getUserID(), Second_User.getUserID());
        Pair Searched_Users_IDs2 = new Pair(Second_User.getUserID(), First_User.getUserID());
        for (FriendShip friendship : Main.friendship) {
            if (friendship.getUser_IDs() == Searched_Users_IDs1 || friendship.getUser_IDs() == Searched_Users_IDs2 ) {
            return friendship;
            }
        }
    return null;
   }
    ////////////////////////////////////////////////////setters//////////////////////////////////////////////////

    public void setUser_IDs(int user1_id, int user2_id) {
        User_IDs = new Pair<>(user1_id,user1_id);
    }
    public void setFriendship_Status (int status_user1, int status_user2){
        Friendship_Status = new Pair<>(status_user1, status_user1);
    }

    public void setFriendship_ID(Pair User_IDs, Pair Friendship_Status) {
        Friendship_ID = new Pair<>(User_IDs, Friendship_Status);
    }

    public void setFriendship_Role(int Friend_Role) {
        if (Friend_Role == 0)
            Friendship_Role = "Restricted";
        else  Friendship_Role = "Regular";
    }

    public void acceptFriendRequest() {
        //change pair
        status_user1 = 1; status_user2 = 1;
        Friendship_Status = new Pair<>(status_user1, status_user1);
        Friendship_ID = new Pair<>(User_IDs, Friendship_Status);
        StringFriendship_status = "Accepted";
        System.out.println("You accepted friend request from " + User2.getUserName() +" \nNow you are Friends" );
        User1.addFriend(User2);
        User2.addFriend(User1);
    }

    public void declineFriendRequest() {
        status_user1 = 0; status_user2 = 0;
        Friendship_Status = new Pair<>(status_user1, status_user1);
        Friendship_ID = new Pair<>(User_IDs, Friendship_Status);
        StringFriendship_status = "Declined";
        System.out.println("You declined friend request from " + User2.getUserName());
    }
    public void addMutualPost(Post post){
        Mutual_Posts.add(post);
    }
    //mutual posts
}
