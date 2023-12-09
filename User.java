
import java.util.ArrayList;
import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.time.LocalDateTime;

public class User
{
    public enum GenderOptions {
        MALE, FEMALE, NONE
    }

    private String User_ID;
    private String User_Name;
    private String Name;
    private String Email;
    private String Password;
    private GenderOptions Gender = GenderOptions.NONE;
    private String Birthdate;
    private String PhoneNumber;

    ArrayList <User> Friends = new ArrayList <User>();
    ArrayList <String> Conversations = new ArrayList <String>();
    ArrayList <User> friendRequests = new ArrayList <User>();
    ArrayList<FriendShip> Relations = new ArrayList<>();
    private String userPrivacy;
    private ArrayList<Notification> Notifications = new ArrayList<Notification>();

    public ArrayList<Post> getPosts() {
        return Posts;
    }

    private ArrayList<Post> Posts = new ArrayList<Post>();

    public User(String User_Name, String Password){
        this.User_Name = User_Name;
        this.Password = Password;
    }

    public User(String User_ID, String User_Name, String Password, String Email){
        this.User_ID = User_ID;
        this.User_Name = User_Name;
        this.Password = Password;
        this.Email = Email;
    }
    public ArrayList<User> getFriends() {
        return Friends;
    }
    public String getUserID() {
        return this.User_ID;
    }

    public void setUserID(String userID) {
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

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

}

