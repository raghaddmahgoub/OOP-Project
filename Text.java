import java.sql.Timestamp;
import java.time.LocalDateTime;

public abstract class Text {


    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    protected int Id;
    protected int userId;

    public String getContent() {
        return content;
    }

    protected String content;
    protected Timestamp timestamp;
    protected int cntReacts=0;
    //////////////////////////////////////////**CONSTRUCTORS**///////////////////////////////////////////
    public Text(int id) {
        this.Id = id;
    }
    public Text(String content){
        this.content=content;
    }
    public Text(){}

    ////////////////////////////////////////////**METHODS**//////////////////////////////////////////
    public int getId() {
        return Id;
    }

    public int getUserId() {
        return userId;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void displayContent() {
        System.out.println(content);
    }



    public abstract void addReact();

    public abstract int getReacts();
}
