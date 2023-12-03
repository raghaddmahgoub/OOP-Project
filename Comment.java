import java.util.List;

public class Comment extends Text{

    private List<Reply> userReplies;
    private int counterLikes;
    private User authorID;


    public Comment(int userId, List<Reply> userReplies) {
        super(id++, userId, cntReacts);
        this.userReplies = userReplies;
    }

    public void addComment(){

    }
    public void addReply(Reply reply){
    userReplies.add(reply);
    }
    public void addReaction(){
    counterLikes++;
    }
    public List<Reply> getUserReplies(){
    return userReplies;
    }
    public void editContent(String newContent){

    }
    public void deleteContent(){

    }
    public void getReaction(){

    }
    public String getContent(){

        return null;
    }
    @Override
    public void addReact() {
        cntReacts++;
    }

    @Override
    public int getReacts() {
        return cntReacts;
    }

}
