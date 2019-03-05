package friend_app.friend;

import friend_app.linked_list.LinkedList;
import friend_app.linked_list.ListInterface;
import friend_app.sorter.SorterInterface;

public class FriendList<Friend> extends LinkedList<Friend> implements SorterInterface {
    @Override
    public FriendList<Friend> sort() {
        // sort this list
        return this;
    }
}
