package friend_app;

import friend_app.friend.Friend;
import friend_app.friend.FriendList;
import friend_app.friend.Person;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Friend person1 = new Friend("Roy", "Jenssen", 1988, 6, 12, 'M');
        Friend person2 = new Friend("Øyvind", "Johannessen", 1989, 4, 7, 'M'); // The main person
        Friend person3 = new Friend("Ida", "Kvamme", 1991, 9, 20, 'F');
        Friend person4 = new Friend("Per", "Sandberg", 1900, 5, 25, 'M');
        Friend person5 = new Friend("Tormod", "Lerøy", 1854, 5, 2, 'M');
        Friend person6 = new Friend("Elon", "Musk", 1971, 6, 28, 'M');
        Friend person7 = new Friend("Jessica", "Alba", 1981, 4, 28, 'F');
        Friend person8 = new Friend("Tim", "Apple", 1960, 11, 1, 'M');
        Friend person9 = new Friend("Selena", "Gomez", 1992, 7, 22, 'F');
        Friend person10 = new Friend("Ellen", "DeGeneres", 1958, 1, 26, 'F');
        Friend person11 = new Friend("Kristen", "Bell", 1980, 7, 18, 'F');
        Friend person12 = new Friend("Nicholas", "Cage", 1964, 1, 7, 'M');

        person2.setFriendsList(new FriendList());

        person2.getFriendsList().add(person1);
        person2.getFriendsList().add(person3);
        person2.getFriendsList().add(person4);
        person2.getFriendsList().add(person5);
        person2.getFriendsList().add(person6);
        person2.getFriendsList().add(person7);
        person2.getFriendsList().add(person8);
        person2.getFriendsList().add(person9);
        person2.getFriendsList().add(person10);
        person2.getFriendsList().add(person11);
        person2.getFriendsList().add(person12);

        System.out.println(person2.getFirstName() + " " + person2.getLastName() + " has " + person2.getFriendsList().getLength() + " friends.");

        Person removedPerson = person2.getFriendsList().remove(person5);

        System.out.println(" -" + removedPerson.getFirstName() + " " + removedPerson.getLastName() + " has been removed from the list");
        System.out.println("Now " + person2.getFirstName() + " " + person2.getLastName() + " only have " + person2.getFriendsList().getLength() + " friends left.");
        System.out.println(" ");
        System.out.println("Those friends are: ");

        Iterator iterFriends = person2.getFriendsList().getIterator();
        while(iterFriends.hasNext()) {
            System.out.println(((Friend) iterFriends.next()).getFirstName());
        }

        System.out.println(" ");

        Friend person13 = new Friend("Jean Luke", "Picard", 2305, 7, 13, 'M');
        person2.getFriendsList().add(person13);

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
