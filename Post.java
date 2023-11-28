import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post extends Text {
<<<<<<< HEAD

    private USER taggedUser;
    // private Friendship friendship ;
=======
    private static int Id;
    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    private LocalDateTime timestamp;
    private List<USER> taggedUsers;
    // private Fiendship fiendship ;
>>>>>>> ab6fc5dfc4977f966a4b5912f357d4aa07d9963e
    // private List<Comment> comments;

<<<<<<< HEAD
    public Post(int id, int userId, String content, LocalDateTime timestamp, int cntReacts) {
        super(id, userId, content, timestamp, cntReacts);
    }

    @Override
    public void addReact(Post post, int postId) {

    }

    @Override
    public int getReact() {
        return 0;
    }

//    public Post (int Id, String username, String content){
//        super(int id, int userId, String content, LocalDateTime timestamp, int cntReacts);
//       // this.comments = new ArrayList<>();
=======
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
>>>>>>> ab6fc5dfc4977f966a4b5912f357d4aa07d9963e
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
