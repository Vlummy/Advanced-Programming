package test;

import friend_app.friend.Friend;
import friend_app.friend.FriendList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FriendListTest {

    @Test
    void sort() {
        Friend person1 = new Friend("Roy", "Jenssen",1987,10,14,'M');
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

        person1.setFriendsList(new FriendList());   //Sort 0 friends
        person1.setFriendsList(person1.getFriendsList().sort());


        person2.setFriendsList(new FriendList());   //Sort 1 friend
        person2.getFriendsList().add(person1);
        person2.setFriendsList(person2.getFriendsList().sort());


        person3.setFriendsList(new FriendList());   //Sort 2 friends
        person3.getFriendsList().add(person4);
        person3.getFriendsList().add(person5);
        person3.setFriendsList(person3.getFriendsList().sort());


        person4.setFriendsList(new FriendList());   //Sort decent amount of EVEN number entries
        person4.getFriendsList().add(person1);
        person4.getFriendsList().add(person2);
        person4.getFriendsList().add(person3);
        person4.getFriendsList().add(person5);
        person4.getFriendsList().add(person6);
        person4.getFriendsList().add(person7);
        person4.getFriendsList().add(person8);
        person4.getFriendsList().add(person9);
        person4.getFriendsList().add(person10);
        person4.getFriendsList().add(person11);
        person4.getFriendsList().add(person12);

        person4.setFriendsList(person4.getFriendsList().sort());


        person5.setFriendsList(new FriendList());   //Sort decent amount of ODD number entries
        person5.getFriendsList().add(person1);
        person5.getFriendsList().add(person2);
        person5.getFriendsList().add(person3);
        person5.getFriendsList().add(person4);
        person5.getFriendsList().add(person6);
        person5.getFriendsList().add(person7);
        person5.getFriendsList().add(person8);
        person5.getFriendsList().add(person9);
        person5.getFriendsList().add(person10);
        person5.getFriendsList().add(person11);

        person5.setFriendsList(person5.getFriendsList().sort());


    }

}