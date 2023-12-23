import java.time.LocalDateTime;
import java.util.List;

public class Reply extends Text{
    /////////////////////////////////////////ATTRIBUTES//////////////////////////////////
   private static int replyId=0;
    public Reply(String content) {
        replyId++;
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
