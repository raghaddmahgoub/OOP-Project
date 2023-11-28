import java.time.LocalDateTime;
import java.util.List;

public class Reply extends Comment{
    private int replyID;
    public Reply(int id, int userId, String content, LocalDateTime timestamp, int cntReacts, List<Reply> userreplies) {
        super(id, userId, content, timestamp, cntReacts, userreplies);
    }
}
