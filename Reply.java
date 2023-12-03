import java.time.LocalDateTime;
import java.util.List;

public class Reply extends Comment{
    private int replyID;

    public Reply(User authorId, String content) {
        super(authorId, content);
        replyID++;
    }
}

