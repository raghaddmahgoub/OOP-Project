import java.time.LocalDateTime;
import java.util.List;

public class Reply extends Comment{
    private int replyID;
    private int replyreaction;

    public Reply(User authorID, String content) {
        super(authorID, content);
        replyID++;
    }
    public int getReplyID() {
        return replyID;
    }

    public void setReplyID(int replyID) {
        this.replyID = replyID;
    }

    @Override
    public void addReaction() {
        replyreaction++;
    }
    public int getReplyreaction() {
        return replyreaction;
    }
    public String toString(){
        return getReplyID() + "replied to " +getAuthorID().getUserName() + "at" + getTimestamp() + "likes: " + getReplyreaction();
    }
}