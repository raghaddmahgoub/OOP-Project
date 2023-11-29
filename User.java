import java.util.Scanner;
import java.util.Vector;
public class User
{
    static int UserID=0;
    private String Name;
    private String Email;
    private String Password;
    private String Gender;
    private String Birthdate;
    private int Phonenumber;

    Scanner scanner = new Scanner(System.in);

    private void register ()
    {
        System.out.println("Enter your name: ");
        Name = scanner.nextLine();
        System.out.println("Enter your email: ");
        Email = scanner.nextLine();
        System.out.println("Enter your password: ");
        Password = scanner.nextLine();
        System.out.println("Enter your gender: ");
        Gender = scanner.nextLine();
        System.out.println("Enter your phone number: ");
        Phonenumber = scanner.nextInt();
        System.out.println("Enter your birthdate: ");
        Birthdate = scanner.nextLine();
        UserID+=1;
    }
}



