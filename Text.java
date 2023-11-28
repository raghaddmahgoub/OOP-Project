import java.time.LocalDateTime;

public abstract class Text {


    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    protected int Id;
    protected int userId;
    protected String content;
    protected LocalDateTime timestamp;
    //protected Reply reply;
    protected int cntReacts=0;
   //////////////////////////////////////////**CONSTRUCTORS**///////////////////////////////////////////
    public Text(int id) {
        this.Id = id;


    }

    ////////////////////////////////////////////**METHODS**//////////////////////////////////////////
    public int getId() {
        return Id;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getCntReacts() {
        return cntReacts;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public abstract void   addReact(Post post);
    public  abstract int getReact();
}
