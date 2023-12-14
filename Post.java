
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Post extends Text {
    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    private static int Id;
    private ArrayList<User> taggedUsers = new ArrayList<User>();
    private FriendShip friendship;
    private final ArrayList<Comment> comments = new ArrayList<Comment>();

    private String privacy;
    //////////////////////////////////////////**CONSTRUCTORS**///////////////////////////////////////////
    public Post() {
        super(Id++);
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
    }

    public ArrayList<Comment> getComment() {
        return comments;
    }
}
