package friend_app;

import friend_app.friend.Friend;
import friend_app.friend.FriendList;
import friend_app.friend.Person;
import friend_app.linked_list.ListInterface;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Friend person1 = new Friend("Roy", "Jensen", 1988, 6, 12, 'M');
        Friend person2 = new Friend("Øyvind", "Johannessen", 1989, 4, 7, 'M'); // The main person
        Friend person3 = new Friend("Ida", "Kvamme", 1991, 9, 20, 'F');
        Friend person4 = new Friend("Per", "Sandberg", 1900, 5, 25, 'M');
        Friend person5 = new Friend("Tormod", "Lerøy", 1854, 5, 2, 'M');

        FriendList friendList = new FriendList();
        person2.setFriendsList(friendList);

        person2.getFriendsList().add(person1);
        person2.getFriendsList().add(person3);
        person2.getFriendsList().add(person4);
        person2.getFriendsList().add(person5);

        System.out.println(person2.getFirstName() + " " + person2.getLastName() + " has " + person2.getFriendsList().getLength() + " friends.");

        Person removedPerson = person2.getFriendsList().remove(person4);
        System.out.println(" -" + removedPerson.getFirstName() + " " + removedPerson.getLastName() + " has been removed from the list");
        System.out.println("Now " + person2.getFirstName() + " " + person2.getLastName() + " only have " + person2.getFriendsList().getLength() + " friends left.");
        System.out.println(" ");
        System.out.println("Those friends are: ");

        Iterator iterFriends = person2.getFriendsList().getIterator();
        while(iterFriends.hasNext()) {
            System.out.println(((Friend) iterFriends.next()).getFirstName());
        }

        System.out.println(" ");

        Friend person6 = new Friend("Jean Luke", "Picard", 2305, 7, 13, 'M');
        person2.getFriendsList().add(person6);

        System.out.println(person2.getFirstName() + " " + person2.getLastName() + " suddenly found a new friend. This persons name is " + person6.getFirstName() + " " + person6.getLastName() +
                " and he is from the future, so yee, his age is... " + person6.getAge() + " years young?");

        System.out.println(person2.getFirstName() + " now has " + person2.getFriendsList().getLength() + " friends again.");

        Iterator iterFriends2 = person2.getFriendsList().getIterator();
        while(iterFriends2.hasNext()) {
            Friend friend = (Friend) iterFriends2.next();
            System.out.println(friend.getFirstName() + " " + friend.getLastName());
        }
        System.out.println(" ");
        System.out.println(person6.getLastName() + ": 'Grand! ... (small pause) ... Engade!'");

        person2.getFriendsList().sort();

    }
}
