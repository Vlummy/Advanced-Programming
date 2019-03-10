package friend_app.friend;

/**
 * Class Friend: A Class representing a friend_app.friend. This class extends Person
 * Author: Roy H. Jenssen, Øyvind Johannessen
 * Version: 1.0
 */
public class Friend extends Person {
    private FriendList friends;

    /**
     * Constructor for this class
     * @param firstName
     * @param lastName
     * @param birthYear
     * @param birthMonth
     * @param birthDay
     * @param gender
     */
    public Friend(String firstName, String lastName, Integer birthYear, Integer birthMonth, Integer birthDay, char gender) {
        super(firstName, lastName, birthYear, birthMonth, birthDay, gender);
    }

    /**
     * Return this persons friends
     * @return
     */
    public FriendList getFriendsList() {
        return friends;
    }

    /**
     * Sets a new friend list for this person
     * @param friendsList
     */
    public void setFriendsList(FriendList friendsList) {
        friends = friendsList;
    }

}
