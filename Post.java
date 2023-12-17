
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;


public class Post extends Text {
    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    private static int Id;
    private ArrayList<User> taggedUsers = new ArrayList<User>();
    private FriendShip friendship;
    private final ArrayList<Comment> comments = new ArrayList<Comment>();
    private String Author;
    private int NumberOfComments=0;
    public int Score=0;
    private String privacy;
    //////////////////////////////////////////**CONSTRUCTORS**///////////////////////////////////////////
    public Post() {
        super(Id++);
    }

    public String getAuthor() {
        return Author;
    }

    public Post(String content) {
        super(content);
    }
    ////////////////////////////////////////////**METHODS**//////////////////////////////////////////
    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    @Override
    public int getReacts() {
        return cntReacts;
    }

    public void addReact() {
        cntReacts++;
    }

    public void TagUser(User taggedUser) {
         this.taggedUsers.add(taggedUser);
    }

    public ArrayList<User> getTaggedUsers() {
        return taggedUsers;
    }

    public void addComment(User commenter , String content){
        Comment comment= new Comment(commenter.getUserID(),content);
        this.comments.add(comment);
        NumberOfComments++;
    }
    public  int getNumberOfComments() {
        return NumberOfComments;
    }
    public void Expandpost(){
        System.out.println(Author);
        displayContent();


    }

    public ArrayList<Comment> getComment() {
        return comments;
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
