import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
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
        int choice = 0;
        Boolean validate=new Boolean(false);

        while(!validate) {
            try {
                choice=in.nextInt();
                validate=true;
            } catch (InputMismatchException e) {
                System.out.println("invaild choice try again");
                System.out.print("Enter a choice :");
                in.nextLine();
            }
        }
        switch (choice) {
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
