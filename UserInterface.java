import java.util.Scanner;

public class UserInterface {
    static String username;
    static String password;
    static Scanner in = new Scanner(System.in);

    public static void ProgramStart(){
        int choice;
        System.out.println("/t Welcome To our Facebook");
        System.out.println("1.Login");
        System.out.println("2.Signup");
        System.out.print("Enter a choice :");
        choice=in.nextInt();
        switch (choice){
            case 1:
                LogIn();
                break;
            case 2:
                SignUp();
                break;
            default:
                System.out.println("Invalid Choice please try again :( ");
                ProgramStart();
        }
    }
    public static void LogIn() {


        System.out.println("Enter Username :");
        username = in.next();
        while (username.isEmpty()){
            System.out.println("Username is Empty please Try again :( ");
            System.out.println("Enter Username :");
            username = in.next();
        }
        System.out.println("Enter Password :");
        password = in.next();
        while (password.isEmpty()){
            System.out.println("Password is Empty please Try again :( ");
            System.out.println("Enter Password :");
            password = in.next();
        }
        if(LoginStatus(username,password)){

        }
        else{
            System.out.println("Username or Password is not correct please Try again :( ");
            LogIn();
        }
    }
    public static void SignUp() {
        System.out.println("/t Welcome To our Facebook");
        System.out.println("Enter Username :");
        username = in.next();
        while (username.isEmpty()){
            System.out.println("Username is Empty please Try again :( ");
            System.out.println("Enter Username :");
            username = in.next();
        }
        while (!CheckUserIsUnique(username)){
            System.out.println("Username is already exist please Try another one :) ");
            System.out.println("Enter Username :");
            username = in.next();
        }

        System.out.println("Enter Password :");
        password = in.next();

        while (password.isEmpty()){
            System.out.println("Password is Empty please Try again :( ");
            System.out.println("Enter Password :");
            password = in.next();
        }

    }
    public static boolean CheckUserIsUnique (String Username){
        for (User user:Main.vec){
            if(user.get_UserName().equals(Username)){
                return false;
            }
        }
        return true;
    }
    public static boolean LoginStatus(String Username,String Password){
        for (User user:Main.vec){
            if(user.get_UserName().equals(Username) && user.getPassword().equals(Password)){
                return true;
            }
        }
        return false;
    }


}
