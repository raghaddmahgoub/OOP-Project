
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInterface {
    private static String username;
    private static String password;
    static Scanner in = new Scanner(System.in);

    private static User user;
    public static void ProgramStart(){
        int choice;
        System.out.println("\t Welcome To our Facebook");
        System.out.println("1.Login");
        System.out.println("2.Signup");
        System.out.print("Enter a choice :");
        choice=in.nextInt();
        switch (choice){
            case 1:
                user = LogIn();
                break;
            case 2:
                user = SignUp();
                break;
            default:
                System.out.println("Invalid Choice please try again :( ");
                ProgramStart();
        }
    }
    public static User LogIn() {
        User user;

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
        if(!LoginStatus(username,password)){
            System.out.println("Username or Password is not correct please Try again :( ");
            LogIn();
        }
        new Feed(Feed.GetUserData(username));
        return Feed.GetUserData(username);
    }

    public static User SignUp() {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

        System.out.println("/t Welcome To our Facebook");
        System.out.println("Enter Username (at least 8 chars):");
        username = in.next();
        while (username.length() < 8){
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

        while (password.length()<8){
            System.out.println("Password is Empty please Try again :( ");
            System.out.println("Enter Password :");
            password = in.next();
        }
        user=new User(username, password);
        System.out.println("SignUp Successful");
        System.out.println("\n\n\tNow you need to enter some information");
        System.out.println("Enter your name:");

        String name = new String();
        try {
            name = reader.readLine(); // Read a line of text from the console
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }

        while (name.isEmpty()){
            System.out.println("name is Empty please Try again :( ");
            System.out.println("Enter your name :");
            try {
                name = reader.readLine(); // Read a line of text from the console
            } catch (IOException e) {
                System.out.println("Error reading input: " + e.getMessage());
            }
        }
        System.out.println("Enter gender :");
        String gender=new String();
        String Gender=new String();
        gender = in.next();
        Gender = gender.toLowerCase();
        while ((!Gender.equals("female")) && (!Gender.equals("male"))){
            System.out.println("gender is not valid please Try again :( ");
            System.out.println("Enter gender :");
            gender = in.next();
        }
        System.out.println("Enter PhoneNumber :");
        int phonenumber=new Integer(0);
        phonenumber = in.nextInt();
        while (phonenumber<99999999){
            System.out.println("Phone Number is not valid please Try again :( ");
            System.out.println("Enter PhoneNumber :");
            phonenumber = in.nextInt();
        }
        System.out.println("Enter E_mail :");
        String email = in.next();
        while (email.isEmpty() || email.contains(" ")){
            System.out.println("E_mail is Empty please Try again :( ");
            System.out.println("Enter E_mail :");
            email = in.next();
        }
        //===========================
        user.setName(name);
        user.setPhoneNumber(phonenumber);
        user.setEmail(email);
        if(gender.equals("female")){
            user.setGender(User.GenderOptions.FEMALE);
        }else{
            user.setGender(User.GenderOptions.MALE);
        }
        Main.vec.add(user);
        System.out.println("Wish you enjoy our facebook :)");
        //=============================
        new Feed(user);
        return user;
    }
    public static boolean CheckUserIsUnique (String Username){
        for (User user:Main.vec){
            if(user.getUserName().equals(Username)){
                return false;
            }
        }
        return true;
    }
    public static boolean LoginStatus(String Username,String Password){
        for (User user:Main.vec){
            if(user.getUserName().equals(Username) && user.getPassword().equals(Password)){
                return true;
            }
        }
        return false;
    }


}
