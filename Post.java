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
// add atribute privacy ya haneen
    //////////////////////////////////////////**CONSTRUCTORS**///////////////////////////////////////////
    public Post() {
        super(Id++);
        this.taggedUsers = new ArrayList<>();
    }
    ////////////////////////////////////////////**METHODS**//////////////////////////////////////////

    @Override
    public int getCntReacts() {
        return cntReacts;
    }

    public void addReact(Post post) {
        post.cntReacts++;
    }

//    public void  addTaggedUser(USER taggedUsers){
//        //friends ? -> privacy (addPost in user -> go back to the friendship to check the status )
//        taggedUsers.addPost();
//    }
//    public List<USER> getTaggedUsers() {
//        return taggedUsers;
//    }
//    public void AddComment(Comments comment){
//
//       comment.addComment();
//    }
//    public List<Comment> getComment(){
//        return comments;
//    }
//    public String SetPrivacy (){} // --> status of friends privacy of post
//    //addpost


}
