
import java.util.ArrayList;
import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.time.LocalDateTime;

public class User
{
    //////////////////////////////////////////////////////////////////attributes/////////////////////////////////////
    public enum GenderOptions {
        MALE, FEMALE, NONE
    }
    private static int Number_Of_Users=0;
    private int User_ID;
    private String User_Name;
    private String Name;
    private String Email;
    private String Password;
    private GenderOptions Gender = GenderOptions.NONE;
    private String Birthdate;
    private Integer PhoneNumber;
    private String userPrivacy;
    ArrayList <User> Friends = new ArrayList <User>();
    private ArrayList <String> Conversations = new ArrayList <String>();
    private ArrayList <User> friendRequests = new ArrayList <User>();


    ArrayList<FriendShip> relations = new ArrayList<FriendShip>();
    private ArrayList<Notification> Notifications = new ArrayList<Notification>();
    private ArrayList<Post> Posts = new ArrayList<Post>();
    private ArrayList<Post> Feed = new ArrayList<Post>();
    public ArrayList<Post> getPosts() {
        return Posts;
    }
    public ArrayList<Post> getFeedPosts() {
        return Feed;
    }

////////////////////////////////////////////////////////////constructors////////////////////////////////////////////////

    public User(String User_Name, String Password){
        this.User_Name = User_Name;
        this.Password = Password;

    }
    public void AddFriend(User New_Friend_User) {
        Friends.add(New_Friend_User);
    }
    public User(int User_ID, String User_Name, String Password, String Email){
        this.User_ID = User_ID;
        this.User_Name = User_Name;
        this.Password = Password;
        this.Email = Email;
    }
    ////////////////////////////////////////////////////////////methods//////////////////////////////////////////////////////////////
    public ArrayList<User> getFriends() {
        return Friends;
    }
    public int getUserID() {
        return this.User_ID;
    }
    public void RemoveFriend(User Friend_User){
        Friends.remove(Friend_User);
    }
    public void setUserID(int userID) {
        this.User_ID = userID;
    }
    public void addApost(Post post) {
        Posts.add(post) ;
    }

    public String getUserName() {
        return this.User_Name;
    }
    public void setUser_Name(String user_name) {
        this.User_Name = user_name;
    }

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

    public GenderOptions getGender() {
        return Gender;
    }
    public void setGender(GenderOptions gender) {
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

    public List<User> getFriendRequests() {
        return friendRequests;
    }

    public String getUserPrivacy() {
        return userPrivacy;
    }

    public void setUserPrivacy(String userPrivacy) {
        this.userPrivacy = userPrivacy;
    }

    public ArrayList<FriendShip> getRelations() {
        return relations;
    }
}

