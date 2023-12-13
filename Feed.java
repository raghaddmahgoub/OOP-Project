import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Feed {
    static Scanner in = new Scanner(System.in);

    ArrayList <String> Notifications = new ArrayList<>();
    User  user;


    UserDashBoard dashboard;
    public Feed(User user){
        this.user = user;
        viewUserFeed();
    }
   // ArrayList <Post> getALLposts = user.getPosts();
      public void viewUserFeed(){
            System.out.println("1- View Posts");
            System.out.println("2- View Your Notifications");
            System.out.println("3- View Your Friends Menu");
            System.out.println("4- View Your Dashboard");
            System.out.println("5- Add Post");
            System.out.println("6- view Posts");
            System.out.println("7- Sign Out");
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Posts");
                    break;
                case 2:
                    viewNotifications();
                    break;
                case 3:
                    System.out.println("Friends");
                    break;
                case 4:
                    dashboard = new UserDashBoard(user);
                    break;
                case 5:
                    //addPost();
                    break;
                case 6:
                    //ViewPosts();
                    break;
                case 7 :
                    UserInterface.ProgramStart();
            }
        }
        void viewNotifications()
        {
            System.out.println ("Notifications");
            for (String Notification : Notifications)
            {
                System.out.println(Notification);
            }
        }
     /*   void ViewPosts()
        {
            System.out.println ("Posts");
            for (Post Posts : getALLposts)
            {
                System.out.println(Posts);
            }
        }*/

    //    public void likeComments(Comment comment){
//        comment.addReaction();
//    }
//    public void likeReply(Reply reply){
//        reply.addReact();
//    }

    /*    public void editPost(Post post){
            String edittedContent= in.next();
            post.setContent(edittedContent);
        }
        public void addPost(){
            System.out.println("enter the content of the post");
            Post post = new Post();
            String content= in.next();
            post.setContent(content);
            System.out.println("do you want to tag a friend ? y or n");
            char choice = in.next().charAt(0);
            if (choice=='y'||choice=='Y' ){
                addTaggedUser(post);
            }
            System.out.println("want to set privacy ? y or n");
            char ch = in.next().charAt(0);
            if (ch=='y'||ch=='Y' ){setPostPrivacy(post);}
            System.out.println("post added");
            user.addApost(post);
            viewUserFeed();
        }
        public void addTaggedUser(Post post) {
            for (User friendlist:user.Friends) {
                System.out.println(friendlist.getUserName());
                System.out.println('\n');
            }
            System.out.println("enter your friend name");
            String friendName=in.next();
            for (User friend:user.Friends) {
                if(friendName.equals(friend.getUserName())) {
                    post.TagUser(friend);
                    System.out.println("tagged friends done");
                }
                else {
                    System.out.println("invalid name");
                    addTaggedUser(post);
                }
            }
        }
        public void setPostPrivacy(Post post){

            System.out.println("for public press 1 \n for private press 2 for default press 3");
            int privacy = in.nextInt();
            switch (privacy){
                case 1: post.setPrivacy("public"); break;
                case 2: post.setPrivacy("private"); break;
                case 3: post.setPrivacy(user.getUserPrivacy()); break;
                default:
                    System.out.println("invalid input");
                    setPostPrivacy(post);
            }
        }*/
    /*public void sendMessage (String content){
        Messages newMessage = new Messages ();
        newMessage.setContent(content);
     }*/
    public void SearchForUser() {
        String UserName = in.next();
        User New_User = GetUserData(UserName);
        if (New_User == null){
            System.out.println("The username you entered was not found. PLease try again :( ");
            SearchForUser();
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
        User First_User=GetUserData(first_user);
        User Second_User=GetUserData(second_user);
        if (First_User == null || Second_User == null){
            System.out.println("One/Two of the usernames you entered was/were not found. PLease try again :( ");
            See_Friendship();
        }
        if (index_of_split == index_of_and)
            Get_Mutual_Posts(First_User, Second_User);
        else Get_Mutual_Friends(First_User, Second_User);
    }
    public void ViewProfile(){
        //Display all user data:
/*      System.out.println("The User\'s Name is: " + Name);
        System.out.println("The User\'s Email is: " + Email);
        System.out.println("The User\'s Gender is: " + Gender);
        System.out.println("The User\'s Birth Date is: " + Birthdate);
        System.out.println("The User\'s Phone Number is: " + PhoneNumber);
        */

        //Display posts & friends
    }
    public void Searched_User_Menu (User Searched_User){
        System.out.println("1. View Profile");
        System.out.println("2. Check Friendship");
        System.out.print("Enter a choice :");
        char choice = in.next().charAt(0);
        switch (choice){
            case 1:
                ViewProfile();
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
    }

    public void Friend_Menu (User Friend){
        System.out.println("1. Remove Friend");
        System.out.println("2. See Mutual Friends");
        System.out.println("3. See Mutual Posts");
        System.out.println("4. Add A Role (Regular/Restricted)");
        System.out.print("Enter a choice :");
        char choice = in.next().charAt(0);
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
            default:
                System.out.println("Invalid Choice please try again :( ");
                Friend_Menu(Friend);
        }
    }

    public void Not_Friend_Menu (User Friend){
        System.out.println("1. Add Friend");
        System.out.println("2. See Mutual Friends");
        System.out.print("Enter a choice :");
        char choice = in.next().charAt(0);
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
    }
    public void sendFriendRequest(User friend) {
        friend.getFriendRequests().add(user);
        System.out.println("Friend request sent to " + friend.getUserName());
        //new friendship
    }

    public void AddFriend(User New_Friend_User) {
        user.Friends.add(New_Friend_User);
    }
    public void RemoveFriend(User Friend_User){
        user.Friends.remove(Friend_User);
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
        FriendShip friendShip = new FriendShip(user, friend);
        System.out.println("Choose a role to add to this friend (Regular(1)/Restricted(0)");
        int choice = in.nextInt();
        switch(choice) {
            case 1:
                friendShip.setFriendship_Role(1);
                break;
            case 0:
                friendShip.setFriendship_Role(0);
                break;
            default:
                System.out.println("Invalid Choice please try again :( ");
                Add_Role_Of_a_Friend(friend);
        }
    }
    public void Get_Mutual_Posts(User First_User, User Second_User){
        FriendShip friendShip = new FriendShip(First_User, Second_User);
        if (friendShip.getFriendship_status() == "Accepted")
        {
            ArrayList <Post> Mutual_Posts = new ArrayList<>();
            Mutual_Posts = friendShip.getMutual_Posts();
            for (Post post: Mutual_Posts){
                //Post Data
            }
        }
        else System.out.println("There are no mutual posts between these two users because they are not friends! ");
    }
    public ArrayList<User> Get_Mutual_Friends(User First_User, User Second_User){
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
        return new ArrayList<>(mutualFriends);
    }

    public boolean Check_Friendship(User Friend) {
        for (User friend: user.getFriends())
            if (friend == Friend)
                return true;
        return false;
    }
    public void Get_Posts_By_PrivacyLevel(){
    }
}
