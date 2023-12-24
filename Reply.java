import java.time.LocalDateTime;
import java.util.List;

public class Reply extends Text{
    /////////////////////////////////////////ATTRIBUTES//////////////////////////////////
   private static int Id=0;
   private int replyId;
    public Reply(String content) {
        replyId=Id;
        Id++;
        this.content=content;
    }

    public int getId() {
        return replyId;}

    @Override
    public void addReact() {
        cntReacts++;
    }

    @Override
    public int getReacts() {
        return cntReacts;
    }

}
