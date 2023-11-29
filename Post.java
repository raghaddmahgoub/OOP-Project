import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post extends Text {
    private static int Id;
    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    private LocalDateTime timestamp;
    private List<User> taggedUsers;
    // private Fiendship fiendship ;
    // private List<Comment> comments;

    //////////////////////////////////////////**CONSTRUCTORS**///////////////////////////////////////////
    public Post() {
        super(Id++);
        this.taggedUsers = new ArrayList<>();
    }
    ////////////////////////////////////////////**METHODS**//////////////////////////////////////////

    public void addReact(Post post) {
        post.cntReacts++;
    }

    public int getReact() {
        return cntReacts;
    }
//    public void  addTaggedUser(USER taggedUsers){
//        taggedUsers.addPost();
//    }
//    public List<USER> getTaggedUsers() {
//        return taggedUsers;
//    }
//    public void AddComment(Comments comment){
//       comment.addComment();
//    }
//    public List<Comment> getComment(){
//        return comments;
//    }



}
