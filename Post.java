import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post extends Text {
    private static int Id;
    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    private LocalDateTime timestamp;
    private List<USER> taggedUsers;
    // private List<Reply> replies;
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
//    public void AddReply(Reply reply){
//       reply.addReply();
//    }
//    public List<Reply> getReply(){
//        return replies;
//    }


}
