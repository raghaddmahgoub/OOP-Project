import java.time.LocalDateTime;
import java.util.List;

public class Reply extends Text{
    /////////////////////////////////////////ATTRIBUTES//////////////////////////////////

    //pair between reply and the user
    private int replyreaction;

    public Reply( String content) {
        super(content);
        Id++;
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
