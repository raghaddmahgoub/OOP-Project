
import java.util.Scanner;

public class Feed {
    //List of Notifications
    User user;
    static Scanner in = new Scanner(System.in);
    UserDashBoard dashboard;
    public Feed(User user){
        this.user = user;
        viewUserFeed();
    }
    public void viewUserFeed(){
        System.out.println("To View Posts Press 1");
        System.out.println("To View Your Notifications Press 2");
        System.out.println("To View Your Friends Menu Press 3");
        System.out.println("To View Your Dashboard Press 4");
        System.out.println("To Exit Press 5");
        int choice = in.nextInt();
        switch (choice){
            case 1:
                System.out.println("Posts");
                break;
            case 2:
                System.out.println("Notifications");
                break;
            case 3:
                System.out.println("Friends");
                break;
            case 4:
                dashboard = new UserDashBoard(user);
                break;
            case 5:
                return;
        }
    }
    //    public void AddPost(String content) {
//       Post post= new Post(content);
//        System.out.println("do you want to tag a friend ? \n yes or no \n");
//        String answer =in.next();
//
//        while(answer== "yes"){
//            System.out.println("which friend?\n");
//            answer=in.next();
//            User friend =new User();
//            friend=GetUserData(answer);
//            post.addTaggedUser(friend);
//        }
//        user.Posts.add(post);
//    }
    public void SearchForUser (String UserName) {

        for (User Desired_User : Main.vec) {
            if (Desired_User.getUserName().equals(UserName)) {
                // To Display Options of a user
                Searched_User_Menu(UserName);
            } else return;
        }
    }

    public void ViewProfile(){
//        System.out.println("The User\'s Name is: " + Name);
//        System.out.println("The User\'s Email is: " + Email);
//        System.out.println("The User\'s Gender is: " + Gender);
//        System.out.println("The User\'s Birth Date is: " + Birthdate);
//        System.out.println("The User\'s Phone Number is: " + PhoneNumber);
    }
    public void Searched_User_Menu (String UserName){
        System.out.println("1. View Profile");
        System.out.println("2. Check Friendship");
        System.out.print("Enter a choice :");
        char choice = in.next().charAt(0);
        switch (choice){
            case 1:
                ViewProfile();
                break;
            case 2:
                boolean A_Friend = Check_Friendship(UserName);
                if (A_Friend) {
                    System.out.println("You are Friends :)");
                    Friend_Menu (UserName);
                }
                if (!A_Friend){
                    System.out.println("You are not Friends :(");
                    Not_Friend_Menu(UserName);
                }
                break;
            default:
                System.out.println("Invalid Choice please try again :( ");
                Searched_User_Menu(UserName);
        }
    }
    public void likeComments(Comment comment){
        comment.addReaction();
    }
    public void likeReply(Reply reply){
        reply.addReact();
    }
    public void Friend_Menu (String UserName){
        System.out.println("1. Remove Friend");
        System.out.println("2. See Mutual Friends");
        System.out.println("3. See Mutual Posts");
        System.out.println("4. Add A Role (Regular/Restricted)");
        System.out.print("Enter a choice :");
        char choice = in.next().charAt(0);
        switch (choice){
            case 1:
                RemoveFriend(UserName);
                break;
            case 2:
                See_Mutual_Friends(UserName);
                break;
            case 3:
                See_Mutual_Posts(UserName);
                break;
            default:
                System.out.println("Invalid Choice please try again :( ");
                Friend_Menu(UserName);
        }
    }

    public void Not_Friend_Menu (String UserName){
        System.out.println("1. Add Friend");
        System.out.println("2. See Mutual Friends");
        System.out.print("Enter a choice :");
        char choice = in.next().charAt(0);
        switch (choice){
            case 1:
                sendFriendRequest(GetUserData(UserName));
                break;
            case 2:
                See_Mutual_Posts(UserName);
                break;
            default:
                System.out.println("Invalid Choice please try again :( ");
                Friend_Menu(UserName);
        }
    }
    public void sendFriendRequest(User friend) {
        friend.getFriendRequests().add(user);
        System.out.println("Friend request sent to " + friend.getUserName());
        //new friendship
    }

    public void AddFriend(User New_Friend_User) {
        user.Friends.add(New_Friend_User.getUserName());
    }
    public void RemoveFriend(String UserName){
        //user.Friends.remove()
    }
    public void sendMessage (String content){
        Messages newMessage = new Messages ();
        newMessage.setContent(content);
    }
    public static User GetUserData(String username) {
        for (User Targeted : Main.vec) {
            if (Targeted.getUserName().equals(username)) {
                return Targeted;
            }
        }
        return null;
    }
    public void Add_Role_Of_a_Friend(){
    }
    public void See_Mutual_Posts(String Username2){
    }
    public void See_Mutual_Friends(String Username2) {
    }
    public boolean Check_Friendship(String UserName) {
//        for (String Friend: user.getFriends()) {
//            if (Friend.equals(UserName))
//                return true;
//        }
        return false;
    }
    public void Get_Posts_By_PrivacyLevel(){
    }
}
