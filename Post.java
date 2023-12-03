import java.time.LocalDateTime;
import java.util.ArrayList;

public class Post extends Text {
    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    private static int Id;
    private ArrayList<User> taggedUsers = new ArrayList<User>();
    private FriendShip fiendship;
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

    public void setPrivacy(User poster) {
        this.privacy = poster.getUserPrivacy();
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

    public void addTaggedUser(User taggedUsers) {
//        //friends ? -> privacy (addPost in user -> go back to the friendship to check the status )
        this.taggedUsers.add(taggedUsers);
    }

    public ArrayList<User> getTaggedUsers() {
        return taggedUsers;
    }

    public void addComment(User commenter , String content){
//       Comment comment= new Comment(commenter.getUserID(),);
//       this.comments.add(comment);
    }

    public ArrayList<Comment> getComment() {
        return comments;
    }


}
