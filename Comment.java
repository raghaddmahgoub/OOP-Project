import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comment extends Text{
    ////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////
    private List<Reply> userReplies;
    private int counterLikes;
    private static int commentId;

    //////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////
    public Comment( String content) {
        super(commentId++);
        this.counterLikes = 0;
        this.userReplies = new ArrayList<>();
        this.content =content;

    }

////////////////////////////////////////////METHODS//////////////////////////////////////////
    public void addComment(){
        Comment newComment = new Comment( content);
    }
    public void addReply(String content){
       Reply reply= new Reply(content);
       userReplies.add(reply);
    }
    public void addReaction(){
        counterLikes++;
    }
    public List<Reply> getUserReplies(){
        return userReplies;
    }

    public void editContent(String newContent){
            setContent(newContent);
            System.out.println("Comment edited");
    }


    public void deleteContent(){
            setContent(null);
            System.out.println("Comment deleted");
    }

    @Override
    public void addReact() {
        cntReacts++;
    }

    @Override
    public int getReacts() {
        return cntReacts;
    }
}
