import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class FriendRequest extends Notification {
    User sender ;
    User reciever;
    FriendShip relation;

    public FriendRequest(User sender, User reciever, FriendShip relation) {
        this.sender = sender;
        this.reciever = reciever;
        this.relation = relation;
        TimeStamp= Timestamp.valueOf(LocalDateTime.now());
    }

    public void expand_friendrequest() {
        getTimeStamp();
        System.out.println(sender.getUserName() + "sends you friend request");

        System.out.println("1.accept \n 2.reject\n");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        switch (x) {
            case 1:
                relation.acceptFriendRequest();
                break;
            case 2:
                relation.declineFriendRequest();
                break;
            default:
                System.out.println("invalid choice");
                expand_friendrequest();
        }
    }
}
