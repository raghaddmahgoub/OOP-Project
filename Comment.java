import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comment extends Text{
    ////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////
    private List<Reply> userReplies;
    private int counterLikes;
    private int authorID;
    private static int commentId;

    //////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////
    public Comment( int authorID, String content) {
        super(commentId++);
        this.counterLikes = 0;
        this.userReplies = new ArrayList<>();
        this.authorID = authorID;
        this.content =content;
    }

////////////////////////////////////////////METHODS//////////////////////////////////////////
   public int getAuthorID() {
    return authorID;
   }
    public void addComment(){
        Comment newComment = new Comment(authorID,content);
    }
    public void addReply(String content){
       // Reply reply= new Reply(content);
       // userReplies.add(reply);
    }
    public void addReaction(){
        counterLikes++;
    }
    public List<Reply> getUserReplies(){
        return userReplies;
    }
    /*
    public void editContent(User authorID,String newContent){
        if (authorID) {
            setContent(newContent);
            System.out.println("Comment edited");
        }
        else{
            System.out.println("cant edit");
        }
    }


    public void deleteContent(User authorID){
        if (authorID) {
            setContent(null);
            System.out.println("Comment deleted");
        }
        else{
            System.out.println("cant delete");
        }
    }
*/
    @Override
    public void addReact() {
        cntReacts++;
    }

    @Override
    public int getReacts() {
        return cntReacts;
    }
}
