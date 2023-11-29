import java.util.Scanner;
import java.util.Vector;


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


}






