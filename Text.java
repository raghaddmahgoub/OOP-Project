import java.time.LocalDateTime;

public abstract class Text {
    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    private int Id;
    private int userId;
    private String content;
    private LocalDateTime timestamp;
    protected int cntReacts;
   //////////////////////////////////////////**CONSTRUCTORS**///////////////////////////////////////////
    public Text(int id, int userId, String content, LocalDateTime timestamp, int cntReacts) {
        Id = id;
        this.userId = userId;
        this.content = content;
        this.timestamp = timestamp;
        this.cntReacts = cntReacts;
    }

    ////////////////////////////////////////////**METHODS**//////////////////////////////////////////
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public abstract void   addReact(Post post, int postId);
    public  abstract int getReact();
}
