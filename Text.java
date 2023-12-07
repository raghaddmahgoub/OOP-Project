import java.time.LocalDateTime;

public abstract class Text {


    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    protected int Id;
    protected int userId;
    protected String content;
    protected LocalDateTime timestamp;
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

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public LocalDateTime getTimestamp() {
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
