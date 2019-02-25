package friend_app.linked_list;

/**
 * Node class for a LinkedList. This class can reference a new Node and hold a dataItem of any type.
 * Author: Øyvind Johannessen, Roy H. Jensen
 * Version: 1.0
 */
public class Node<T> {
    protected T dataItem; // The entry in a list
    protected Node next; // Links to the next node who contains another data and possible next node

    /**
     * Constructor for node class. Set's the dataItem to dataItem parameter and next node to null
     * @param dataItem the item to which the Node should hold
     */
    protected Node(T dataItem) {
        this.dataItem = dataItem;
        this.next = null;
    }

    /**
     * Constructor for node class. Set's the dataItem to dataItem parameter
     * @param dataItem the item to which the Node should hold
     */
    protected Node(T dataItem, Node next) {
        this.dataItem = dataItem;
        this.next = next;
    }
}
