import java.time.LocalDateTime;
import java.util.List;

public class Comment extends Text{

    private List<Reply> userReplies;
    private int counterLikes;
    private USER authorID;


    public Comment(int id, int userId, String content, LocalDateTime timestamp, int cntReacts, List<Reply> userReplies) {
        super(id, userId, content, timestamp, cntReacts);
        this.userReplies = userReplies;
    }

    public void addComment(){

    }
    public void addReply(Reply reply){
    userReplies.add(reply);
    }
    public void addReaction(){
    counterLikes++;
    }
    public List<Reply> getUserReplies(){
    return userReplies;
    }
    public void editContent(String newContent){

    }
    public void deleteContent(){

    }
    public void getReaction(){

    }
    public String getContent(){

        return null;
    }
    @Override
    public void addReact(Post post, int postId) {

    }

    @Override
    public int getReact() {
        return 0;
    }
}
