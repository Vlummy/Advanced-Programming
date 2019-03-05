package friend_app.friend;

import friend_app.linked_list.LinkedList;
import friend_app.linked_list.ListInterface;

/**
 * Class Friend: A Class representing a friend_app.friend. This class extends Person
 * Author: Roy H. Jensen, Øyvind Johannessen
 * Version: 1.0
 */
public class Friend extends Person {
    private FriendList<Person> friends;

    public Friend(String firstName, String lastName, Integer birthYear, Integer birthMonth, Integer birthDay, char gender) {
        super(firstName, lastName, birthYear, birthMonth, birthDay, gender);
    }

    public FriendList<Person> getFriendsList() {
        return friends;
    }

    public void setFriendsList(FriendList friendsList) {
        friends = friendsList;
    }
}
