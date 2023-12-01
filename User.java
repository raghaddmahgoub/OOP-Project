import java.util.ArrayList;
import javax.sound.midi.Soundbank;
import java.util.Scanner;
import java.util.Vector;

public class User
{
    static int UserID;
    private String User_Name;
    private String Name;
    private String Email;
    private String Password;
    private String Gender;
    private String Birthdate;
    private int PhoneNumber;
    Scanner scanner = new Scanner(System.in);
    Vector<String> Notifications = new Vector<>();
    Vector<String> Friends = new Vector<>();
    Vector<String> Posts = new Vector<>();
    Vector<String> Conversations = new Vector<>();


    public static int getUserID() {
        return UserID;
    }

    public static void setUserID(int userID) {
        UserID = userID;
    }

    public String get_UserName() {return User_Name;}
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




    public void SearchForUser (String UserName) {

        for (User Desired_User : Main.vec) {
            if (Desired_User.User_Name.equals(UserName)) {
                // To Display Options of a user
                Searched_User_Menu(UserName);
            } else return;
        }
    }
    void updateProfile (String Name, String Birthdate, int PhoneNumber)
    {
        this.Name = Name;
        this.Birthdate = Birthdate;
        this.PhoneNumber = PhoneNumber;
    }

    void changePassword (String Password)
    {
        this.Password = Password;
    }
    void viewNotifications(ArrayList <String> Notifications)
    {
        System.out.println ("Notifications");
        for (String Notification : Notifications)
        {
            System.out.println(Notification);
        }
    }


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
                AddFriend(UserName);
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
    public void AddFriend(String UserName) {
        Friends.add(UserName);
    }
    public void RemoveFriend(String UserName){
        Friends.removeElement(UserName);
    }

    public void Add_Role_Of_a_Friend(){
    }
    public void See_Mutual_Posts(String Username2){
    }
    public void See_Mutual_Friends(String Username2) {
    }
    public void Get_Posts_By_PrivacyLevel(){
    }
}






