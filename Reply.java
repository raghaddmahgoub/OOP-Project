import java.time.LocalDateTime;
import java.util.List;

public class Reply extends Text{
    /////////////////////////////////////////ATTRIBUTES//////////////////////////////////

   private static int replyId;
    private int replyreaction;

    public Reply(String content) {
        super(replyId++);
        this.content=content;
    }

    public int getReplyID() {
        return Id;
    }
    public void setReplyID(int replyID) {
        this.Id = replyID;
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
