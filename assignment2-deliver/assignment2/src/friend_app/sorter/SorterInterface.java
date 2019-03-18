package friend_app.sorter;

import friend_app.linked_list.ListInterface;


public interface SorterInterface {
    /**
     * Sorting a ListInterface based on their nodes.
     * @return ListInterface containing the sorted list of nodes.
     */
    ListInterface sort();
}
