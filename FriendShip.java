
import java.util.*;
import javafx.util.Pair;
import org.w3c.dom.ls.LSOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Timestamp;
import java.time.LocalDateTime;


//user1=3 user2=5
//pair=35;
// pair (35,accepted)

class FriendShip {
////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////////////
    private User User1, User2;
    Timestamp FriendsSince ;
    private Pair User_IDs =new Pair(User1.getUserID(),User2.getUserID());
    private int status_user1, status_user2;
    private Pair Friendship_Status =new Pair(status_user1,status_user2);
    private Pair Friendship_ID = new Pair(User_IDs,Friendship_Status);
    private String StringFriendship_status;
    private int Friend1_Role, Friend2_Role;
    private Pair Friends_Roles = new Pair (Friend1_Role, Friend2_Role);
    private Pair Friendship_Role = new Pair (User_IDs, Friends_Roles);
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
    public Pair getFriendship_Role() {
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

    public void setFriendship_Status (int status_user1, int status_user2){
        Friendship_Status = new Pair<>(status_user1, status_user1);
    }

    public void setFriendship_ID(Pair User_IDs, Pair Friendship_Status) {
        Friendship_ID = new Pair<>(User_IDs, Friendship_Status);
    }

    public void setFriendship_Role(int friend_role, User user) {
        if (user == this.User1)
            Friend1_Role = friend_role;
        if (user == this.User2)
            Friend2_Role = friend_role;
        Friends_Roles= new Pair<> (Friend1_Role, Friend2_Role);
        Friendship_Role = new Pair<>(User_IDs, Friends_Roles);
    }

    public long GetRelationTimeInDays (){
        Timestamp t=Timestamp.valueOf(LocalDateTime.now());
        long x=t.getTime()-FriendsSince.getTime();
        x=x/86400000;
        return x;
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

    public long getRelationScore(){
        long x=GetRelationTimeInDays();
        if(x>180){
            return 15;
        } else if (x>=60) {
            return 12;
        } else if (x>=30) {
            return 9;
        } else if (x>=15) {
            return 6;
        } else {
            return 3;
        }
    }
}
