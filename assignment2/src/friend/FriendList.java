package friend;
import linked_list.LinkedList;
import linked_list.ListInterface;

/**
 * Class FriendList: A Class for storing, removing and sorting friends
 * Author: Roy H. Jensen, Øyvind Johannessen
 * Version: 1.0
 */
public class FriendList {

    private ListInterface<Friend> friendList;

    /**
     * Constructor: Instantiates a new empty friendList
     */
    public FriendList() {
        friendList = new LinkedList<>();
    }
}
