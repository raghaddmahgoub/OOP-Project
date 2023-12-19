import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Feed {
    static Scanner in = new Scanner(System.in);

    ArrayList <String> Notifications = new ArrayList<>();
    User  user;


    UserDashBoard dashboard;
    private String content;

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
            System.out.println("6- view Posts Me");
            System.out.println("7- Search");
            System.out.println("8- Sign Out");
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Posts");
                    Get_Posts_By_PrivacyLevel();
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
                    addPost();
                    break;
                case 6:
                    //ViewPosts();
                    break;
                case 7 :
                    SearchForUser();
                    break;
                case 8 :
                    UserInterface.ProgramStart();
                    break;
                case 9 :
                    UserInterface.ProgramStart();
                    break;
                default:
                    System.out.println("invalid choice");
                    viewUserFeed();

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

    //    public void likeComments(Comment comment){
//        comment.addReaction();
//    }
//    public void likeReply(Reply reply){
//        reply.addReact();
//    }
    //////////////////////////////////////////////////////////////POST///////////////////////////////////////////////////////////////
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
        if (user.getFriends().size()>0) {
            for (User friendlist : user.getFriends()) {
                System.out.println(friendlist.getUserName());
                System.out.println('\n');
            }
            System.out.println("enter your friend name");
            String friendName = in.next();
            for (User friend : user.getFriends()) {
                if (friendName.equals(friend.getUserName())) {
                    post.TagUser(friend);
                    //mutual posts
                    FriendShip f=FriendShip.getFriendship(friend,user);
                    f.addMutualPost(post);
                    System.out.println("tagged friends successfully\n");
                } else {
                    System.out.println("invalid name");
                    addTaggedUser(post);
                }
            }

        }
        else {
            System.out.println("you do not have friends yet");
        }
        }
        public void setPostPrivacy(Post post){
            System.out.println("for public press 1 \n for private press 2 \n for default press 3");
            int privacy = in.nextInt();
            switch (privacy){
                case 1: post.setPrivacy("public"); break;
                case 2: post.setPrivacy("private"); break;
                case 3: post.setPrivacy(user.getUserPrivacy()); break;
                default:
                    System.out.println("invalid input");
                    setPostPrivacy(post);
            }
        }
    public void Get_Posts_By_PrivacyLevel() {
        for (FriendShip friendship:user.getRelations()) {
            if(friendship.getFriendship_Role().equals("Regular")){
                for (User friend: user.getFriends()) {
                    System.out.println(friend.getPosts().get(0).getId());
                    friend.getPosts().indexOf(0);
                    System.out.println("\n");
                    System.out.println(friend.getPosts().get(1).getId());
                    friend.getPosts().indexOf(1);
                }
            }
        }
            System.out.println("do u want to access comments y or n ?");
             char choice = in.next().charAt(0);
                if (choice=='y'||choice=='Y' ){
                    System.out.println("enter the post id you would like to view comments on");
                    int postId = in.nextInt();
                   display_comments(postId);
                }
        viewUserFeed();
    }
     public Post get_post_by_id(int postId){
         for (User friend: user.getFriends()) {
             for (Post friendpost: friend.getPosts()) {
                    if (friendpost.getId()== postId){
                        return friendpost;
                    }
             }
         }
         return null;
     }

    //comments methods
   public void display_comments (int postId){
       //getArray of comments
       Post post= get_post_by_id(postId);
       for (Comment comment: post.getComments()) {
           comment.displayContent();
       }
       System.out.println("do u want to access replies y or n ?");
       char choice = in.next().charAt(0);
       if (choice=='y'||choice=='Y' ){
           System.out.println("enter the comment id you would like to view replies on");
           int commentId = in.nextInt();
           display_replies(post,commentId);
       }
       System.out.println("do you want to add a comment ? y or n");
       char c= in.next().charAt(0);
       if(c== 'y'|| c=='Y')
           addComment(user.getUserID());
       Get_Posts_By_PrivacyLevel();
    }
    public Comment get_comment_by_id(Post post, int commentId){
        for (Comment targetcomment: post.getComments()) {
                if (targetcomment.getId()==commentId)
                    return targetcomment;
        }
        return null;
    }

public void display_replies (Post post ,int commentId){

    Comment comment =get_comment_by_id(post,commentId);
    for (Reply reply :comment.getUserReplies()) {
        reply.displayContent();
    }
    System.out.println("do you want to add a reply ? y or n");
    char c= in.next().charAt(0);
    if(c== 'y'|| c=='Y')
        addReply(user.getUserID());
    Get_Posts_By_PrivacyLevel();

    Get_Posts_By_PrivacyLevel();
}
    public void addComment(int userid){
        Comment newComment = new Comment( content);
        User.comments.add(newComment);

    }
    public void addReply(int userid){
        Reply newReply= new Reply(content);
        User.replies.add(newReply);

    }
//need to add reacts to comments and replies, need to implement userId parameters in addcomment and addreply methods
//RAGHAD

    ////////////////////////////////////////////////////////////FRIENDSHIP///////////////////////////////////////////////////////////////////
    /*public void sendMessage (String content){
        Messages newMessage = new Messages ();
        newMessage.setContent(content);
     }*/
    public void SearchForUser() {
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
        System.out.println("The User\'s Name is: " + user.getName());
        System.out.println("The User\'s Email is: " + user.getEmail());
        System.out.println("The User\'s Gender is: " + user.getGender());
        System.out.println("The User\'s Birth Date is: " + user.getBirthdate());
        System.out.println("The User\'s Phone Number is: " + user.getPhoneNumber());

        //Display posts & friends
    }
    public void Searched_User_Menu (User Searched_User){
        System.out.println("1. View Profile");
        System.out.println("2. Check Friendship");
        System.out.print("Enter a choice :");
        int choice = in.nextInt();
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
        viewUserFeed();
    }

    public void Friend_Menu (User Friend){
        System.out.println("1. Remove Friend");
        System.out.println("2. See Mutual Friends");
        System.out.println("3. See Mutual Posts");
        System.out.println("4. Add A Role (Regular/Restricted)");
        System.out.print("Enter a choice :");
        int choice = in.nextInt();
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
        int choice = in.nextInt();
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
        FriendShip friendShip = FriendShip.getFriendship(user, friend);
        System.out.println("Choose a role to add to this friend (Regular(1)/Restricted(0)");
        int choice = in.nextInt();
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

        Pair Searched_Users_IDs = new Pair(First_User.getUserID(), Second_User.getUserID());
        for (FriendShip friendship : Main.friendship) {
            if (friendship.getUser_IDs() == Searched_Users_IDs && friendship.getFriendship_status().equals("Accepted")) {
                for (Post post : friendship.getMutual_Posts()) {
                    //Post Data
                }

                FriendShip A_Friendship = FriendShip.getFriendship(First_User, Second_User);
                if (A_Friendship != null) {
                    for (Post post : A_Friendship.getMutual_Posts()) {
                        //Post Data

                    }
                } else
                    System.out.println("There are no mutual posts between these two users because they are not friends! ");
            }
        }
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
}

