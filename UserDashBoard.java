import java.util.Scanner;

public class UserDashBoard {

    static Scanner in = new Scanner(System.in);
    static User user;

    public UserDashBoard(User user){
        this.user = user;
        viewDashboard();
    }

    public void viewDashboard ()
    {
        System.out.println("To View Your Profile Press 1");
        System.out.println("To Update Your Profile Press 2");
        int choice = in.nextInt();

        switch(choice){
            case 1:
                viewProfile();
                break;
            case 2:
                updateProfile();
                break;
        }
    }

    public void viewProfile ()
    {
        System.out.println("Profile:");
        System.out.println("UserName " + user.getUserName());
//        System.out.println("Email: " + user.getEmail());
//        System.out.println("Gender: " + user.getGender());
//        System.out.println("Date Of Birth: " + user.getBirthdate());
//        System.out.println("Phone Number: " + user.getPhoneNumber());
    }

    public void updateProfile ()
    {
        System.out.println("To Update Your UserName Press 1");
        System.out.println("To Change Your Password Press 2");
        System.out.println("To Return To The Previous Menu Press 3");
        int choice = in.nextInt();
        switch (choice){
            case 1:
                updateUserName();
                break;
            case 2:
                changePassword();
                break;
            case 3:
                viewDashboard();
                break;
        }
    }

    public  void updateUserName(){
        System.out.println("Current User Name: " + user.getUserName());
        System.out.println("\nEnter your New Name: ");

        // Validate
        user.setUser_Name(in.next());

        // On Success Return
        viewDashboard();
    }
    public void changePassword ()
    {
        String oldPassword;
        String NewPassword;

        System.out.println("Enter your current password: ");
        oldPassword = in.next();

        while (oldPassword.isEmpty()){
            System.out.println("Password is Empty please Try again :( ");
            System.out.println("Enter your current password: ");
            oldPassword = in.next();
        }

        while(!user.getPassword().equals(oldPassword)){
            oldPassword = in.next();
            System.out.println("Enter your current password: ");
        }

        System.out.println("Enter your New password: ");
        NewPassword =in.next();
        user.setPassword(NewPassword);
    }
}

