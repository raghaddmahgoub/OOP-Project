import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comment extends Text{
    ////////////////////////////////////////////ATTRIBUTES//////////////////////////////////////
    private List<Reply> userReplies;
    private static int Id=0;

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    private int commentId;
    //////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////
    public Comment( String content) {
        this.cntReacts = 0;
        commentId=Id;
        Id++;
        this.userReplies = new ArrayList<>();
        this.content =content;

    }

////////////////////////////////////////////METHODS///////////////////////////////////////////
    public void addReply(Reply newReply){
        userReplies.add(newReply);
    }
    public int getId(){
        return commentId;
    }
    public List<Reply> getUserReplies(){
        return userReplies;
    }
    public Reply getReply(int replyId){
        return getUserReplies().get(replyId);
    }


    public void editReply(int replyId,String newContent){
        getReply(replyId).setContent(newContent);
        System.out.println("Reply edited");
    }

    public void deleteReply(int replyId){
       getUserReplies().remove(getReply(replyId));
        System.out.println("Reply deleted");
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
