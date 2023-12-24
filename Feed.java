import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Feed {
    static Scanner in = new Scanner(System.in);
    public static ArrayList <Post> FeedPosts=new ArrayList<>();
    User  user;

    UserDashBoard dashboard;
    public Feed(User user){
        this.user = user;
        viewUserFeed();
    }
   // ArrayList <Post> getALLposts = user.getPosts();
      public void viewUserFeed(){
            System.out.println("1- View Posts");//haneen
            System.out.println("2- View Your Notifications");//haneen
            System.out.println("3- View Your Friends Menu");
            System.out.println("4- View Your Dashboard");//renad
            System.out.println("5- Add Post");//haneen
            System.out.println("6- view Posts of Me");
            System.out.println("7- Search for user");
            System.out.println("8-go to messenger");
            System.out.println("9- Sign Out");
          Boolean validate=new Boolean(false);
            int choice = 0;
          while(!validate) {
              try {
                  choice=in.nextInt();
                  validate=true;
              } catch (InputMismatchException e) {
                  System.out.println("invaild choice try again");
                  System.out.print("Enter a choice :");
                  in.nextLine();
              }
          }
            switch (choice){
                case 1:
                    System.out.println("POST");
                    ViewFeed();
                    break;
                case 2:
                    showNotifications();
                    break;
                case 3:
                    System.out.println("FRIENDS");
                    friendsofme();
                    break;
                case 4:
                    dashboard = new UserDashBoard(user);
                    break;
                case 5:
                    addPost();
                    break;
                case 6:
                    view_my_posts(user);
                    viewUserFeed();
                    break;
                case 7 :
                    SearchForUser();
                    break;
                case 8 :
                    user.setMessenger(user);
                    user.getMessenger().MessengerFeed();
                    break;
                case 9 :
                    UserInterface.ProgramStart();
                    break;

                default:
                    System.out.println("invalid choice");
                    viewUserFeed();

            }
        }
    //////////////////////////////////////////////////////////////**NOTIFICATION**///////////////////////////////////////////////////////////////
        void showNotifications()
        {
            System.out.println ("NOTIFICATION");
            System.out.println("1. activity notifications\n2. friendrequests notifications ");
            Boolean validate=new Boolean(false);
            int choice = 0;
            while(!validate) {
                try {
                    choice=in.nextInt();
                    validate=true;
                } catch (InputMismatchException e) {
                    System.out.println("invaild choice try again");
                    System.out.print("Enter a choice :");
                    in.nextLine();
                }
            }
            switch (choice){
                case 1:
                    if (0<user.getPostNotifications().size()) {
                        for (Postnotification notifi : user.getPostNotifications()) {
                           int i=1;
                            System.out.println(notifi.getContent());
                            switch (notifi.getContent()) {
                                case "commented":
                                    notifi.commenting();
                                    break;
                                case "replied":
                                    notifi.replying();
                                    break;
                                case "like reply":
                                    notifi.liking();
                                    break;
                                case "tagged":
                                    notifi.tagging();
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + notifi.getContent());
                            }
                            System.out.println("see more ?y or n");
                            if((in.next().charAt(0)=='y'||in.next().charAt(0)=='Y') && i <= user.getPostNotifications().size()){
                              i++;
                            }
                            if(in.next().charAt(0)=='n'||in.next().charAt(0)=='N'){
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("you dont have activity notifiations yet");
                    }
                        break;
                case 2:
                    int i=1;
                    if (0< user.getFriendRequests().size()){
                         for (FriendRequest notifi:user.getFriendRequests()) {
                                   notifi.getTimeStamp();
                                   notifi.expand_friendrequest();
                             System.out.println("see more ?y or n");
                             if((in.next().charAt(0)=='y'||in.next().charAt(0)=='Y') && i <= user.getPostNotifications().size()){
                                 i++;
                             }
                            if(in.next().charAt(0)=='n'||in.next().charAt(0)=='N'){
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("you dont have friends notifiations yet");
                    }
                        break;
                default:
                    System.out.println("invalid option");
                    showNotifications();
            }
                viewUserFeed();
            }
    //////////////////////////////////////////////////////////////**POST**///////////////////////////////////////////////////////////////
    public static void view_my_posts(User user) {
        for (Post post : user.getAllPosts()) {
            int index = 1;
            System.out.println(index + ". " + post.getAuthor().getName());
            System.out.println(post.getContent());
            long p = post.GetPostTimeInMin();
            if (p > 60) {
                System.out.print("since " + post.GetPostTimeInHours() + "h     ");
            } else {
                System.out.print("since " + post.GetPostTimeInMin() + "min  ");
            }
            System.out.print(post.getReacts() + "likes    ");
            System.out.print(post.getAllComments().size() + "comments\n");
            System.out.println("=====================================================");
            index++;
        }
    }
        public void addPost(){
            System.out.println("enter the content of the post");
            Post post = new Post();
           String string = "";
            System.out.println("Enter strings (Enter '/' to stop):");
            while (true) {
                // Read a line of input
                String input = in.nextLine();
                // Check if the input is '/'
                if ("/".equals(input)) {
                    post.setContent(string);
                    break;
                }
                // Add the input to the list
                string=string.concat(input);
            }
            post.setAuthor(user);
            System.out.println("do you want to tag a friend ? y or n");
            char choice = in.next().charAt(0);
            if (choice=='y'||choice=='Y' ){
                post.addTaggedUser(post);
            }
            System.out.println("want to set privacy ? y or n");
            char ch = in.next().charAt(0);
            if (ch=='y'||ch=='Y' ){post.setPostPrivacy(post);}
            System.out.println("post added");
            user.addApost(post);
            viewUserFeed();
        }
    ////////////////////////////////////////////////////////////FRIENDSHIP///////////////////////////////////////////////////////////////////
    public void SearchForUser() {
        System.out.println("Enter username: ");
        String UserName = in.next();
        User New_User = GetUserData(UserName);
        if (New_User == null){
            System.out.println("The username you entered was not found. PLease try again :( ");
            System.out.println("Do You want to search again? (Y/N)");
            char choice =  in.next().charAt(0);
            while (choice != 'Y' && choice != 'y' && choice != 'N' && choice != 'n')
                System.out.println("Invalid Choice please try again :( ");
            if (choice == 'Y' || choice == 'y')
                SearchForUser();
            else viewUserFeed();
        }
        Searched_User_Menu(New_User);
    }

    public void See_Friendship(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String relation = new String();
        try {
            relation = reader.readLine(); // Read a line of text from the console
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        } finally {
            try {
                reader.close(); // Always close the BufferedReader when done
            } catch (IOException e) {
                System.out.println("Error closing reader: " + e.getMessage());
            }
        }
        if ((relation.indexOf("&") == -1 && relation.indexOf("+") == -1) || relation.indexOf("&") == 0 || relation.indexOf("+") == 0) {
            System.out.println("Please Enter a valid relation!");
            See_Friendship();
        }
        int index_of_and = relation.indexOf("&"), index_of_plus = relation.indexOf("+");
        int index_of_split = 0;
        if (index_of_and != -1) index_of_split = index_of_and;
        else if (index_of_plus != -1) index_of_split = index_of_plus;
        // to handle the usernames
        String first_user = "", second_user = "";
        for (int i = 0; i < index_of_split; i++) {
            if (relation.charAt(i) == ' ')
                continue;
            first_user += relation.charAt(i);
        }
        for (int i = index_of_split + 1; i < relation.length(); i++){
            if (relation.charAt(i) == ' ')
                continue;
            second_user += relation.charAt(i);
        }
        User First_User = GetUserData(first_user);
        User Second_User = GetUserData(second_user);
        if (First_User == null || Second_User == null){
            System.out.println("One/Two of the usernames you entered was/were not found. PLease try again :( ");
            See_Friendship();
        }
        if (index_of_split == index_of_and)
            Get_Mutual_Posts(First_User, Second_User);
        else Get_Mutual_Friends(First_User, Second_User);
    }
    public void ViewProfile(User friend){
        //Display all user data:
        System.out.println("The User\'s Name is: " + friend.getName());
        System.out.println("The User\'s Email is: " + friend.getEmail());
        System.out.println("The User\'s Gender is: " + friend.getGender());
        System.out.println("The User\'s Birth Date is: " + friend.getBirthdate());
        System.out.println("The User\'s Phone Number is: " + friend.getPhoneNumber());
        //Display posts & friends
    }
    public void Searched_User_Menu (User Searched_User){
        System.out.println("1. View Profile");
        System.out.println("2. Check Friendship");
        System.out.print("Enter a choice :");
        int choice =0;
        Boolean validate=new Boolean(false);

        while(!validate) {
            try {
                choice=in.nextInt();
                validate=true;
            } catch (InputMismatchException e) {
                System.out.println("invaild choice try again");
                System.out.print("Enter a choice :");
                in.nextLine();
            }
        }
        switch (choice){
            case 1:
                ViewProfile(Searched_User);
                break;
            case 2:
                boolean A_Friend = Check_Friendship(Searched_User);
                if (A_Friend) {
                    System.out.println("You are Friends :)");
                    Friend_Menu (Searched_User);
                }
                if (!A_Friend){
                    System.out.println("You are not Friends :(");
                    Not_Friend_Menu(Searched_User);
                }
                break;
            default:
                System.out.println("Invalid Choice please try again :( ");
                Searched_User_Menu(Searched_User);
        }
        viewUserFeed();
    }
    public void friendsofme(){
        System.out.println("1.enter any of a friend account\n2.back to feed");
        Boolean validate=new Boolean(false);

        int choice = 0;
        while(!validate) {
            try {
                choice=in.nextInt();
                validate=true;
            } catch (InputMismatchException e) {
                System.out.println("invaild choice try again");
                System.out.print("Enter a choice :");
                in.nextLine();
            }
        }
        switch (choice){
            case 1:
                for (User friend:user.getFriends()) {
                    System.out.println(friend.getUserName());
                }
                System.out.println("enter your friend name");
                String friendName = in.next();
                for (User friend : user.getFriends()) {
                    if (friendName.equals(friend.getUserName())) {
                        Friend_Menu(friend);
                        break;
                    }
                }
                break;
            case 2:
                viewUserFeed();
                break;
            default:
                System.out.println("invalid input");
                friendsofme();
        }
        viewUserFeed();
    }
    public void Friend_Menu (User Friend){
        System.out.println("1. Remove Friend");
        System.out.println("2. See Mutual Friends");
        System.out.println("3. See Mutual Posts");
        System.out.println("4. Add A Role (Regular/Restricted)");
        System.out.println("5. View Role (Regular/Restricted)");
        System.out.print("Enter a choice :");
        int choice = 0;
        Boolean validate=new Boolean(false);
        while(!validate) {
            try {
                choice=in.nextInt();
                validate=true;
            } catch (InputMismatchException e) {
                System.out.println("invaild choice try again");
                System.out.print("Enter a choice :");
                in.nextLine();
            }
        }
        switch (choice){
            case 1:
                RemoveFriend(Friend);
                break;
            case 2:
                Get_Mutual_Friends(user, Friend);
                break;
            case 3:
                Get_Mutual_Posts(user, Friend);
                break;
            case 4:
                Add_Role_Of_a_Friend(Friend);
                break;
            case 5:
                FriendShip f= FriendShip.getFriendship(user,Friend);
                if (!f.see_role(Friend))
                    System.out.println("This friend is restricted");
                else  System.out.println("This friend is regular");
            default:
                System.out.println("Invalid Choice please try again :( ");
                Friend_Menu(Friend);
        }
        viewUserFeed();
    }

    public void Not_Friend_Menu (User Friend){
        System.out.println("1. Add Friend");
        System.out.println("2. See Mutual Friends");
        System.out.print("Enter a choice :");
        int choice = 0;
        Boolean validate=new Boolean(false);

        while(!validate) {
            try {
                choice=in.nextInt();
                validate=true;
            } catch (InputMismatchException e) {
                System.out.println("invaild choice try again");
                System.out.print("Enter a choice :");
                in.nextLine();
            }
        }
        switch (choice){
            case 1:
                sendFriendRequest(Friend);
                break;
            case 2:
                Get_Mutual_Friends(user, Friend);
                break;
            default:
                System.out.println("Invalid Choice please try again :( ");
                Friend_Menu(Friend);
        }
        viewUserFeed();
    }
    public void sendFriendRequest(User friend) {
        FriendShip friendShip= new FriendShip(user,friend);
        FriendRequest notifi =new FriendRequest(user,friend,friendShip);
        friend.setFriendRequest(notifi);
        System.out.println("Friend request sent to " + friend.getUserName());
    }

    public void RemoveFriend(User Friend_User){
        user.RemoveFriend(Friend_User);
        Friend_User.RemoveFriend(user);
        FriendShip f = FriendShip.Remove_Friendship(Friend_User, user);
    }
    public static User GetUserData(String username) {
        for (User Targeted : Main.vec) {
            if (Targeted.getUserName().equals(username)) {
                return Targeted;
            }
        }
        return null;
    }
    public void Add_Role_Of_a_Friend(User friend) {
        FriendShip friendShip = FriendShip.getFriendship(user, friend);
        System.out.println("Choose a role to add to this friend (Regular(1)/Restricted(0)");
        int choice = 0;
        Boolean validate=new Boolean(false);

        while(!validate) {
            try {
                choice=in.nextInt();
                validate=true;
            } catch (InputMismatchException e) {
                System.out.println("invaild choice try again");
                System.out.print("Enter a choice :");
                in.nextLine();
            }
        }
        switch(choice) {
            case 1:
                friendShip.setFriendship_Role(1,friend);
                break;
            case 0:
                friendShip.setFriendship_Role(0,friend);
                break;
            default:
                System.out.println("Invalid Choice please try again :( ");
                Add_Role_Of_a_Friend(friend);
        }
    }

    public void Get_Mutual_Posts(User First_User, User Second_User) {
        FriendShip A_Friendship = FriendShip.getFriendship(First_User, Second_User);
        boolean IsTherePosts= new Boolean(false);
        if (A_Friendship != null) {
            for (Post post : A_Friendship.getMutual_Posts()) {
                post.Expandpost(First_User);
                IsTherePosts = true;
            }
            if (!IsTherePosts)
                System.out.println("There are no mutual posts");
        }

        else System.out.println("There are no mutual posts between these two users because they are not friends! ");
        System.out.println("=======================================================================================");
    }

    public void Get_Mutual_Friends(User First_User, User Second_User){
        ArrayList<User> friendsList1 = First_User.getFriends();
        ArrayList<User> friendsList2 = Second_User.getFriends();
        // Convert the lists to sets for faster membership tests
        Set<User> set1 = new HashSet<>(friendsList1);
        Set<User> mutualFriends = new HashSet<>();
        // Iterate through the second list and check for mutual friends
        for (User friend : friendsList2) {
            if (set1.contains(friend)) {
                mutualFriends.add(friend);
            }
        }
        // Convert the set of mutual friends back to a list
        ArrayList<User> Mutual = new ArrayList<>(mutualFriends);
        if(Mutual.size()>0) {
            System.out.println("Mutual friends are: ");
            for (User Friend : Mutual) {
                System.out.println(Friend.getUserName());
            }
        }
        else{
            System.out.println("there is no mutual friends between both of u");
        }
    }


    public boolean Check_Friendship(User Friend) {
        if(user.Friends.contains(Friend))
                return true;
        return false;
    }
    //=============================================don't touch=======================================================================
    public void showposts ( int counter){
        if (counter > FeedPosts.size()) {
            counter = 0;
        }
        for (int i = 0; i < 3 && FeedPosts.size() > (i + counter); i++) {
            Post post = FeedPosts.get(i + counter);
            System.out.println(i + 1 + "." + post.getAuthor());
            System.out.println(post.getContent().substring(0, 50));
            long p = post.GetPostTimeInMin();
            if (p > 60) {
                System.out.print("since " + post.GetPostTimeInHours() + "h     ");
            } else {
                System.out.print("since " + post.GetPostTimeInMin() + "min  ");
            }
            System.out.print(post.getReacts() + "likes    ");
            System.out.print(post.getAllComments().size() + "comments");
            System.out.println("==================================================");
        }
    }
    public void ViewFeed () {
        //evaluatePosts();
        int counter = 0;
        Boolean checker = new Boolean(true);
        if (FeedPosts.isEmpty()){
            System.out.println("there is no posts in the feed ");
            viewUserFeed();
        }
        showposts(counter);
        while (checker) {
            System.out.println("If you want to expand post Enter the number of the post");
            System.out.println("4.Next posts");
            System.out.println("5.Return to main");
            System.out.print("Enter your choice : ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    FeedPosts.get(counter).Expandpost(user);
                    break;
                case 2:
                    FeedPosts.get(counter + 1).Expandpost(user);
                    break;
                case 3:
                    FeedPosts.get(counter + 2).Expandpost(user);
                    break;
                case 4:
                    counter += 3;
                    if (counter > FeedPosts.size())
                        counter = 0;//no post to show
                    showposts(counter);
                    break;
                case 5:
                    checker = false;
                    break;
                default:
                    System.out.println("invalid choice");
                    ViewFeed();

            }

            //counter+=3;
        }
        viewUserFeed();
    }

    public void evaluatePosts () {
        for (User userd : user.getFriends()) {
            FriendShip f = FriendShip.getFriendship(user, userd);
            //need to edit
            if (!f.see_role(userd)) {
                continue;
            } else {
                for (Post post : userd.getAllPosts()) {
                    int score = 0;
                    score += Post.getTimeScore(post.GetPostTimeInHours());
                    score += post.getReacts() * 1;
                    score += post.getNumberOfComments() * 2;
                    score += f.getRelationScore();
                    if (score >= 10) {
                        FeedPosts.add(post);
                    }
                }
            }

        }
    }
    //==================================================================================

}