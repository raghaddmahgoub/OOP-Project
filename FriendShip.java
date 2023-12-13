
import java.util.*;
import javafx.util.Pair;
import org.w3c.dom.ls.LSOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FriendShip {

    private int User1_ID, User2_ID;
    private User User1, User2;
    Pair User_IDs =new Pair(User1_ID,User2_ID);
    private int status_user1, status_user2;
    Pair Friendship_Status =new Pair(status_user1,status_user2);
    Pair Friendship_ID = new Pair(User_IDs,Friendship_Status);
    private String Friendship_status;
    private String Friendship_Role;
    ArrayList<Post> Mutual_Posts = new ArrayList<>();


    public FriendShip(User user1,User user2){
        this.User1_ID= user1.getUserID();
        this.User2_ID= user2.getUserID();
        this.User1 =user1;
        this.User2 =user2;
        Friendship_status= "Pending";
    }
    public int getUser1_ID() {
        return User1_ID;
    }
    public int getUser2_ID() {
        return User2_ID;
    }
    public Pair getUser_IDs() {
        return User_IDs;
    }
    public int getStatus_user1() {return status_user1;}
    public int getStatus_user2() { return status_user2;}
    public Pair getFriendship_Status() { return Friendship_Status;}
    public Pair getFriendship_ID() { return Friendship_ID;}

    public String getFriendship_status() {
        return Friendship_status;
    }
    public String getFriendship_Role() {
        return Friendship_Role;
    }

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

    public void Set_Friendship_status(Pair Friendship_ID) {
        //Friendship_ID will be pair after that
        if (Friendship_Status.getKey().equals(0) && Friendship_Status.getValue().equals(0))
            Friendship_status = "Declined";

        else if (Friendship_Status.getKey().equals(1) && Friendship_Status.getValue().equals(1))
            Friendship_status = "Accepted";

    }
    public void acceptFriendRequest() {
        //change pair
        status_user1=1; status_user2=1;
        Friendship_Status = new Pair<>(status_user1, status_user1);
        Friendship_ID = new Pair<>(User_IDs, Friendship_Status);
        System.out.println("You accepted friend request from " + User2.getUserName() +"Now you are Friends" );
//        User1.AddFriend(User2);
//        User2.AddFriend(User1);
    }

    public void declineFriendRequest() {
        status_user1 = 0; status_user2 = 0;
        Friendship_Status = new Pair<>(status_user1, status_user1);
        Friendship_ID = new Pair<>(User_IDs, Friendship_Status);
        System.out.println("You declined friend request from " + User2.getUserName());
    }

    ///mutual posts
    public void setMutual_Posts(ArrayList<Post> mutual_Posts) {
        Mutual_Posts = mutual_Posts;
    }
    public ArrayList<Post> getMutual_Posts() {
        return Mutual_Posts;
    }
}
