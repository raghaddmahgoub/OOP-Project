import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Post extends Text {

    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    private static int Id;
    Scanner in =new Scanner(System.in);
    private ArrayList<User> taggedUsers = new ArrayList<User>();
    private FriendShip friendship;
    private final ArrayList<Comment> comments = new ArrayList<Comment>();

    private String privacy;
    private int NumberOfComments=0;
    public int Score=0;
    //////////////////////////////////////////**CONSTRUCTORS**///////////////////////////////////////////
    public Post() {
        super(Id++);
    }
    ////////////////////////////////////////////**GETTERS**//////////////////////////////////////////
    @Override
    public int getId() {
        return Id;
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
    public void addTaggedUser(Post post) {
        if (author.getFriends().size()>0) {
            for (User friendlist : author.getFriends()) {
                System.out.println(friendlist.getUserName());
                System.out.println('\n');
            }
            System.out.println("enter your friend name");
            String friendName = in.next();
            for (User friend : author.getFriends()) {
                if (friendName.equals(friend.getUserName())) {
                    this.taggedUsers.add(friend);
                    friend.addNotifiObject(new Postnotification(post,author));
                    //mutual posts
                    FriendShip f=FriendShip.getFriendship(friend,author);
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
            case 1: this.privacy ="public"; break;
            case 2: this.privacy ="private"; break;
            case 3: this.privacy =author.getUserPrivacy(); break;
            default:
                System.out.println("invalid input");
                setPostPrivacy(post);
        }
    }

    public void addComment(){
        System.out.println("enter what your want to write in a comment");
        String cont=in.next();
        Comment comment= new Comment(cont);
        this.comments.add(comment);
        Post post =author.getPost(getId());
        User commenter= comment.getAuthor();
        author.addNotifiObject(new Postnotification(post,commenter));
        System.out.println("your comment added");
    }
    public void addReply(int commentId){

//        Post post =author.getPost(getId());
//        User liker= getComment(replyId).getAuthor();
//        author.addNotifiObject(new Postnotification(post,liker));

    }
    //////////////////////////////////////////**METHODS**////////////////////////////////////////////////
    public void Expandpost(){
        System.out.println(getAuthor().getUserName());
        System.out.println("since "+GetPostTimeInHours());
        displayContent();
        if (taggedUsers.size()>0){
            System.out.println("tagged friends are: ");
            System.out.println(getTaggedUsers());
        }
        System.out.println("number of reacts: ");
        System.out.println(getReacts());
        System.out.println("number of comments: "+comments.size());
        System.out.println("do u want to view comments ? y or n ");
        if (in.next().charAt(0)=='y'||in.next().charAt(0)=='Y' ){
            display_comments();
        }
    }
    public void display_comments (){
        //getArray of comments
            for (Comment comment: getAllComments()) {
                System.out.println("comment id: "+comment.getId());
                comment.displayContent();
                System.out.println("reacts: "+comment.getReacts());
        }
        System.out.println("do u want to like a comment ? y or n ");
        if (in.next().charAt(0)=='y'||in.next().charAt(0)=='Y' ){
            System.out.println("enter the comment id you want to like");
            int commentId = in.nextInt();
           getComment(commentId).addReact();
           //////////////////////////
            Post post =author.getPost(getId());
            User liker= getComment(commentId).getAuthor();
            author.addNotifiObject(new Postnotification(post,liker));
            ////////////////////////////
            System.out.println("like added");
            getComment(commentId).displayContent();
            System.out.println("number of likes: "+getComment(commentId).getReacts());
        }
        System.out.println("do u want to access replies ? y or n ");
        if (in.next().charAt(0)=='y'||in.next().charAt(0)=='Y' ){
            System.out.println("enter the comment id you would like to view replies on");
            int commentId = in.nextInt();
            display_replies(commentId);
        }
        System.out.println("do you want to add a comment ? y or n");
        if(in.next().charAt(0)== 'y'|| in.next().charAt(0)=='Y')
            addComment();
    }
    public void display_replies (int commentId){

//        Comment comment =get_comment_by_id(post,commentId);
        for (Reply reply :getComment(commentId).getUserReplies()) {
            reply.displayContent();
        }
        //do u want to add reply ?
        //do u want to like a  reply ?
//=============================dont touch===========================
//        Post post =author.getPost(getId());
//        User liker= getComment(replyId).getAuthor();
//        author.addNotifiObject(new Postnotification(post,liker));
//==========================================================================
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
