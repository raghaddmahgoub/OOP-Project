import java.util.*;
//import javafx.util.Pair;

public class FriendShip {

    //private pair<int,int> friendshipID;
    private static int FriendShipID = 0;
    private int User1_ID, User2_ID;
    private String Friendship_status;
    private String Friendship_Role;
    FriendShip(){
        FriendShipID++;
    }

    public void Set_Friendship_ID (int user1_ID, int user2_ID){
        //pair of pair later on
    }
    public void Set_Friendship_status(int Friendship_ID){
        //Friendship_ID will be pair after that
        if (FriendShipID == 0)
            Friendship_status= "Declined";
        else if (FriendShipID == 2)
            Friendship_status= "Accepted";
        else  Friendship_status= "Pending";
    }
    public void Get_Friend_Role(int friend_role){
        if (friend_role == 0)
            Friendship_Role = "Restricted";
        else  Friendship_Role = "Regular";
    }

}
