import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LoginPage {
    static String username;
    static String password;
    static Scanner in = new Scanner(System.in);

    public static void Login() {

        System.out.println("/t Welcome To our Facebook");
        System.out.println("Enter Username :");
        username = in.next();
        System.out.println("Enter Password :");
        password = in.next();

    }
    private void register (User user)
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


    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");


    }
}