import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Post extends Text {

    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    private static int Id=0;
    private int postId;

    Scanner in =new Scanner(System.in);
    private ArrayList<User> taggedUsers = new ArrayList<User>();
    //private FriendShip friendship;
    private final ArrayList<Comment> comments = new ArrayList<Comment>();

    private String privacy;

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setTaggedUsers(ArrayList<User> taggedUsers) {
        this.taggedUsers = taggedUsers;
    }

    public void setNumberOfComments(int numberOfComments) {
        NumberOfComments = numberOfComments;
    }

    private int NumberOfComments=0;
    public int Score=0;
    //////////////////////////////////////////**CONSTRUCTORS**///////////////////////////////////////////
    public Post() {
        timestamp=Timestamp.valueOf(LocalDateTime.now());
        postId=Id;
        Id++;
        //setTimestamp(t);
    }
    ////////////////////////////////////////////**GETTERS**//////////////////////////////////////////
    @Override
    public int getId() {
        return postId;
    }
    public String getPrivacy() {
        return privacy;
    }
    @Override
    public int getReacts() {
        return cntReacts;
    }
    public ArrayList<User> getTaggedUsers() {
        return taggedUsers;
    }
    public ArrayList<Comment> getAllComments() {
        return comments;
    }
    public Comment getComment(int commentId) {
        return getAllComments().get(commentId);
    }
    public  int getNumberOfComments() {
        return NumberOfComments;
    }
    ////////////////////////////////////////////**SETTERS**//////////////////////////////////////////
    public void addReact() {
        cntReacts++;
    }

    public void addtaggedUsers(User user){
        taggedUsers.add(user);
    }

    public void add_comment(Comment com){
        comments.add(com);
    }
    public void addTaggedUser(Post post) {
        if (author.getFriends().size()>0) {
            for (User friendlist : author.getFriends()) {
                System.out.println(friendlist.getUserName());
            }
            System.out.println("enter your friend name");
            String friendName = in.next();
            Boolean checker;
            checker = new Boolean(false);
            for (User friend : author.getFriends()) {
                if (friendName.equals(friend.getUserName())) {
                    this.taggedUsers.add(friend);
                    Postnotification not=new Postnotification(post,friend);
                    not.setContent("tagged");
                    friend.addPostNotifiObject(not);
                    //mutual posts
                    checker=true;
                    FriendShip f=FriendShip.getFriendship(friend,author);
                    assert f != null;
                    f.addMutualPost(post);
                    System.out.println("tagged friends successfully\n");
                }
            }
            if (checker==false){

                System.out.println("invalid name");
                addTaggedUser(post);}

        }
        else {
            System.out.println("you do not have friends yet");
        }
    }
    public void setPostPrivacy(Post post){
        System.out.println("for public press 1 \n for private press 2 \n for default press 3");
        Boolean validate=new Boolean(false);
        int choice=0;
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
            case 1: this.privacy ="public"; break;
            case 2: this.privacy ="private"; break;
            case 3: this.privacy =post.author.getUserPrivacy(); break;
            default:
                System.out.println("invalid input");
                setPostPrivacy(post);
        }
    }

    public void addComment(User commenter,Post post){
        System.out.println("enter what your want to write in a comment");
        String cont=in.next();
        Comment comment= new Comment(cont);
        post.comments.add(comment);
        comment.setAuthor(commenter);
        Postnotification postnotification=new Postnotification(post,commenter);
        postnotification.setContent("commented");
        commenter.addPostNotifiObject(postnotification);
        System.out.println("your comment added");
        System.out.println("======================================================================================");
        post.display_comments(commenter,post);

    }
    public void addReply(int commentId,User replier,Post post){
        System.out.println("enter the reply content");
        String content = in.next();
        Reply newReply= new Reply(content);
        post.getComment(commentId).addReply(newReply);
        System.out.println("your reply added");
        System.out.println("======================================================================================");
        newReply.setAuthor(replier);;
        Postnotification postnotification=new Postnotification(post,replier);
        postnotification.setContent("replied");
        replier.addPostNotifiObject(postnotification);
    }
    //////////////////////////////////////////**METHODS**////////////////////////////////////////////////
    public void Expandpost(User friend,Post post){
        System.out.println(getAuthor().getUserName());
        System.out.println("since "+GetPostTimeInHours());
        post.displayContent();
        if (post.taggedUsers.size()>0){
            System.out.println("tagged friends are: ");
            for (User user:getTaggedUsers()) {
                System.out.println(user.getUserName());
            }
        }
        System.out.println("number of reacts: ");
        System.out.println(getReacts());
        System.out.println("number of comments: "+post.comments.size());
        System.out.println("1. like the post\n2. view comments\n3. add comment\n4. return to feed");
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
                addReact();
                System.out.println("your like is added");
                System.out.println("total reacts on this post: "+post.getReacts());
                Postnotification postnotification= new Postnotification(post.author.getPost(postId),friend);
                postnotification.setContent("liked");
                friend.addPostNotifiObject(postnotification);
                post.Expandpost( friend, post);
                System.out.println("======================================================================================");
                break;
            case 2:
                post.display_comments(friend,post);
                post.Expandpost( friend, post);
                break;
            case 3:
                post.addComment(friend,post);
                Expandpost( friend, post);
                break;
            case 4: break;
            default:
                System.out.println("invalid input");
                post.Expandpost(friend,post);
        }
    }
    public void display_comments (User friend,Post post){
        if(post.getAllComments().size()>0) {
            for (Comment comment : post.getAllComments()) {
                System.out.println("comment id: " + comment.getId());
                comment.displayContent();
                System.out.println("reacts: " + comment.getReacts());
            }
            System.out.println("1.add comment\n2. like a comment\n3. view replies on a comment\n4.add a reply on a comment\n5.exit");
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
                    post.addComment(friend,post);
                    display_comments ( friend, post);
                    break;
                case 2:
                    System.out.println("enter the comment id you want to like");
                    int commentId=0;
                    while (true) {
                        String input = in.next();
                        if (!input.matches("[0-9]+")) {
                            System.out.println("comment id should contain digits only. Please try again.");
                        }
                        else {
                            commentId = Integer.parseInt(input);
                            break; // Exit the loop if the input contains only digits
                        }
                        if (!getAllComments().contains(commentId)) {
                            System.out.println("Invalid comment ID. Please enter a valid comment ID.");
                        } else {
                            break; // Exit the loop if the input is valid
                        }
                    }
                    post.getComment(commentId).addReact();
                    User liker = post.getComment(commentId).getAuthor();
                    Postnotification postnotification = new Postnotification(post, liker);
                    postnotification.setContent("liked");
                    author.addPostNotifiObject(postnotification);
                    System.out.println("like added");
                    getComment(commentId).displayContent();
                    System.out.println("number of likes: " + post.getComment(commentId).getReacts());
                    System.out.println("======================================================================================");
                    post.display_comments(friend,post);
                    break;
                case 3:
                    System.out.println("enter the comment id you would like to view replies on");
                    int enteredCommentId=0;
                    while (true) {
                        String input = in.next();

                        if (!input.matches("[0-9]+")) {
                            System.out.println("comment id should contain digits only. Please try again.");

                        }
                        else {
                            enteredCommentId = Integer.parseInt(input);
                            break; // Exit the loop if the input contains only digits
                        }
                        if (!getAllComments().contains(enteredCommentId)) {
                            System.out.println("Invalid comment ID. Please enter a valid comment ID.");
                        } else {
                            break; // Exit the loop if the input is valid
                        }
                    }
                    post.display_replies(enteredCommentId,friend,post);
                    System.out.println("======================================================================================");
                    post.display_comments ( friend, post);
                    break;
                case 4:
                    System.out.println("enter the comment id you would like to add replies to");
                    int commId = 0;
                    while (true) {
                        String input = in.next();

                        if (!input.matches("[0-9]+")) {
                            System.out.println("comment id should contain digits only. Please try again.");

                        }
                        else {
                            commId = Integer.parseInt(input);
                            break; // Exit the loop if the input contains only digits
                        }
                        if (!getAllComments().contains(commId)) {
                            System.out.println("Invalid comment ID. Please enter a valid comment ID.");
                        } else {
                            break; // Exit the loop if the input is valid
                        }
                    }
                    post.addReply(commId,friend,post);
                    post.display_comments ( friend, post);
                    break;
                case 5:break;
                default:
                    System.out.println("invalid input");
                    post.display_comments(friend,post);
            }
        }
        else
            System.out.println("there is no comments on this post yet");
        }

    public void display_replies (int commentId,User friend,Post post){
        if (getComment(commentId).getUserReplies().size()>0){
            for (Reply reply : post.getComment(commentId).getUserReplies()) {
                System.out.println("reply id: "+reply.getId());
                reply.displayContent();
                System.out.println("number of reacts: "+reply.getReacts());
            }

        System.out.println("1. like a reply\n2. add reply\n3. exit");
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
        switch (choice) {
            case 1:
                System.out.println("enter the reply id you want to like: ");
                int replyId = 0;
                while (true) {
                    String input = in.next();

                    if (!input.matches("[0-9]+")) {
                        System.out.println("reply id should contain digits only. Please try again.");

                    } else {
                        replyId = Integer.parseInt(input);
                        break; // Exit the loop if the input contains only digits
                    }
                    if (!getComment(commentId).getUserReplies().contains(replyId)) {
                        System.out.println("Invalid reply ID. Please enter a valid comment ID.");
                    } else {
                        break; // Exit the loop if the input is valid
                    }
                }
                Reply reply = post.getComment(commentId).getReply(replyId);
                reply.addReact();
                System.out.println("like added");
                System.out.println(reply.getContent());
                System.out.println("number of reacts: "+reply.getReacts());
                /////////send notifi
                User liker = reply.getAuthor();
                Postnotification postnotification = new Postnotification(post, liker);
                postnotification.setContent("liked");
                post.author.addPostNotifiObject(postnotification);
                post.display_replies ( commentId, friend, post);
                break;
            case 2:
                post.addReply(commentId,friend,post);
                post.display_replies ( commentId, friend, post);
                break;
            case 3: break;
            default:
                post.display_replies(commentId,friend,post);
        }
        }
         else{
                System.out.println("this comment has no replies yet");
            }
    }
    //===omar=====================Don't touch====================================
    public long GetPostTimeInHours (){
        Timestamp t=Timestamp.valueOf(LocalDateTime.now());
        long x=t.getTime()-timestamp.getTime();
        x=x/3600000;
        return x;
    }
    public long GetPostTimeInMin (){
        Timestamp t=Timestamp.valueOf(LocalDateTime.now());
        long x=t.getTime()-timestamp.getTime();
        x=x/60000;
        return x;
    }
    public static int getTimeScore (long x) {
        if (x >= 72) {
            return -50;
        } else if (x >= 48) {
            return 2;
        } else if (x >= 24) {
            return 3;
        } else if (x >= 12) {
            return 4;
        } else if (x >= 6) {
            return 5;
        } else if (x >= 3) {
            return 6;
        } else if (x >= 1) {
            return 7;
        } else {
            return 8;
        }
    }
    public static Comparator<Post> ScoreComparator =new Comparator<Post>() {
        @Override
        public int compare(Post o1, Post o2) {
            int Score1 =o1.Score;
            int Score2 =o2.Score;
            return Score2-Score1;
        }
    };
    //====================================================================
}
