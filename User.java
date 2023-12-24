
import java.text.SimpleDateFormat;
import java.util.*;
import javax.sound.midi.Soundbank;
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
    private Date Birthdate;
    private Long PhoneNumber;
    private String userPrivacy;
    ArrayList <User> Friends = new ArrayList <User>();
    ArrayList<FriendShip> relations = new ArrayList<FriendShip>();
    private ArrayList <FriendRequest> friendRequests = new ArrayList <FriendRequest>();
    private final ArrayList<Postnotification> postnotifications = new ArrayList<Postnotification>();

    private ArrayList<Post> Posts = new ArrayList<Post>();
    private Messenger messenger;

////////////////////////////////////////////////////////////constructors////////////////////////////////////////////////

    public User(String User_Name, String Password){
        this.User_Name = User_Name;
        this.Password = Password;

    }
    public void AddFriend(User New_Friend_User) {
        Friends.add(New_Friend_User);
    }
    public User(String User_Name, String Password, String Email){
        User_ID=Number_Of_Users;
        Number_Of_Users++;
        this.User_Name = User_Name;
        this.Password = Password;
        this.Email = Email;
    }
    ////////////////////////////////////////////////////////////methods//////////////////////////////////////////////////////////////
    public ArrayList<Postnotification> getPostNotifications() {
        return postnotifications;
    }

    public void addPostNotifiObject(Postnotification postnotification) {
        this.postnotifications.add(postnotification);
    }
    public ArrayList<FriendRequest> getFriendRequests() {
        return friendRequests;
    }
    public void setFriendRequest(FriendRequest friendRequest){
        friendRequests.add(friendRequest);
    }
    public ArrayList<Post> getAllPosts() {
        return Posts;
    }
    public Post getPost(int postId) {
        return getAllPosts().get(postId);
    }
    public void addApost(Post post) {
        Posts.add(post) ;
    }
    public ArrayList<User>getFriends() {
        return Friends;
    }
    public int getUserID() {
        return this.User_ID;
    }
    public void RemoveFriend(User Friend_User){
        Friends.remove(Friend_User);
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
    public Date getBirthdate(){
        return Birthdate;
    }
    public String getBirthdateString() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(getBirthdate());
        return formattedDate;
    }
    public void setBirthdate(Date birthdate) {
        Birthdate = birthdate;
    }

    public Long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        PhoneNumber = phoneNumber;
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
    public void addFriend (User friend){
        Friends.add(friend);
    }
    public Messenger getMessenger() {
        return messenger;
    }

    public void setMessenger(User user) {
        this.messenger = new Messenger(user);
    }

}

