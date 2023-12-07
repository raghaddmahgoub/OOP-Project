import java.time.LocalDateTime;
import java.util.List;

public class Reply extends Text{
    private static int replyID;

    private int reaction;

    public Reply( String content) {
        super(content);

        replyID++;
    }

    @Override
    public void addReact() {
        reaction++;
    }

    @Override
    public int getReacts() {
        return reaction;
    }
}

