import java.time.LocalDateTime;

public class Post extends Text {

    private USER taggedUser;
    // private Friendship friendship ;
    // private List<Comment> comments;
private LocalDateTime timestamp;

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
//    }
//
//    public void   addReact( Post post , int postId){
//    post.cntReacts++;
//    }
//    public  int getReact(){
//    return cntReacts;
//    }
//    public void  addTaggedUser(){}
//    public String AddComment(){}
//    public getComments(){}
//    public  getPrivacyLevel()


}
