import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Postnotification extends Notification{
    Post post;
    User friend;
    Scanner in = new Scanner(System.in);

    public Postnotification(Post post,User friend) {
        this.post = post;
        this.friend=friend;
        TimeStamp= Timestamp.valueOf(LocalDateTime.now());
    }

    public void tagging(){
        System.out.println(getTimeStamp());
        System.out.println(friend.getUserName()+" tagged u in a post");
        System.out.println("open notification ? y or n");
       if (in.next().equals('y')||in.next().equals('Y'))
           friend.getPost(post.getId()).Expandpost(friend,post);
    }
    public void commenting(){
        System.out.println(getTimeStamp());
        System.out.println(friend.getUserName()+" commented  on your post");
        System.out.println("open notification ? y or n");
        if (in.next().equals('y')||in.next().equals('Y')) {
            post.Expandpost(friend,post);
        }
    }
    public void replying(){
        System.out.println(getTimeStamp());
        System.out.println(friend.getUserName()+" replied  on your comment");
        System.out.println("open notification ? y or n");
        if (in.next().equals('y')||in.next().equals('Y')) {
            post.Expandpost(friend,post);
        }
    }
    public void liking(){
        System.out.println(getTimeStamp());
        System.out.println(friend.getUserName()+" liked on sth u did");
        System.out.println("open notification ? y or n");
        if (in.next().equals('y')||in.next().equals('Y')) {
            post.Expandpost(friend,post);
        }
    }
}
