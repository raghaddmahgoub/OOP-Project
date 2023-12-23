import java.util.*;
import javafx.util.Pair;
import org.w3c.dom.ls.LSOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Timestamp;
import java.time.LocalDateTime;

class FriendShip {
    ////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////////////
    private User User1, User2;
    //    private Pair User_IDs = new Pair(User1.getUserID(),User2.getUserID());
    private String Friendship_status;
    private int Friend1_Role, Friend2_Role;
    private Pair Friends_Roles = new Pair(Friend1_Role, Friend2_Role);
    ArrayList<Post> Mutual_Posts = new ArrayList<>();
    Timestamp FriendsSince;

    //////////////////////////////////////////////CONSTRUCTORS//////////////////////////////////////
    public FriendShip(User User1, User User2) {
        this.User1 = User1;
        this.User2 = User2;
        Friendship_status = "Pending";
    }
    ////////////////////////////////////////////////////METHODS//////////////////////////////////////////////////////

    ////////////////////////////////////////////////////getters//////////////////////////////////////////////////


    public void setFriendship_status(String Friendship_status) {
        this.Friendship_status = Friendship_status;
    }

    public String getFriendship_status() {
        return Friendship_status;
    }

    public ArrayList<Post> getMutual_Posts() {
        return Mutual_Posts;
    }

    public int getFriend1_Role() {
        return Friend1_Role;
    }

    public int getFriend2_Role() {
        return Friend2_Role;
    }

    public static FriendShip getFriendship(User First_User, User Second_User) {
        int ID1 = First_User.getUserID();
        int ID2 = Second_User.getUserID();
        for (FriendShip friendship : Main.Friendships) {
            if ((friendship.User1.getUserID() == ID1 || friendship.User1.getUserID() == ID2) && (friendship.User2.getUserID() == ID1 || friendship.User2.getUserID() == ID2)) {
                return friendship;
            }
        }
        return null;
    }

    public static FriendShip Remove_Friendship(User First_User, User Second_User) {
        int ID1 = First_User.getUserID();
        int ID2 = Second_User.getUserID();
        for (FriendShip friendship : Main.Friendships) {
            if ((friendship.User1.getUserID() == ID1 || friendship.User1.getUserID() == ID2)
                    && (friendship.User2.getUserID() == ID1 || friendship.User2.getUserID() == ID2))
                Main.Friendships.remove(friendship);
        }
        return null;
    }
    ////////////////////////////////////////////////////setters//////////////////////////////////////////////////


    public void setFriendship_Role(int friend_role, User user) {
        if (user == this.User1)
            Friend1_Role = friend_role;
        if (user == this.User2)
            Friend2_Role = friend_role;
    }
    public boolean see_role(User user){
        if (user == User1)
        {
            if (Friend1_Role == 1)
                return true;
            return false;
        }
        else if (Friend2_Role == 1)
            return true;
        return false;
    }
    public void acceptFriendRequest() {
        Friendship_status = "Accepted";
        System.out.println("You accepted friend request from " + User2.getUserName() +" \nNow you are Friends" );
        User1.addFriend(User2);
        User2.addFriend(User1);
    }

    public void declineFriendRequest() {
        Friendship_status = "Declined";
        System.out.println("You declined friend request from " + User2.getUserName());
    }
    public void addMutualPost(Post post){
        Mutual_Posts.add(post);
    }
    public long GetRelationTimeInDays (){
        Timestamp t=Timestamp.valueOf(LocalDateTime.now());
        long x=t.getTime()-FriendsSince.getTime();
        x=x/86400000;
        return x;
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
