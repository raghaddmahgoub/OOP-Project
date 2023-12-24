import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.Timestamp;
public abstract class Text {

    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    protected int Id;
    protected User author;
    protected String content;
    protected Timestamp timestamp;

    public void setCntReacts(int cntReacts) {
        this.cntReacts = cntReacts;
    }

    protected int cntReacts=0;
    //////////////////////////////////////////**CONSTRUCTORS**///////////////////////////////////////////
    public Text(int id) {
        this.Id = id;
    }

    public Text(){}

    ////////////////////////////////////////////**METHODS**//////////////////////////////////////////
    public int getId() {
        return Id;
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
    public String getContent(){return content;}
    public void displayContent() {
        System.out.println(content);
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    public abstract void addReact();

    public abstract int getReacts();
}
