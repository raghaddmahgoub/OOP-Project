
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type show whitespaces,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static  ArrayList<User> vec = new ArrayList<>();
    public static  ArrayList<FriendShip> friendship = new ArrayList<>();
    public static  ArrayList<User> friends = new ArrayList<User>();
    public static  ArrayList<User> not_friends = new ArrayList<User>();

    public static void populate_friends(){
        friends.add(new User("aaa", "kjfnkjewnkle"));
        friends.add(new User("ggg", "jkfnlksnksdlc"));
        friends.add(new User("hhhh", "ladjdljsldclds"));
        friends.add(new User("uuu", "odihdknsdkj"));
    }
    public static void populate_not_friends(){
        not_friends.add(new User("rrr", "kjfnkjewnkle"));
        not_friends.add(new User("ssss", "jkfnlksnksdlc"));
        not_friends.add(new User("dddd", "ladjdljsldclds"));
        not_friends.add(new User("www", "odihdknsdkj"));
    }
    public static void main(String[] args) {
        vec.add(new User("renad", "123"));
        vec.add(new User("haneen", "4562"));
        vec.add(new User("rrr", "kjfnkjewnkle"));
        vec.add(new User("ssss", "jkfnlksnksdlc"));
        vec.add(new User("dddd", "ladjdljsldclds"));
        vec.add(new User("www", "odihdknsdkj"));
        vec.get(0).addFriend(vec.get(1));
        vec.get(0).addFriend(vec.get(2));
        vec.get(0).addFriend(vec.get(3));
        vec.get(0).addFriend(vec.get(4));
        vec.get(0).addFriend(vec.get(5));
        vec.get(1).addFriend(vec.get(2));
        vec.get(1).addFriend(vec.get(3));
        vec.get(1).addFriend(vec.get(41));

        UserInterface.ProgramStart();
    }
}
