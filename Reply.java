import java.time.LocalDateTime;
import java.util.List;

public class Reply extends Text{
    private int replyID;
    //pair between reply and the user
    private int replyreaction;

    public Reply( String content) {
        super(content);
        replyID++;
    }
    public int getReplyID() {
        return replyID;
    }
    public void setReplyID(int replyID) {
        this.replyID = replyID;
    }
    @Override
    public void addReact() {
        replyreaction++;
    }

    @Override
    public int getReacts() {
        return replyreaction;
    }

}
