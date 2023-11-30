import java.util.Scanner;
import java.util.ArrayList;

public class User
{

    static int UserID;
    private String Name;
    private String Email;
    private String Password;
    private String Gender;
    private String Birthdate;
    private int PhoneNumber;
    Scanner scanner = new Scanner(System.in);
    ArrayList <String> Posts = new ArrayList <String>();
    ArrayList <String> Notifications = new ArrayList <String>();
    ArrayList <String> Friends = new ArrayList <String>();
    ArrayList <String> Conversations = new ArrayList <String>();

    public static int getUserID() {
        return UserID;
    }

    public static void setUserID(int userID) {
        UserID = userID;
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

    void updateProfile (String Name, String Birthdate, int PhoneNumber)
    {
        this.Name = Name;
        this.Birthdate = Birthdate;
        this.PhoneNumber = PhoneNumber;
    }


}






