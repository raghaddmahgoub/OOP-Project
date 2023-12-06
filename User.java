import java.util.ArrayList;
import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.time.LocalDateTime;


public class User
{
    private static int UserID;
    private String User_Name;
    private String Name;
    private String Email;
    private String Password;
    private String Gender;
    private String Birthdate;
    private int PhoneNumber;
    Scanner scanner = new Scanner(System.in);
    ArrayList <String> Friends = new ArrayList <String>();
    ArrayList <String> Conversations = new ArrayList <String>();
    ArrayList <User> friendRequests = new ArrayList <User>();
    ArrayList<FriendShip> Relations = new ArrayList<>();
    private String userPrivacy;
    private ArrayList<Notification> Notifications = new ArrayList<Notification>();
    private ArrayList<Post> Posts=new ArrayList<Post>();


    public int getUserID() {
        return UserID;
    }

    public static void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {return User_Name;}
    public void setUser_Name(String user_name) {User_Name = user_name;}

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        Gender = gender;
    }

    public String getBirthdate() {
        return Birthdate;
    }
    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void updateProfile (String Name, String Birthdate, int PhoneNumber)
    {
        this.Name = Name;
        this.Birthdate = Birthdate;
        this.PhoneNumber = PhoneNumber;
    }

    public void changePassword (String Password)
    {
        this.Password = Password;
    }
    public void sendMessage (String content){
        Messages newMessage = new Messages ();
        newMessage.setContent(content);
    }
    public void AddPost(String content) {
        Post post= new Post(content);
        Posts.add(post);
    }

    public void likeComments(Comment comment){
        comment.addReaction();
    }
    public void likeReply(Reply reply){
        reply.addReaction();
    }
    public void viewNotifications()
    {
        System.out.println ("Notifications");
        for (Notification Notifi : Notifications)
        {
            System.out.println(Notifi);
        }
    }
    public void addNotification(String content){
        Notification newNotification= new Notification();
        newNotification.setContent(content);
        Notifications.add(newNotification);
    }
    public void SearchForUser (String UserName) {

        for (User Desired_User : Main.vec) {
            if (Desired_User.User_Name.equals(UserName)) {
                // To Display Options of a user
                Searched_User_Menu(UserName);
            } else return;
        }
    }

    public static User GetUserData(String username) {
        for (User Targeted : Main.vec) {
            if (Targeted.User_Name.equals(username)) {
                return Targeted;
            }
        }
        return null;
    }
    //string  username
    //friendship --> id
    //user name -----> user object

    public void Searched_User_Menu (String UserName){
        System.out.println("1. View Profile");
        System.out.println("2. Check Friendship");
        System.out.print("Enter a choice :");
        char choice = scanner.next().charAt(0);
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
    public void Friend_Menu (String UserName){
        System.out.println("1. Remove Friend");
        System.out.println("2. See Mutual Friends");
        System.out.println("3. See Mutual Posts");
        System.out.println("4. Add A Role (Regular/Restricted)");
        System.out.print("Enter a choice :");
        char choice = scanner.next().charAt(0);
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
        char choice = scanner.next().charAt(0);
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
    public boolean Check_Friendship(String UserName) {
        for (String Friend: Friends) {
            if (Friend.equals(UserName))
                return true;
        }
        return false;
    }
    public void ViewProfile(){
        System.out.println("The User\'s Name is: " + Name);
        System.out.println("The User\'s Email is: " + Email);
        System.out.println("The User\'s Gender is: " + Gender);
        System.out.println("The User\'s Birth Date is: " + Birthdate);
        System.out.println("The User\'s Phone Number is: " + PhoneNumber);
    }
    /////////
    public List<User> getFriendRequests() {
        return friendRequests;
    }

    public void sendFriendRequest(User friend) {
        friend.getFriendRequests().add(this);
        System.out.println("Friend request sent to " + friend.getUserName());
        //new friendship
    }

    public void AddFriend(User New_Friend_User) {
        Friends.add(New_Friend_User.getUserName());
    }
    public void RemoveFriend(String UserName){

    }

    public void Add_Role_Of_a_Friend(){
    }
    public void See_Mutual_Posts(String Username2){
    }
    public void See_Mutual_Friends(String Username2) {
    }
    public void Get_Posts_By_PrivacyLevel(){
    }
    public String getUserPrivacy() {
        return userPrivacy;
    }


    public void setUserPrivacy(String userPrivacy) {
        this.userPrivacy = userPrivacy;
    }

}






