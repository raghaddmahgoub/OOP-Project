import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Postnotification extends Notification{
    Post post;
    User friend;

    public Postnotification(Post post,User friend) {
        this.post = post;
        this.friend=friend;
        TimeStamp= Timestamp.valueOf(LocalDateTime.now());
    }
    public void tagging(int postId){
        System.out.println(friend.getUserName()+" tagged u in a post");
       friend.getPost(postId).displayContent();
    }
    public void commenting(){
        System.out.println(friend.getUserName()+" commented  on your post");
        //index ->
        post.Expandpost();
        post.getComments();
    }
    public void replying(int commentId){
        System.out.println(friend.getUserName()+" replied  on your comment");
        post.Expandpost();
        post.getComment(commentId).getUserReplies();
    }
    public void liking(){
        System.out.println(friend.getUserName()+" liked your post");
        post.Expandpost();
        post.getReacts();
    }

}
