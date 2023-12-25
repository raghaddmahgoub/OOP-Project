import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type show whitespaces,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static ArrayList<User> vec = new ArrayList<>();
    public static ArrayList<FriendShip> Friendships = new ArrayList<>();
    public static ArrayList<User> friends = new ArrayList<User>();
    public static ArrayList<User> not_friends = new ArrayList<User>();



    public static void main(String[] args) {
        //Data.readData();
        vec.add(new User("renad", "1","njvwjvgww@frgregr"));
        vec.add(new User("haneen", "2","njvwjvgww@frgregr"));
        vec.add(new User("menna", "3"));
        vec.add(new User("omar", "4"));
        vec.add(new User("farah", "5"));
        vec.add(new User("raghad", "6"));
        //
        vec.get(0).addFriend(vec.get(1));
        vec.get(1).addFriend(vec.get(0));
        FriendShip f1 = new FriendShip(vec.get(0), vec.get(1));
        f1.setFriendship_status("Accepted");
        Friendships.add(f1);
        //
        vec.get(0).addFriend(vec.get(2));
        vec.get(2).addFriend(vec.get(0));
        FriendShip f2 = new FriendShip(vec.get(0), vec.get(2));
        f2.setFriendship_status("Accepted");
        Friendships.add(f2);
        //
        vec.get(0).addFriend(vec.get(3));
        vec.get(3).addFriend(vec.get(0));
        FriendShip f3 = new FriendShip(vec.get(0), vec.get(3));
        f3.setFriendship_status("Accepted");
        Friendships.add(f3);
        //
        UserInterface.ProgramStart();
    }
    }



