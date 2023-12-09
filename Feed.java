
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
        System.out.println("To Add Post Press 5");
        System.out.println("To view Posts Press 6");
        System.out.println("To Exit Press 7");
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
                addPost();
                break;
            case 6:

            case 7 :
                return;
        }
    }
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
        user.Friends.add(New_Friend_User);
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
    public void editPost(Post post){
        String edittedContent= in.next();
        post.setContent(edittedContent);
    }
    public void addPost(){
        System.out.println("enter the content of the post");
        Post post = new Post();
        String content= in.next();
        post.setContent(content);
        System.out.println("do you want to tag a friend ? y or n");
        char choice = in.next().charAt(0);
        if (choice=='y'||choice=='Y' ){
            addTaggedUser(post);
        }
        System.out.println("want to set privacy ? y or n");
        char ch = in.next().charAt(0);
        if (ch=='y'||ch=='Y' ){setPostPrivacy(post);}
        System.out.println("post added");
        user.addApost(post);
        viewUserFeed();
    }
    public void addTaggedUser(Post post) {
        for (User friendlist:user.Friends) {
            System.out.println(friendlist.getUserName());
            System.out.println('\n');
        }
        System.out.println("enter your friend name");
        String friendName=in.next();
        for (User friend:user.Friends) {
            if(friendName.equals(friend.getUserName())) {
                post.TagUser(friend);
                System.out.println("tagged friends done");
            }
            else {
                System.out.println("invalid name");
                addTaggedUser(post);
            }
        }
    }
    public void setPostPrivacy(Post post){

        System.out.println("for public press 1 \n for private press 2 for default press 3");
        int privacy = in.nextInt();
        switch (privacy){
            case 1: post.setPrivacy("public"); break;
            case 2: post.setPrivacy("private"); break;
            case 3: post.setPrivacy(user.getUserPrivacy()); break;
            default:
                System.out.println("invalid input");
                setPostPrivacy(post);
        }
    }
    public void Add_Role_Of_a_Friend(){
    }
    public void See_Mutual_Posts(String Username2){
    }
    public void See_Mutual_Friends(String Username2) {
    }

    public  boolean Check_Friendship(String UserName) {
        for (User Friend: user.getFriends()) {
            if (Friend.getUserName().equals(UserName))
                return true;
        }
        return false;
    }
    public void Get_Posts_By_PrivacyLevel(){
    }
}
