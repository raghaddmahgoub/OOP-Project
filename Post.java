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

    public void addTaggedUser(User taggedUser) {
        //are they friends ? -> privacy (go back to the friendship to check the status )
        if (taggedUser.Check_Friendship(taggedUser.getName()))
         this.taggedUsers.add(taggedUser);
        else
            System.out.println("you're not friends with "+taggedUser.getName());
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
